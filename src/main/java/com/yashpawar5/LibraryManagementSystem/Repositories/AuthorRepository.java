package com.yashpawar5.LibraryManagementSystem.Repositories;

import com.yashpawar5.LibraryManagementSystem.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
