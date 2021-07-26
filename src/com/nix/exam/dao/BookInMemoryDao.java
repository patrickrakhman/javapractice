package com.nix.exam.dao;

import com.nix.exam.entity.Book;

import java.util.*;

public class BookInMemoryDao implements BookDao {

    private final static List<Book> books = new ArrayList<>();

    @Override
    public void create(Book book) {
        book.setId(generateId());
        books.add(book);
    }

    @Override
    public void update(Book book) {
        Book current = readById(book.getId());
        current.setBookName(book.getBookName());
        current.setAuthors(book.getAuthors());
    }

    @Override
    public void delete(String id) {
        books.removeIf(profile -> profile.getId().equals(id));
    }

    @Override
    public void readAll() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public Book readById(String id) {
        return books.stream().filter(data -> data.getId().equals(id)).findFirst().get();
    }


    @Override
    public void findAuthorsByBook(String bookName) {
        Set<String> foundAuthors = new HashSet<String>();
        for (Book book : books) {
            if (bookName.equals(book.getBookName())) {
                foundAuthors.addAll((book.getAuthors()));
            }
        }
        foundAuthors.addAll(AuthorInMemoryDao.searchByBook(bookName));
        if (foundAuthors.size() == 0) {
            System.out.println("There is no authors for this book");

        } else {
            System.out.println("Authors are:");
            System.out.println(foundAuthors);
        }
    }

    public static Set<String> searchByAuthor(String authorName) {
        Set<String> foundBooks = new HashSet<String>();

        for (Book book : books) {
            for (String name : book.getAuthors()) {
                if (name.equals(authorName)) {
                    foundBooks.add(book.getBookName());
                }
            }
        }
        return foundBooks;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (books.stream().anyMatch(user -> user.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
