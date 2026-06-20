package com.ducat.springWE1.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ducat.springWE1.DTO.StudentDTO;
import com.ducat.springWE1.Entity.Student;
import com.ducat.springWE1.Repository.StudentRepo;

@Service
public class StudentService {
    private final List<Student> db=new ArrayList<>();
    
    private final StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }

    //Store Data in Persistent DB 
    public Student saveStudentService(StudentDTO studentDto){
        Student emptyStudent=new Student();
        emptyStudent.setStuAge(studentDto.getStuAge());
        emptyStudent.setStuName(studentDto.getStuName());
         //true-->succesfull
        return studentRepo.save(emptyStudent);
    }
//Updated ! 
    public Student updateStudentService(int studentId,Student studentData){
         //Find Old Student Data 
            Optional<Student> box=studentRepo.findById(studentId);
            //Student exist with this studentId
            if(box.isPresent()){
                //Then update the old data with new one 
                Student savedStudent=box.get();

                //Update Field by Field 
                savedStudent.setStuAge(studentData.getStuAge());
                savedStudent.setStuName(studentData.getStuName());

                //Save the Updated student object 
                return studentRepo.save(savedStudent);
                
            }
            return null;             
    }


   //Updated ! 
    public boolean deleteStudentService(int studentId){
         //if student exist with this id ! 
         Optional<Student> box=studentRepo.findById(studentId);
         if(box.isPresent()){
            studentRepo.deleteById(studentId);
            return true;
         }
         return false;
    }
    public List<Student> getStudentService(){
        return studentRepo.findAll();
    }
}
