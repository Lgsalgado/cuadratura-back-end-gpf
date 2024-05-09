package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastInvoice {
    @JsonProperty("idPrcinstance")
    private int idPrcinstance;

    public int getIdPrcinstance() {
        return idPrcinstance;
    }

    public void setIdPrcinstance(int idPrcinstance) {
        this.idPrcinstance = idPrcinstance;
    }
}
