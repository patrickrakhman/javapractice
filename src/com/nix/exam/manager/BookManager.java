package com.nix.exam.manager;

import com.nix.exam.entity.Book;

public interface BookManager {
    void create(Book book);
    Book readById(String id);
    void readAll();
    void update(Book book);
    void delete(String id);
    void findAuthorsByBook(String bookName);
}
