package com.example.demo.controllers;

import com.example.demo.models.Course;
import com.example.demo.models.Teacher;
import com.example.demo.repositories.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private CourseController courseController;

    @MockBean
    private CourseRepository courseRepository;

    @BeforeEach
    public void insert_data() {
        List<Teacher> teachers = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        teachers.add(new Teacher(1L, "Jake", "Economy", "sdfjl@sdf.com",  courses));
        courseRepository.saveAndFlush(new Course(123L, "Math100", "Intro Math", 130, teachers));
        courseRepository.saveAndFlush(new Course(124L, "Math101", "Intermediate Math", 130, teachers));
        courseRepository.saveAndFlush(new Course(125L, "Math102", "Advanced Math", 130, teachers));

    }

    @Test
    public void get_all_list_status_and_content_type_test() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/courses").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
    }

    @Test
    public void get_all_list_test() {
       when(courseRepository.findAll().size()).thenReturn(3);
        assertEquals(3, courseController.list().size());
    }




}