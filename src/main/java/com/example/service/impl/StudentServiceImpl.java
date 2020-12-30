package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.mapper.StudentMapper;
import com.example.dao.models.Student;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper; 
	
	@Override
	public int getStudentCounts() {
		List<Student> studentList = studentMapper.selectAll();
		if(studentList != null)
			return studentList.size();
		else
			return 0;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = studentMapper.selectAll();
		return list;
	}

}
