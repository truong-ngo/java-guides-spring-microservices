package com.javaguide.restapi.controller;

import com.javaguide.restapi.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/hello")
    public String helloWord() {
        return "Hello World!";
    }

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student body = new Student(1L, "Ramesh", "Fadatare");
        return ResponseEntity.ok().header("test", "ok").body(body);
    }

    @GetMapping("/list-students")
    public List<Student> getStudents() {
        List<Student> body = new ArrayList<>();
        body.add(new Student(1L, "Ramesh", "Fadatare"));
        body.add(new Student(2L, "Madan", "Reddy"));
        body.add(new Student(3L, "Ranga", "Karanam"));
        body.add(new Student(4L, "Maximilian", "Schwarzmüller"));
        return body;
    }

    @GetMapping("/student/{id}")
    public Student findStudent(@PathVariable Long id) {
        return new Student(id, "Ramesh", "Fadatare");
    }

    @GetMapping("/student/query")
    public Student findStudentByParam(@RequestParam Long id) {
        return new Student(id, "Ramesh", "Fadatare");
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        log.info("Create student: {}", student);
        return student;
    }

    @PutMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        log.info("Update student: {}, id: {}", student, id);
        student.setId(id);
        return student;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        log.info("Delete student with id: {}", id);
        return "Delete successfully";
    }
}
