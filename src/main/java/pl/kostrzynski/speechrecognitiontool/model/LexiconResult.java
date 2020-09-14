package pl.kostrzynski.speechrecognitiontool.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LexiconResult {
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @JsonProperty("language")
    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    String language;

    @JsonProperty("headword")
    public Headword getHeadword() {
        return this.headword;
    }

    public void setHeadword(Headword headword) {
        this.headword = headword;
    }

    Headword headword;

    @JsonProperty("senses")
    public List<Sens> getSenses() {
        return this.senses;
    }

    public void setSenses(List<Sens> senses) {
        this.senses = senses;
    }

    List<Sens> senses;
}