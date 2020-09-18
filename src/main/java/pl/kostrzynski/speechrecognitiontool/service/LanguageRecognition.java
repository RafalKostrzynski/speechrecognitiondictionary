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
        List<Result> results = DetectLanguage.detect(detectText);
        if (isReliable(results)) return results;
        return null;
    }

    private boolean isReliable(List<Result> results) {
        return results.stream().anyMatch(e -> e.isReliable);
    }
}
