package pl.kostrzynski.speechrecognitiontool.api;

import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import pl.kostrzynski.speechrecognitiontool.model.PhraseInfo;
import pl.kostrzynski.speechrecognitiontool.model.Sens;
import pl.kostrzynski.speechrecognitiontool.service.LanguageRecognition;
import pl.kostrzynski.speechrecognitiontool.service.Lexicon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/phrase", produces = MediaType.APPLICATION_JSON_VALUE)
public class Api {

    private LanguageRecognition languageRecognition;
    private Lexicon lexicon;

    @Autowired
    public Api(LanguageRecognition languageRecognition, Lexicon lexicon) {
        this.languageRecognition = languageRecognition;
        this.lexicon = lexicon;
    }

    @GetMapping("/phraseinfo")
    public ResponseEntity<PhraseInfo> getPhraseInfo(@RequestBody String phrase) throws APIError {
        String keyword = "";
        phrase = phrase.trim();
        if (phrase.contains(" ")) {
            keyword = findTheKeyword(phrase);
            if (keyword == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Result result = getResult(keyword);
        if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return getDefinitions(keyword, result);
    }

    private String findTheKeyword(String phrase) {
        String keyword = "";
        try {
            String[] words = phrase.replaceAll("\\p{Punct}", "").split("\\s+");
            keyword = Arrays.stream(words).filter(e -> e.toUpperCase().equals(e)).findFirst().get();

        } catch (NoSuchElementException e) {
            return null;
        }
        return keyword.trim().toLowerCase();
    }

    private Result getResult(String phrase) throws APIError {
        Result result = new Result();
        List<Result> results = languageRecognition.getRecognitionResult(phrase);
        if (results != null) {
            result = results.stream().findFirst().get();
        } else return null;
        return result;
    }

    private ResponseEntity<PhraseInfo> getDefinitions(String phrase, Result result) {
        List<String> descriptions = new ArrayList<>();
        List<Sens> lexiconInfo = lexicon.getLexiconInfo(result.language, phrase);
        if (lexiconInfo != null) {
            for (Sens sens : lexiconInfo) {
                descriptions.add(sens.getDefinition().substring(0, 1).toUpperCase() + sens.getDefinition().substring(1));
            }
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new PhraseInfo(result, phrase, descriptions), HttpStatus.ACCEPTED);
    }

    @ExceptionHandler({APIError.class, IllegalArgumentException.class})
    public ResponseEntity<HttpStatus> errorMethod() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
