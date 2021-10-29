package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name="courses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long course_id;
    private String course_name;
    private String course_description;
    private Integer course_duration;

    @ManyToMany
    @JoinTable(
            name = "course_teachers",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="teacher_id")
    )
    private List<Teacher> teachers;

    public Course() {

    }

    public Course(Long course_id, String course_name, String course_description, Integer course_duration, List<Teacher> teachers) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_duration = course_duration;
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public Integer getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(Integer course_duration) {
        this.course_duration = course_duration;
    }
}
