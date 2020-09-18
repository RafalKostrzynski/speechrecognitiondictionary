package pl.kostrzynski.speechrecognitiontool.model;

import com.detectlanguage.Result;

import java.util.List;

public class PhraseInfo {

    private Result languageRecognitionResult;
    private String word;
    private List<String> descriptions;

    public PhraseInfo(Result languageRecognitionResult, String word, List<String> descriptions) {
        this.languageRecognitionResult = languageRecognitionResult;
        this.word = word;
        this.descriptions = descriptions;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Result getLanguageRecognitionResult() {
        Result result = new Result();
        result.isReliable = languageRecognitionResult.isReliable;
        result.confidence = languageRecognitionResult.confidence;
        result.language = languageRecognitionResult.language;
        return result;
    }

    public void setLanguageRecognitionResult(Result languageRecognitionResult) {
        this.languageRecognitionResult = languageRecognitionResult;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }
}
