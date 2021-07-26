package com.nix.exam.dao;

import com.nix.exam.entity.Book;

public interface BookDao {
    void create (Book book);
    void readAll();
    Book readById(String id);
    void update(Book book);
    void delete(String id);
    void findAuthorsByBook(String bookName);
}
