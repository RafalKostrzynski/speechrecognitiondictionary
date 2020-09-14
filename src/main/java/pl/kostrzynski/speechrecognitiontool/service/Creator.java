package pl.kostrzynski.speechrecognitiontool.service;

import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;
import org.springframework.stereotype.Service;
import pl.kostrzynski.speechrecognitiontool.model.LexiconResult;

import java.util.List;

@Service
public class Creator {
    private LanguageRecognition languageRecognition;
    private Lexicon lexicon;

    public Creator(LanguageRecognition languageRecognition, Lexicon lexicon) throws APIError {
        this.languageRecognition = languageRecognition;
        this.lexicon = lexicon;

        List<Result> results = languageRecognition.getRecognitionResult("text for detection");
        System.out.println(results.get(0).isReliable);

        List<LexiconResult> lexiconResults = lexicon.getLexiconInfo("en","alphabet");
        for (LexiconResult element : lexiconResults) {
            System.out.println(element.getSenses().get(0).getDefinition());
        }
    }
}
