package com.yashpawar5.LibraryManagementSystem.Services;

import com.yashpawar5.LibraryManagementSystem.Models.Author;
import com.yashpawar5.LibraryManagementSystem.Models.Book;
import com.yashpawar5.LibraryManagementSystem.Repositories.AuthorRepository;
import com.yashpawar5.LibraryManagementSystem.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book){
        bookRepository.save(book);
        return "Book has been added to the DB with bookId "+ book.getBookId();
    }
    public String associateBookAndAuthor(Integer bookId, Integer authorId) throws Exception{

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()){
            throw new Exception("Entered bookId is invalid");
        }


        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(optionalAuthor.isEmpty()){
            throw new Exception("Entered authorId is invalid");
        }

        Book book = optionalBook.get();
        Author author = optionalAuthor.get();

        book.setAuthor(author);
        author.setNoOfBooks(author.getNoOfBooks()+1);

        bookRepository.save(book);
        authorRepository.save(author);
        return "Associating book and author with bookId "+bookId+" and authorId "+authorId;

    }

}
