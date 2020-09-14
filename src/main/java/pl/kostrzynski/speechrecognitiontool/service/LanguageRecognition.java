package pl.kostrzynski.speechrecognitiontool.service;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageRecognition {

    @Value("${DETECTLANGUAGEAPIKEY}")
    private String detectLanguageApiKey;

    public List<Result> getRecognitionResult(String detectText) throws APIError {
        DetectLanguage.apiKey = detectLanguageApiKey;
        return DetectLanguage.detect(detectText);
    }
}
