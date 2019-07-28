package com.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.Map;

/**
 * Created by Aidon on 19/7/28.
 */
public class ActivateUserDTO {
    @JsonProperty("card_id")
    private String card_id;
    @JsonProperty("service_statement")
    private Map<String,Object> service_statement;
    @JsonProperty("required_form")
    private Map<String,Object> required_form;
    @JsonProperty("optional_form")
    private Map<String,Object> optional_form;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public Map<String, Object> getService_statement() {
        return service_statement;
    }

    public void setService_statement(Map<String, Object> service_statement) {
        this.service_statement = service_statement;
    }

    public Map<String, Object> getRequired_form() {
        return required_form;
    }

    public void setRequired_form(Map<String, Object> required_form) {
        this.required_form = required_form;
    }

    public Map<String, Object> getOptional_form() {
        return optional_form;
    }

    public void setOptional_form(Map<String, Object> optional_form) {
        this.optional_form = optional_form;
    }

    @Override
    public String toString() {
        return "ActivateUserDTO{" +
                "card_id='" + card_id + '\'' +
                ", service_statement=" + service_statement +
                ", required_form=" + required_form +
                ", optional_form=" + optional_form +
                '}';
    }
}
