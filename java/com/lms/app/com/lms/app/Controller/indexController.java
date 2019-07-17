package com.lms.app.com.lms.app.Controller;

import com.lms.app.com.lms.app.model.event;
import com.lms.app.com.lms.app.model.lecture;
import com.lms.app.com.lms.app.model.students;
import com.lms.app.com.lms.app.repo.eventRepo;
import com.lms.app.com.lms.app.repo.lectureRepo;
import com.lms.app.com.lms.app.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class indexController {

    @Autowired
    studentRepo studentRepo;

    @Autowired
    lectureRepo lectureRepo;

    @Autowired
    eventRepo eventRepo;




    @RequestMapping("/")
    public String adminPage(){

        return "index";
    }



    @RequestMapping("/showstudent")
    public String studentPage(Model model,@RequestParam(defaultValue = "0") int page){
        model.addAttribute("data",studentRepo.findAll(new PageRequest(page,3)));
        model.addAttribute("currentPage",page);

        return "addstudentdata";
    }

    @PostMapping("/savestudent")
    public String addStudent(students students){

        studentRepo.save(students);
        return "redirect:/showstudent";

    }

    @GetMapping("/deletestudents")
    public String deleteStudent(int id){
         studentRepo.deleteById(id);
        return "redirect:/showstudent";

    }

    @GetMapping("/findstudents")
    @ResponseBody
    public Optional<students> findeStudent(int id){
       return studentRepo.findById(id);


    }
    
    @GetMapping("/findone")
    @ResponseBody
    public students findstude(int id) {
    	return studentRepo.getOne(id);
    }


    @RequestMapping("/adddata")
    public String addstdata(){
        return "addstudentdata";
    }



    @RequestMapping("/showlecture")
    public String lecturepage(Model model,@RequestParam(defaultValue = "0")int page){

        model.addAttribute("data",lectureRepo.findAll(new PageRequest(page,3)));
        model.addAttribute("currentPage",page);
        return "lecture";
    }

    @PostMapping("/addlecture")
    public String saveLactur(lecture lecture){

       lectureRepo.save(lecture);
        return "redirect:/showlecture";

    }

    @GetMapping("/deletelecture")
    public  String deleteLecture(int id){

     lectureRepo.deleteById(id);
     return "redirect:/showlecture";
    }

    @GetMapping("/findlecture")
    @ResponseBody
    public Optional<lecture> findLecture(int id){

      return   lectureRepo.findById(id);
    }

    @RequestMapping("/evnt")
    public  String showevents(){

        return "events";
    }

    @PostMapping("/addevent")
    public String addevents(event event){

        eventRepo.save(event);

        return "redirect:/evnt";
    }




}
