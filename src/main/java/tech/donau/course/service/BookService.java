package tech.donau.course.service;

import tech.donau.course.data.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;

@ApplicationScoped
public class BookService {

    public Book checkBook(@Valid Book book) {
        return book;
    }
}
