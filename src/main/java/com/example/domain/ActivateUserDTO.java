package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by Aidon on 19/7/28.
 */
public class ActivateUserDTO {
    @JsonProperty("card_id")
    private String cardId;
    @JsonProperty("service_statement")
    private Map<String,String> serviceStatement;
    @JsonProperty("required_form")
    private Map<String,String> requiredForm;
    @JsonProperty("optional_form")
    private Map<String,String> optionalForm;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Map<String, String> getServiceStatement() {
        return serviceStatement;
    }

    public void setServiceStatement(Map<String, String> serviceStatement) {
        this.serviceStatement = serviceStatement;
    }

    public Map<String, String> getRequiredForm() {
        return requiredForm;
    }

    public void setRequiredForm(Map<String, String> requiredForm) {
        this.requiredForm = requiredForm;
    }

    public Map<String, String> getOptionalForm() {
        return optionalForm;
    }

    public void setOptionalForm(Map<String, String> optionalForm) {
        this.optionalForm = optionalForm;
    }

    @Override
    public String toString() {
        return "ActivateUserDTO{" +
                "cardId='" + cardId + '\'' +
                ", serviceStatement=" + serviceStatement +
                ", requiredForm=" + requiredForm +
                ", optionalForm=" + optionalForm +
                '}';
    }
}
