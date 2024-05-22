package com.yashpawar5.LibraryManagementSystem.Controllers;

import com.yashpawar5.LibraryManagementSystem.Models.Author;
import com.yashpawar5.LibraryManagementSystem.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("add")
    public String addAuthor(@RequestBody Author author){

        return authorService.addAuthor(author);
    }

    @GetMapping("findAuthorById")
    public ResponseEntity findAuthorById(@RequestParam("id")Integer authorId){
        try{
            Author authorResponse =authorService.findAuthorById(authorId);
            return new ResponseEntity(authorResponse, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
