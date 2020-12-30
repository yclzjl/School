package com.example.service;

import java.util.List;

import com.example.dao.models.Student;

public interface StudentService {

	public int getStudentCounts();
	
	public List<Student> getAllStudent();
}
