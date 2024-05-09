package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Builder
@ToString
public class History {
    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date updateDate;

    private String origin;
    private String actionURL;
    private Integer statusCode;
    private String statusDescription;
    private String statusName;
}
