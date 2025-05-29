package com.igorjava.shawarmadelivery.presentation.service.dto;

import com.igorjava.shawarmadelivery.domain.model.User;

public class MapperDto {

    public User getUserFromDto(UserDto userDto) {
        return new User(
        userDto.getId(),
        userDto.getName(),
        userDto.getEmail(),
        userDto.getPassword(),
        userDto.getTelegram(),
        userDto.getPhone(),
        userDto.getAddress()
        );
    }
}
