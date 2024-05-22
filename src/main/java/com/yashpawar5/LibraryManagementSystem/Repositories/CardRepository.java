package com.yashpawar5.LibraryManagementSystem.Repositories;

import com.yashpawar5.LibraryManagementSystem.Models.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard, Integer> {



}
