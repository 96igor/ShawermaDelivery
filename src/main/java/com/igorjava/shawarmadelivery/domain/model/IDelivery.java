package com.igorjava.shawarmadelivery.domain.model;

import java.time.LocalDateTime;

public interface IDelivery {
    Long getId();

    void setId(Long id);

    String getAddress();

    void setAddress(String address);

    String getPhone();

    void setPhone(String phone);

    LocalDateTime getDateTime();

    void setDateTime(LocalDateTime dateTime);

    Order getOrder();

    void setOrder(Order order);}
