package com.nix.exam.dao;


import com.nix.exam.entity.Author;

import java.util.*;

public class AuthorInMemoryDao implements AuthorDao {


    private final static List<Author> authors = new ArrayList<>();

    @Override
    public void create(Author author) {
        author.setId(generateId());
        authors.add(author);
    }

    @Override
    public void update(Author author) {
        Author current = readById(author.getId());
        current.setName(author.getName());
        current.setName(author.getLastName());
        current.setBooks(author.getBooks());
    }

    @Override
    public void delete(String id) {
        authors.removeIf(user -> user.getId().equals(id));
    }


    @Override
    public void readAll() {
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    @Override
    public Author readById(String id) throws NoSuchElementException {
        for (Author data : authors) {
            if (data.getId().equals(id)) {
                return Optional.of(data).get();
            }
        }
        return Optional.<Author>empty().get();
    }

    @Override
    public void findBooksByAuthor(String authorName) {
        Set<String> foundBooks = new HashSet<String>();
        for (Author author : authors) {
            if (authorName.equals(author.getLastName())) {
                foundBooks.addAll((author.getBooks()));
            }
        }
        foundBooks.addAll(BookInMemoryDao.searchByAuthor(authorName));
        if (foundBooks.size() == 0) {
            System.out.println("This author doesn't have books");
        } else {
            System.out.println("Author has next books:");
            System.out.println(foundBooks);
        }
    }

    public static Set<String> searchByBook(String bookName) {
        Set<String> foundAuthors = new HashSet<String>();

        for (Author author : authors) {
            for (String name : author.getBooks()) {
                if (name.equals(bookName)) {
                    foundAuthors.add(author.getLastName());
                }
            }
        }
        return foundAuthors;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (authors.stream().anyMatch(user -> user.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
