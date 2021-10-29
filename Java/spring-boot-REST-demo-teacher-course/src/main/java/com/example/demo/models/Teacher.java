package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacher_id;
    private String teacher_fname;
    private String teacher_lname;
    private String teacher_email;

    @ManyToMany(mappedBy = "teachers")
    @JsonIgnore
    private List<Course> courses;

    public Teacher() {

    }

    public Teacher(Long teacher_id, String teacher_fname, String teacher_lname, String teacher_email, List<Course> courses) {
        this.teacher_id = teacher_id;
        this.teacher_fname = teacher_fname;
        this.teacher_lname = teacher_lname;
        this.teacher_email = teacher_email;
        this.courses = courses;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_fname() {
        return teacher_fname;
    }

    public void setTeacher_fname(String teacher_fname) {
        this.teacher_fname = teacher_fname;
    }

    public String getTeacher_lname() {
        return teacher_lname;
    }

    public void setTeacher_lname(String teacher_lname) {
        this.teacher_lname = teacher_lname;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }
}
