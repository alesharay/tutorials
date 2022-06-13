package com.aleshamray.amigoscoderestapi.service;

import com.aleshamray.amigoscoderestapi.domain.Student;
import com.aleshamray.amigoscoderestapi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
