package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping
    @RequestMapping({"id"})
    public Course get(@PathVariable Long id) {
        return courseRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        Course existingCourse = courseRepository.getById(id);
        BeanUtils.copyProperties(course, existingCourse, "course_id");
        return courseRepository.saveAndFlush(existingCourse);
    }


}














