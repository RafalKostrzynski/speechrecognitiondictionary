package pl.kostrzynski.speechrecognitiontool.service;

import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Creater {
    private LanguageRecognition languageRecognition;

    public Creater(LanguageRecognition languageRecognition) throws APIError {
        this.languageRecognition = languageRecognition;

        List<Result> results = languageRecognition.getRecognitionResult();
    }
}
