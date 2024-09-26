package com.bookself.bookself_api.models;

public enum ReadingStatus {

            TO_READ("To-read"),
            READING("Reading"),
           FINISHED("Finished");

    private final String readingStatus;

    ReadingStatus(String readingStatus) {
        this.readingStatus = readingStatus;
    }

    public String getReadingStatus() {
        return readingStatus;
    }
}
