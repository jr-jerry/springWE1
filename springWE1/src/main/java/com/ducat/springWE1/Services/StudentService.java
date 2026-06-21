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
    public StudentDTO saveStudentService(StudentDTO studentDto){
        Student s1=getStudent_from_DTO(studentDto);
        Student savedStudent=studentRepo.save(s1);
        return getDto_from_Student(savedStudent);

    }
    public static Student getStudent_from_DTO(StudentDTO studentDTO){
        Student emptyStudent=new Student();
        emptyStudent.setStuAge(studentDTO.getStuAge());
        emptyStudent.setStuName(studentDTO.getStuName());

        return emptyStudent;
    }
//Updated ! 
    public StudentDTO updateStudentService(int studentId,StudentDTO updatedStudentDTO){
         //Find Old Student Data 
            Optional<Student> box=studentRepo.findById(studentId);
            //Student exist with this studentId
            if(box.isPresent()){
                //Then update the old data with new one 
                Student savedStudent=box.get();

                //Update Field by Field 
                savedStudent.setStuAge(updatedStudentDTO.getStuAge());
                savedStudent.setStuName(updatedStudentDTO.getStuName());

                //Save the Updated student object 
                Student savedUpdatedStudent=studentRepo.save(savedStudent); 
                return getDto_from_Student(savedUpdatedStudent);
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
    public List<StudentDTO> getStudentService(){
        return  studentRepo.findAll().stream().map(s->getDto_from_Student(s)).toList();
    }
    public StudentDTO getDto_from_Student(Student student){
        StudentDTO temp=new StudentDTO();

        temp.setStuAge(student.getStuAge());
        temp.setStuName(student.getStuName());

        return temp;
    }
}
