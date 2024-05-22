package com.yashpawar5.LibraryManagementSystem.Repositories;

import com.yashpawar5.LibraryManagementSystem.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String > {
}
