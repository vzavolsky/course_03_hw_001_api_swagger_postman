package com.zavolsky.course_03.services.impl;

import com.zavolsky.course_03.models.Student;
import com.zavolsky.course_03.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> students = new HashMap();

    public Student add(String name, int age) {
        Student student = new Student(name, age);
        students.put(student.getId(),student);
        return student;
    }

    public Map<Long,Student> getAll() {
        return students;
    }

    public Student get(Long id) {
        return students.get(id);
    }

    public Student update(Long id, String name, int age) {
        students.get(id).setName(name);
        students.get(id).setAge(age);
        return students.get(id);
    }

    public Student remove(Long id) {
        Student student = students.get(id);
        students.remove(id);
        return student;
    }

    public Map<Long, Student> getAllByAge(Integer age) {
        return students.entrySet().stream()
                .filter(student -> student.getValue().getAge() == age)
                .collect(Collectors.toMap(s -> s.getKey(), s -> s.getValue()));
    }

}
