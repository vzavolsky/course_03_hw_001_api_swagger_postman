package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.services.StudentService;
import com.zavolsky.course_03.services.impl.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/add")
    public Student add(@RequestParam("name") String name, @RequestParam("age") int age) {
        return studentService.add(name, age);
    }

    @GetMapping(path = "/get")
    public Map<Long, Student> getAll(@RequestParam(value = "age", required = false) Integer age) {
        return age == null ? studentService.getAll() : studentService.getAllByAge(age);
    }

    @GetMapping(path = "/get/{id}")
    public Student get(@PathVariable("id") Long id) {
        return studentService.get(id);
    }

    @GetMapping(path = "/update")
    public Student update(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("age") Integer age) {
        return studentService.update(id, name, age);
    }

    @GetMapping(path = "/remove/{id}")
    public Student remove(@PathVariable("id") Long id) {
        return studentService.remove(id);
    }

}
