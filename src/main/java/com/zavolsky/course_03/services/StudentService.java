package com.zavolsky.course_03.services;

import com.zavolsky.course_03.models.Student;

import java.util.HashMap;
import java.util.Map;

public interface StudentService {

    final Map<Long, Student> students = null;

    Student add(String name, int age);

    Map<Long, Student> getAll();

    Student get(Long id);

    Student update(Long id, String name, int age);

    Student remove(Long id);

    Map<Long, Student> getAllByAge(Integer age);
}
