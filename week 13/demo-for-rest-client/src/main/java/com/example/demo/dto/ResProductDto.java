package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResProductDto {

    private Integer id;
    private String name;
    private String description;
    private Double price;

}
