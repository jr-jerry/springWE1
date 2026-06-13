package com.ducat.springWE1.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ducat.springWE1.Entity.Student;

@Service
public class StudentService {
    private final List<Student> db=new ArrayList<>();

    public Student saveStudentService(Student studentData){
        boolean isSaved=db.add(studentData);//true-->succesfull

        if(isSaved)return studentData;
        return null;
    }

    public Student updateStudentService(int studentId,Student studentData){
        //find the original data from db
        int indexOfSavedStudent=0; 
        for(Student savedStudent:db){
            if(savedStudent.getStuId()==studentId){
                indexOfSavedStudent=db.indexOf(studentData);
                 db.add(indexOfSavedStudent, studentData);
                 return studentData;
            }
        }
        return null;
    }
    public boolean deleteStudentService(int studentId){
        //if student exist with this id 
        for(Student studentSaved:db){
            if(studentSaved.getStuId()==studentId){
                int index_Of_SavedData=db.indexOf(studentSaved);
                db.remove(index_Of_SavedData);
                return true;
            }
        }
        return false;
    }
    public List<Student> getStudentService(){
        return db;
    }
}
