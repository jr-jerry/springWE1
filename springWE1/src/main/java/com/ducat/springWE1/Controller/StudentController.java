package com.ducat.springWE1.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ducat.springWE1.Entity.Student;
import com.ducat.springWE1.Services.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }   
    @GetMapping("/get-students")
    public List<Student> getEndpoint(){
        return studentService.getStudentService();
    }
    @PostMapping("/create-student")
    public Student creatStudentEnpoint(@RequestBody Student studentData) {
       return studentService.saveStudentService(studentData);      
    }
    @PutMapping("/update-student/{studentId}")
    public Student updateStudentEndpoint(@PathVariable int studentId,@RequestBody Student studentData){
        return studentService.updateStudentService(studentId, studentData);
    }
    @DeleteMapping("/delete-student/{studentId}")
    public boolean deleteStudentEndpoint(@PathVariable int studentId){
        return studentService.deleteStudentService(studentId);
    }
}
