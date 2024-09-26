package com.bookself.bookself_api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ReadingProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "book_id", nullable = false)
//    private Book book;

    @Column(nullable = false)
    private int pagesRead;

    @Column(nullable = false)
    private int totalPages;

    @Column(nullable = false)
    private double progressPercentage;  // Can be calculated based on pagesRead/totalPages

    @Column(nullable = false)
    private LocalDateTime startedDate;

    private LocalDateTime completedDate;

    @Column(nullable = false)
    private LocalDateTime updatedDate;

    // Constructors
    public ReadingProgress() {
        this.updatedDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
        updateProgressPercentage();
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        updateProgressPercentage();
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public LocalDateTime getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(LocalDateTime startedDate) {
        this.startedDate = startedDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    // Method to update the progress percentage
    public void updateProgressPercentage() {
        if (totalPages > 0) {
            this.progressPercentage = (double) pagesRead / totalPages * 100;
        } else {
            this.progressPercentage = 0;
        }
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}