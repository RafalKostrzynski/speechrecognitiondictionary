package pl.kostrzynski.speechrecognitiontool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sens {
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    @JsonProperty("definition")
    public String getDefinition() {
        return this.definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    String definition;
}