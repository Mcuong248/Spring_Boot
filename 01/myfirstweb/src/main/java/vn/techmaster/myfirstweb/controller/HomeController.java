package vn.techmaster.myfirstweb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.myfirstweb.model.Student;

// Bài 1
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/random")
    @ResponseBody
    public String getRandom8Character(){
        char[] arrCharacter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
        'v', 'w', 'x', 'y', 'z','0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrCharacter.length; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt((arrCharacter.length - 1) + 1 - 0);
            stringBuilder.append(arrCharacter[randomNumber]);
        }
        return stringBuilder + "";
    }

    //Bài 2
    // @GetMapping("/quotes")
    // @ResponseBody
    // public String quotes(){
    //     String [] quotesArr = {"Kiến tha lâu đầy tổ","Có công mài sắt, có ngày nên kim","Không thầy đố mày làm nên","Học thầy không tày học bạn"};
    //     Random rd = new Random();
    //     return quotesArr.[rd.nextInt(quotesArr.length)];
    // }

    //Bài 3
    @PostMapping("/bmi")
    @ResponseBody
    public double bmi(@RequestParam Double weight, @RequestParam Double height) {
        return weight / (height * height);
    }

    //Bài 4
    ArrayList<Student> listStudent = new ArrayList<Student>() {{
        listStudent.add(new Student(1,"Nguyen Manh Cuong", 20));
        listStudent.add(new Student(2,"Nguyen Van A", 21));
    }};
    public HomeController(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }
    @GetMapping("/listStudent")
    @ResponseBody
    public List<Student>  getStudentList(){
        return listStudent;
    }
    @PostMapping("/addStudent")
    @ResponseBody
    public Student addStudent(@RequestBody Student student){
        listStudent.add(student);
        return student;
    }
}


