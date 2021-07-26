package com.nix.exam.entity;

import java.util.List;

public class Book {

    private String bookName;
    private String id;
    private List<String> authors;

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName) {

        this.bookName = bookName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", id=" + id +
                ", authors=" + authors +
                '}';
    }
}
