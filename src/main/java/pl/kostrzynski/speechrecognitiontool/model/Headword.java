package pl.kostrzynski.speechrecognitiontool.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Headword {
    @JsonProperty("text")
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String text;

    @JsonProperty("pos")
    public String getPos() {
        return this.pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    String pos;
}