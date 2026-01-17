package com.labyrinth.labyrinth.logic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String title;
    private String author;
    private String publisher;
    private int copyrightYear; // copyright / year
    private String isbn;

    private String callNumber; // QA76.73 .J38
    private String accessionNumber;
    private String volumeNumber;
    private String titleNumber;

    // acquisition
    private String datePurchased;
    private String poDate; // purchase order date
    private String drNumber; // delivery receipt
    private String prNumber; // purchase request
    private String prDate;
    private String siNumber; // sales invoice
    private double siPrice;

    // tracking
    private String receivedBy;
    private String receivedDate;
    private String program; // SOIT or whatever

    private List<String> courseCodes = new ArrayList<>();

    // APA Citation helper
    public String getApaCitation() {
        return String.format("%s (%d). %s. %s.", author, copyrightYear, title, publisher);
    }
}