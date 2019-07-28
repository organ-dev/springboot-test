package com.example.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * Created by Aidon on 19/7/28.
 */
public class ActivateUserDTO {
    @JSONField(name = "card_id")
    private String cardId;
    @JSONField(name = "service_statement")
    private Map<String,Object> serviceStatement;
    @JSONField(name = "required_form")
    private Map<String,Object> requiredForm;
    @JSONField(name = "optional_form")
    private Map<String,Object> optionalForm;

    public String getCardId() {
        return cardId;
    }

    public void setCardd(String cardId) {
        this.cardId = cardId;
    }

    public Map<String, Object> getServiceStatement() {
        return serviceStatement;
    }

    public void setServiceStatement(Map<String, Object> serviceStatement) {
        this.serviceStatement = serviceStatement;
    }

    public Map<String, Object> getRequiredForm() {
        return requiredForm;
    }

    public void setRequiredForm(Map<String, Object> requiredForm) {
        this.requiredForm = requiredForm;
    }

    public Map<String, Object> getOptionalForm() {
        return optionalForm;
    }

    public void setOptionalForm(Map<String, Object> optionalForm) {
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
