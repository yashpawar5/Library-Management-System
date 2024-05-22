package com.yashpawar5.LibraryManagementSystem.Services;

import com.yashpawar5.LibraryManagementSystem.Enums.TransactionStatus;
import com.yashpawar5.LibraryManagementSystem.Models.Book;
import com.yashpawar5.LibraryManagementSystem.Models.LibraryCard;
import com.yashpawar5.LibraryManagementSystem.Models.Transaction;
import com.yashpawar5.LibraryManagementSystem.Repositories.BookRepository;
import com.yashpawar5.LibraryManagementSystem.Repositories.CardRepository;
import com.yashpawar5.LibraryManagementSystem.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public String issueBook(Integer bookId, Integer cardId) throws Exception{

        Book book = bookRepository.findById(bookId).get();

        LibraryCard card = cardRepository.findById(cardId).get();

        Transaction transaction = new Transaction();

        if(book.getIsIssued()){
            throw new Exception("The book is already issued.");
        }
        if(card.getNoOfBooksIssued()== 3){
            throw new Exception("Card book issue limit is reached.");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        transaction.setBook(book);
        transaction.setLibraryCard(card);

        book.setIsIssued(true);

        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        transaction = transactionRepository.save(transaction);
        bookRepository.save(book);
        cardRepository.save(card);

        return "The transaction is saved with TransactionId "+ transaction.getTransactionId();
    }

//    public String returnBook(Integer bookId, Integer cardId) {
//        Book book = bookRepository.findById(bookId).get();
//
//        LibraryCard card = cardRepository.findById(cardId).get();
//
//        Transaction transaction =  new Transaction();
//
//
//
//    }
//
//    public int noOfDays(Transaction transaction){
//        int issueDay = transaction.getIssueDate().getDay();
//        int issueMonth = transaction.getIssueDate().getMonth();
//
//    }
}
