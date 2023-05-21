package com.zavolsky.course_03.services.impl;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.services.FacultyService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final Map<Long, Faculty> faculties = new HashMap();

    public Faculty add(String name, String color) {
        Faculty faculty = new Faculty(name,color);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Map<Long, Faculty> getAll() {
        return faculties;
    }

    public Map<Long, Faculty> getAllByColor(String color) {
        return faculties.entrySet().stream()
                .filter(faculty -> faculty.getValue().getColor() == color)
                .collect(Collectors.toMap(f -> f.getKey(), f -> f.getValue()));
    }

    public Faculty get(Long id) {
        return faculties.get(id);
    }

    public Faculty update(Long id, String name, String color) {
        faculties.get(id).setName(name);
        faculties.get(id).setColor(color);
        return faculties.get(id);
    }

    public Faculty remove(Long id) {
        Faculty faculty = faculties.get(id);
        faculties.remove(id);
        return faculty;
    }

}
