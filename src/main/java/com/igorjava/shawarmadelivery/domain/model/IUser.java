package com.igorjava.shawarmadelivery.domain.model;

public interface IUser {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    String getTelegram();

    void setTelegram(String telegram);

    String getPhone();

    void setPhone(String phone);

    String getAddress();

    void setAddress(String address);
}
