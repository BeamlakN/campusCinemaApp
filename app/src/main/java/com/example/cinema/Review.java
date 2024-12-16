package com.example.cinema;

public class Review {
    private String reviewerName;
    private String reviewText;
    private String reviewDate;

    public Review(String reviewerName, String reviewText, String reviewDate) {
        this.reviewerName = reviewerName;
        this.reviewText = reviewText;
        this.reviewDate = reviewDate;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getReviewDate() {
        return reviewDate;
    }
}

