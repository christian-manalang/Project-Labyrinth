package com.labyrinth.labyrinth.logic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String courseCode;
    private String courseTitle;

    // compliance
    private int totalBooks;
    private int recentBookCount; // copyrightYear >= (CurrentYear - 5)

    public boolean isCompliant() {
        return recentBookCount >= 5;
    }

    public int getTitlesNeeded() {
        int needed = 5 - this.recentBookCount;
        return (needed > 0) ? needed : 0;
    }
}