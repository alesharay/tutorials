package com.aleshamray.amigoscoderestapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class StudentControllerTest {

    private static final Logger log = LoggerFactory.getLogger(StudentControllerTest.class);

    @InjectMocks
    StudentController studentController;

    @Test
    public void shouldReturnNullForFetchAllStudents() {
        log.debug("------ INSIDE shouldReturnNotNullForFetchAllStudents -------");
        assertNull(studentController.fetchAllStudents());
    }
}