package com.nix.exam.manager;

import com.nix.exam.dao.BookDao;
import com.nix.exam.dao.BookInMemoryDao;
import com.nix.exam.entity.Book;

public class BookManagerImpl implements BookManager {
    private final BookDao bookDao = new BookInMemoryDao();

    @Override
    public void create(Book book) {
        bookDao.create(book);
    }

    @Override
    public void readAll() {
        bookDao.readAll();
    }

    @Override
    public Book readById(String id) {
        existBook(id);
        return bookDao.readById(id);
    }

    @Override
    public void update(Book book) {
        existBook(book.getId());
        bookDao.update(book);
    }

    @Override
    public void delete(String id) {
        existBook(id);
        bookDao.delete(id);
    }

    @Override
    public void findAuthorsByBook(String bookName) {
        bookDao.findAuthorsByBook(bookName);
    }

    private void existBook(String id) {
        Book book = bookDao.readById(id);
        if (book == null) {
            throw new RuntimeException("404");
        }
    }
}
