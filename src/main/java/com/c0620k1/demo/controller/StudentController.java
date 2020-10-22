package com.c0620k1.demo.controller;

import com.c0620k1.demo.model.Student;
import com.c0620k1.demo.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable Long id, @RequestBody Student student){
        Optional<Student> optionalStudent = studentService.findById(id);
        student.setId(id);
        if (optionalStudent.isPresent()) return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
