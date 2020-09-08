package org.example.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    ADMIN("ADMIN"),
    MAIN_ADMIN("MAIN_ADMIN");

    private final String name;
}
