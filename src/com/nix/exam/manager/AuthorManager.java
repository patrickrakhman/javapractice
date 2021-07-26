package com.nix.exam.manager;

import com.nix.exam.entity.Author;

public interface AuthorManager {
    void create(Author author);
    void readAll();
    Author readById(String id);
    void update(Author author);
    void delete(String id);
    void findBooksByAuthor(String authorName);
}
