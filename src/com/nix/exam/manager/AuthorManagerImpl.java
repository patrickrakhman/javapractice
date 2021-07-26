package com.nix.exam.manager;

import com.nix.exam.dao.AuthorDao;
import com.nix.exam.dao.AuthorInMemoryDao;
import com.nix.exam.entity.Author;

public class AuthorManagerImpl implements AuthorManager{
    private final AuthorDao authorDao = new AuthorInMemoryDao();

    @Override
    public void create(Author author) {
        authorDao.create(author);
    }

    @Override
    public void readAll(){authorDao.readAll();}

    @Override
    public Author readById(String id) {
        existAuthor(id);
        return authorDao.readById(id);
    }

    @Override
    public void update(Author author) {
        existAuthor(author.getId());
        authorDao.update(author);
    }

    @Override
    public void delete(String id) {
        existAuthor(id);
        authorDao.delete(id);
    }
    @Override
    public void findBooksByAuthor(String authorName) {
        authorDao.findBooksByAuthor(authorName);
    }

    private void existAuthor(String id) {
        Author author = authorDao.readById(id);
        if (author == null) {
            throw new RuntimeException("404");
        }
    }
}
