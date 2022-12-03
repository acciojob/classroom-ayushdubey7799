package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<String,Student> studentsRecord;
    private HashMap<String,Teacher> teachersRecord;
    private HashMap<String, List<String>> studentTeacherMapping;

    public StudentRepository(){
        this.studentsRecord = new HashMap<String,Student>();
        this.teachersRecord = new HashMap<String,Teacher>();
        this.studentTeacherMapping = new HashMap<String,List<String>>();
    }

    public void addStudent(Student student){
        studentsRecord.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teachersRecord.put(teacher.getName(), teacher);
    }

    public void addstudentTeacherPair(String student,String teacher){
        if(studentsRecord.containsKey(student) && teachersRecord.containsKey(teacher)){
            studentsRecord.put(student,studentsRecord.get(student));
            teachersRecord.put(teacher,teachersRecord.get(teacher));
            List<String> students = new ArrayList<>();
            if(studentTeacherMapping.containsKey(teacher))students = studentTeacherMapping.get(teacher);
            students.add(student);
            studentTeacherMapping.put(teacher,students);
        }
    }

    public Student findStudent(String student){
        return studentsRecord.get(student);
    }

    public Teacher findTeacher(String teacher){
        return teachersRecord.get(teacher);
    }

    public List<String> listOfStudents(String teacher){
        List<String> studentList = new ArrayList<>();
        if(studentTeacherMapping.containsKey(teacher)){
            studentList = studentTeacherMapping.get(teacher);
        }
        return studentList;
    }

    public List<String> getAllStudents(){

        return new ArrayList<>(studentsRecord.keySet());
    }

    public void deleteTeacher(String teacher){
        List<String> students = new ArrayList<>();
        if(studentTeacherMapping.containsKey(teacher)){
            students = studentTeacherMapping.get(teacher);
            for(String student : students){
                if(studentsRecord.containsKey(student)){
                    studentsRecord.remove(student);
                }
            }
            studentTeacherMapping.remove(teacher);
        }
        if(teachersRecord.containsKey(teacher)){
            teachersRecord.remove(teacher);
        }
    }
    public void deleteAllTeachers(){
        HashSet<String> studentsList = new HashSet<>();
        for(String teacher : studentTeacherMapping.keySet()){
            for(String student : studentsRecord.keySet()){
                studentsList.add(student);
            }
        }

        for(String student : studentsList){
            if(studentsRecord.containsKey(student)){
                studentsRecord.remove(student);
            }
        }
    }
}
