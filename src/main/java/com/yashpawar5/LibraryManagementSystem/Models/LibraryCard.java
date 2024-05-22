package com.yashpawar5.LibraryManagementSystem.Models;

import com.yashpawar5.LibraryManagementSystem.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private Integer noOfBooksIssued;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    //This has to be written in the child class/table
    @JoinColumn //Add another column; By default it adds the primary key;
                // Incase you need to add another key:  @JoinColumn(referencedColumnName = "emailId")
    @OneToOne //Mapping between entries
    private Student student; //Which entity you have to connect
}
