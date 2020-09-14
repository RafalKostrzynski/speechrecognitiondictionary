package pl.kostrzynski.speechrecognitiontool.service;

import com.detectlanguage.errors.APIError;
import org.junit.jupiter.api.Test;


import com.detectlanguage.Result;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LanguageRecognitionTest {

    @Test
    public void languageRecognitionTest() throws APIError {
        List<Result> results = new ArrayList<>();
        Result result = new Result();
        result.language = "en";
        result.isReliable = true;
        result.confidence = 10.97;
        results.add(result);

        LanguageRecognition languageRecognition = mock(LanguageRecognition.class);
        when(languageRecognition.getRecognitionResult("text for detection")).thenReturn(results);

        assertEquals(results.get(0).isReliable,
                languageRecognition.getRecognitionResult("text for detection").get(0).isReliable);
    }

}