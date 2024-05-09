package com.example.demo.dto;
import com.example.demo.model.LastInvoice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentoDTO {

    @JsonProperty("lastInvoice")
    private LastInvoice lastInvoice;
    private long id;

}

