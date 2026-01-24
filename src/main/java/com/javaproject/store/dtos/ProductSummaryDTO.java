package com.javaproject.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ProductSummaryDTO {
    private Long id;
    private String name;
}
