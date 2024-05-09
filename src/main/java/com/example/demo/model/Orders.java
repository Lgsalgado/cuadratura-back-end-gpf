package com.example.demo.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Orders {
    @Id
    private String orderNo;
    private Double total;
    private String status;

}