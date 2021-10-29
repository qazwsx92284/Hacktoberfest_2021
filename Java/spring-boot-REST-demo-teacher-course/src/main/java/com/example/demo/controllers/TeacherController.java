package com.example.demo.controllers;

import com.example.demo.models.Teacher;
import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> list() {
        return teacherRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Teacher get(@PathVariable Long id) {
        return teacherRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Teacher update(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher existingTeacher = teacherRepository.getById(id);
        BeanUtils.copyProperties(teacher, existingTeacher, "teacher_id");
        return teacherRepository.saveAndFlush(existingTeacher);
    }









}
