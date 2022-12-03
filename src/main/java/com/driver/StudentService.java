package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addstudentTeacherPair(String student,String teacher){
        studentRepository.addstudentTeacherPair(student,teacher);
    }

    public Student findStudent(String student){
        return studentRepository.findStudent(student);
    }

    public Teacher findTeacher(String teacher){
        return studentRepository.findTeacher(teacher);
    }

    public List<String> listOfStudents(String teacher){
        return studentRepository.listOfStudents(teacher);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacher){
       studentRepository.deleteTeacher(teacher);
    }
    public void deleteAllTeachers(){
       studentRepository.deleteAllTeachers();
    }
}


