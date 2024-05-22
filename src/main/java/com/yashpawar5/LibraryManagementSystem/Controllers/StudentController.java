package com.yashpawar5.LibraryManagementSystem.Controllers;

import com.yashpawar5.LibraryManagementSystem.Models.Student;
import com.yashpawar5.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("add")
        public String addStudent(@RequestBody Student student){

            String result = studentService.addStudent(student);
            return result;
        }

    @GetMapping("findAllStudents")
        public List<Student> findAllStudents(){
            List<Student> ansList = studentService.findAllStudents();
            return ansList;
    }

}
