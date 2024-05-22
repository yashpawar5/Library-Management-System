package com.yashpawar5.LibraryManagementSystem.Repositories;

import com.yashpawar5.LibraryManagementSystem.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
