package pl.kostrzynski.speechrecognitiontool.service;

import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Creator {
    private LanguageRecognition languageRecognition;

    public Creator(LanguageRecognition languageRecognition) throws APIError {
        this.languageRecognition = languageRecognition;

        List<Result> results = languageRecognition.getRecognitionResult();
    }
}
