package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dtos.UserDTO;
import com.bookself.bookself_api.models.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setBio(user.getBio());
        dto.setProfilePhotoUrl(user.getProfilePhotoUrl());
        dto.setRole(user.getRole().name());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setBio(dto.getBio());
        user.setProfilePhotoUrl(dto.getProfilePhotoUrl());
        // Role should be assigned in service layer
        return user;
    }
}