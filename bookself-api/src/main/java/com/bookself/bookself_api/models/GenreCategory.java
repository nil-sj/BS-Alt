package com.bookself.bookself_api.models;

public enum GenreCategory {

    FICTION("Fiction"),
    NON_FICTION("Non-Fiction"),
    OTHER("Other");

    private final String displayName;

    GenreCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

