package com.firstAPI.student;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController            //this class contain API
public class StudentController
{

    //1.building database

    HashMap<Integer,Student>studentDB=new HashMap<>();



    //2.Add student
     @PostMapping("/add_student")//"/add_student" is end point here through which we search particular student
    public String addStudent(@RequestBody() Student student)
     {

         int key= student.id;

         studentDB.put(key,student);

         return "Student added succesfully";
     }



    //3.get a student

    @GetMapping( "/get_student_by_id")
    public Student getByStudentId(@RequestParam("id") Integer id)
    {
        return studentDB.get(id);
    }


    @GetMapping("/get_student_by_name")
    public Student getStudentByname(@RequestParam("name")String searchName)
    {

        for(Student s: studentDB.values())
        {
            if(s.name.equals(searchName))return s;
        }
        return null;
    }


    @GetMapping("/get_by_path/{id}")
    public Student getByPath(@PathVariable("id")Integer id)
    {
        Student student =studentDB.get(id);

        return student;
    }
    //4.update a student

     @PutMapping("/update_student")
    public Student updateStudent(@RequestBody()Student student)
     {

         int key= student.id;

         studentDB.put(key,student);


     return student;

     }


    //5.delete a student

    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("id")Integer id)
    {

        studentDB.remove(id);

        return "Student deleted successfully";


    }



}
