package com.labyrinth.labyrinth.logic.service;

import com.labyrinth.labyrinth.logic.model.Book;
import java.util.List;

public class BookService {

    private CourseService courseService = new CourseService();

    public void saveBook(Book newBook, List<Book> allBooks) {
        // add validation, unit B

        // temp, need Unit A setter
        // database.save(newBook);
        System.out.println("Book Saved: " + newBook.getTitle());

        // notify every course this book belongs to recount
        if (newBook.getCourseCodes() != null) {
            for (String code : newBook.getCourseCodes()) {
                courseService.refreshCourseCompliance(code, allBooks);
            }
        }
    }

    public void deleteBook(Book bookToDelete, List<Book> allBooks) {
        // temp, need Unit A setter
        // database.delete(bookToDelete);
        System.out.println("Book Deleted: " + bookToDelete.getTitle());

        // notify every course this book belongs to recount
        if (bookToDelete.getCourseCodes() != null) {
            for (String code : bookToDelete.getCourseCodes()) {
                courseService.refreshCourseCompliance(code, allBooks);
            }
        }
    }
}