package com.viniciuspadovam.collabpro.domain.user;

public record RegisterUserDto(String firstName, String lastName, String email, String password, UserRoles role) {
}
