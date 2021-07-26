package com.nix.exam;

import com.nix.exam.entity.Author;
import com.nix.exam.entity.Book;
import com.nix.exam.manager.AuthorManager;
import com.nix.exam.manager.AuthorManagerImpl;
import com.nix.exam.manager.BookManager;
import com.nix.exam.manager.BookManagerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Controller {

    private final AuthorManager authorManager = new AuthorManagerImpl();
    private final BookManager bookManager = new BookManagerImpl();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("1:create author  ");
        System.out.println("2:update author ");
        System.out.println("3:delete author by ID  ");
        System.out.println("4:find author by ID");
        System.out.println("3:find all books by author");
        System.out.println("6:show all authors" );
        System.out.println("7:create book");
        System.out.println("8:update book");
        System.out.println("9:delete book");
        System.out.println("10:find book by ID");
        System.out.println("11:find all authors by title");
        System.out.println("12:show all books");
        System.out.println("0:Exit");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Input:");
    }

    private void crud(String position, BufferedReader reader) throws IOException {
        switch (position) {
            case "1": createAuthor(reader); break;
            case "2": updateAuthor(reader); break;
            case "3": deleteAuthor(reader); break;
            case "4": readAuthorById(reader); break;
            case "5": findBooksByAuthor(reader); break;
            case "6": readAllAuthors(); break;
            case "7": createBook(reader); break;
            case "8": updateBook(reader); break;
            case "9": deleteBook(reader); break;
            case "10": readBookById(reader); break;
            case "11": findAuthorsByBook(reader); break;
            case "12": readAllBooks(); break;
            case "0": System.exit(0); reader.close();
            default:  run();
        }
    }


    private void createAuthor(BufferedReader reader) throws IOException {
        Author author = new Author();
        ArrayList<String> books = new ArrayList<>();

        System.out.println("Enter author's name: ");
        String name = reader.readLine();
        System.out.println("Enter author's last name: ");
        String lastName = reader.readLine();
        System.out.println("Enter number of books: ");
        int numberOfBooks = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("Enter the title of " + (i + 1) + " book: ");
            String nameOfBook = reader.readLine();
            books.add(nameOfBook);
        }
        author.setName(name);
        author.setLastName(lastName);
        author.setBooks(books);
        authorManager.create(author);
        System.out.println("Author was added");
        run();
    }

    private void updateAuthor(BufferedReader reader) throws IOException {
        try {
            System.out.println("Enter author ID: ");
            String id = reader.readLine();
            Author author = authorManager.readById(id);
            ArrayList<String> books = new ArrayList<>();

            System.out.println("Enter author's name: ");
            String name = reader.readLine();
            System.out.println("Enter author's last name: ");
            String lastName = reader.readLine();
            System.out.println("Enter number of books: ");
            int numberOfBooks = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfBooks; i++) {
                System.out.println("Enter the title of " + (i + 1) + " book: ");
                String nameOfBook = reader.readLine();
                books.add(nameOfBook);
            }
            author.setName(name);
            author.setLastName(lastName);
            author.setBooks(books);
            authorManager.update(author);
            System.out.println("Author was updated");
            run();
        } catch (NoSuchElementException e) {
            System.out.println("There is no author with such ID");

        }
    }

    private void readAllAuthors() throws IOException {
        System.out.println("All authors:");
        authorManager.readAll();
        System.out.println();
        System.out.println("Press Enter to open menu");
    }

    private void readAuthorById(BufferedReader reader) throws IOException {
        try {
            System.out.println("Enter author ID: ");
            String id = reader.readLine();
            System.out.println(authorManager.readById(id));
            System.out.println();

        } catch (NoSuchElementException e) {
            System.out.println("There is no author with such ID");
        }
    }

    private void deleteAuthor(BufferedReader reader) throws IOException {
        try {
            System.out.println("Enter author ID: ");
            String id = reader.readLine();
            authorManager.delete(id);
            System.out.println("Author with " + id + " ID was deleted");

        } catch (NoSuchElementException e) {
            System.out.println("There is no author with such ID");

        }
    }

    private void findBooksByAuthor(BufferedReader reader) throws IOException {
        System.out.println("Enter the author's Last name: ");
        String bookName = reader.readLine();
        authorManager.findBooksByAuthor(bookName);
        System.out.println("Press Enter to open menu");

    }

    private void createBook(BufferedReader reader) throws IOException {
        Book book = new Book();
        ArrayList<String> authors = new ArrayList<>();
        System.out.println("Enter book's title: ");
        String name = reader.readLine();
        System.out.println("Enter number of authors: ");
        Integer numberOfAuthors = Integer.valueOf(reader.readLine());
        for (int i = 0; i < numberOfAuthors; i++) {
            System.out.println("Enter the name of " + (i + 1) + " Author: ");
            String nameOfAuthor = reader.readLine();
            authors.add(nameOfAuthor);
        }
        book.setBookName(name);
        book.setAuthors(authors);
        bookManager.create(book);
        System.out.println("Book was added");
        run();
    }

    private void updateBook(BufferedReader reader) throws IOException {
        try {
            System.out.println("Enter book ID: ");
            String id = reader.readLine();
            Book book = bookManager.readById(id);
            ArrayList<String> authors = new ArrayList<>();
            System.out.println("Enter book's title: ");
            String name = reader.readLine();
            System.out.println("Enter number of authors: ");
            Integer numberOfAuthors = Integer.valueOf(reader.readLine());
            for (int i = 0; i < numberOfAuthors; i++) {
                System.out.println("Enter the name of " + (i + 1) + " author: ");
                String nameOfAuthor = reader.readLine();
                authors.add(nameOfAuthor);
            }
            book.setBookName(name);
            book.setAuthors(authors);
            bookManager.update(book);
            System.out.println("Book was updated");
            run();
        } catch (NoSuchElementException e) {
            System.out.println("There is no such book ID");
        }
    }

    private void readAllBooks() throws IOException {
        System.out.println("All books:");
        bookManager.readAll();
        System.out.println("Press Enter to open menu");

    }

    private void readBookById(BufferedReader reader) throws IOException {
        try {
            System.out.println("Enter book ID: ");
            String id = reader.readLine();
            System.out.println(bookManager.readById(id));
            System.out.println();
        } catch (NoSuchElementException e) {
            System.out.println("There is no such book ID");
        }
    }

    private void deleteBook(BufferedReader reader) throws IOException {
        try {
            System.out.println("Enter book ID: ");
            String id = reader.readLine();
            bookManager.delete(id);
            System.out.println("The book with " + id + " ID was deleted");
        } catch (NoSuchElementException e) {
            System.out.println("There is no such book ID");
        }
    }

    private void findAuthorsByBook(BufferedReader reader) throws IOException {
        System.out.println("Enter the book title: ");
        String bookName = reader.readLine();
        bookManager.findAuthorsByBook(bookName);
    }
}
