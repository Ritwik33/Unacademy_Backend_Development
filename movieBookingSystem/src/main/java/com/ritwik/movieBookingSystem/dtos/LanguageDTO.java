package com.ritwik.movieBookingSystem.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageDTO {

    @JsonProperty(value = "language_id")
    private int languageId;

    @JsonProperty(value = "language_name")
    private String languageName;

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "LanguageDTO{" +
                "languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
