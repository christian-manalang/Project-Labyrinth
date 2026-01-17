package com.labyrinth.labyrinth.logic.service;

import com.labyrinth.labyrinth.logic.model.Book;
import com.labyrinth.labyrinth.logic.model.Course;
import java.util.List;
import java.util.Calendar;

public class CourseService {

    // unit A database connection code

    // recalc stats for a specific course.
    // call when book is added, deleted, or edited.
    public void refreshCourseCompliance(String courseCode, List<Book> allBooks) {
        Course course = getCourseByCode(courseCode);
        if (course == null)
            return;

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int cutoffYear = currentYear - 5;

        int total = 0;
        int recent = 0;

        for (Book b : allBooks) {
            if (b.getCourseCodes().contains(courseCode)) {
                total++;
                if (b.getCopyrightYear() >= cutoffYear) {
                    recent++;
                }
            }
        }

        course.setTotalBooks(total);
        course.setRecentBookCount(recent);

        // temp, need Unit A setter
        // saveToDatabase(course);
        System.out.println("Updated " + courseCode + ": " + recent + " recent books.");

    }

    // temp, need Unit A db getter
    private Course getCourseByCode(String code) {
        Course dummy = new Course();
        dummy.setCourseCode(code);
        dummy.setCourseTitle("Test Course " + code);
        return dummy;
    }
}