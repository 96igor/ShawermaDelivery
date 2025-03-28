package com.igorjava.shawarmadelivery.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Delivery {
    private Long id;
    private String address;
    private LocalDateTime dateTime;
    private Order order;
}
