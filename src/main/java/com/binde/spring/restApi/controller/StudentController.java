package com.binde.spring.restApi.controller;

import com.binde.spring.restApi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    //localhost:8080/student
    @GetMapping("/student")
    public Student student(){
        Student student = new Student(1L,"Nike",
                "sireia","Jos north");

        return student;
    }

    @GetMapping("/lists")
    public List<Student>getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"money","james","folks"));
        students.add(new Student(2L,"jacks","emmanuel","mark"));
        return students;

    }
    @GetMapping("students/{id}/{first-name}/{last-name}/{address}")
    public Student studentPathVariable(@PathVariable("id") Long studentId,
                                       @PathVariable("first-name") String firstname,
                                       @PathVariable ("last-name")String lastname,
                                       @PathVariable("address") String address){
        return new Student(studentId, firstname,lastname,address);
    }

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam Long id,
                                          @RequestParam String firstname,
                                          @RequestParam String lastname,
                                          @RequestParam String address){
        return new Student(id,firstname,lastname,address);
    }



}
