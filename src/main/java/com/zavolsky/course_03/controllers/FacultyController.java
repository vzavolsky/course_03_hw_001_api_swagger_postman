package com.zavolsky.course_03.controllers;

import com.zavolsky.course_03.models.Faculty;
import com.zavolsky.course_03.services.FacultyService;
import com.zavolsky.course_03.services.impl.FacultyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {

    private FacultyService facultyService;

    public FacultyController(FacultyServiceImpl facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping(path = "/add")
    public Faculty add(@RequestParam("name") String name, @RequestParam("color") String color) {
        return facultyService.add(name, color);
    }

    @GetMapping(path = "/get")
    public Map<Long, Faculty> getAll(@RequestParam(value = "color", required = false) String color) {
        return color == null ? facultyService.getAll() : facultyService.getAllByColor(color);
    }

    @GetMapping(path = "/get/{id}")
    public Faculty get(@PathVariable("id") Long id) {
        return facultyService.get(id);
    }

    @GetMapping(path = "/update")
    public Faculty update(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("color") String color) {
        return facultyService.update(id, name, color);
    }

    @GetMapping(path = "/remove/{id}")
    public Faculty remove(@PathVariable("id") Long id) {
        return facultyService.remove(id);
    }

}
