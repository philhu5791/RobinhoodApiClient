package com.hissmoo.robinhood.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Instrument {
    public String getCanonicalExamples() {
        return canonicalExamples;
    }

    public void setCanonicalExamples(String canonicalExamples) {
        this.canonicalExamples = canonicalExamples;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<String> instruments) {
        this.instruments = instruments;
    }

    @JsonProperty("canonical_examples")
    private String canonicalExamples;
    private String description;
    private List<String> instruments;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        for(String s : instruments){
//            sb.append(s);
//            sb.append("\n");
//        }
        sb.append("canonical_examples").append(canonicalExamples).append("description").append(description).append("instruments").append(instruments);
        return sb.toString();
    }
}
