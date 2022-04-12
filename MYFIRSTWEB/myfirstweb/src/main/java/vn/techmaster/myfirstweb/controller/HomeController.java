package vn.techmaster.myfirstweb.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.techmaster.myfirstweb.model.BMI;
import vn.techmaster.myfirstweb.model.Student;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/random")
    @ResponseBody
    public String getRandom8Character() {
        char[] arrCharacter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z' };
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrCharacter.length; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt((arrCharacter.length - 1) + 1 - 0);
            stringBuilder.append(arrCharacter[randomNumber]);
        }
        return stringBuilder + "";
    }

// Bài 2
@GetMapping("/quote")
@ResponseBody
public String quote() {
  String[] quoteArr = { "Kiến tha lâu đầy tổ",
      "Có công mài sắt, có ngày nên kim",
      "Không thầy đố mày làm nên",
      "Học thầy không tày học bạn" };
  Random r = new Random();
  return quoteArr[r.nextInt(quoteArr.length)];
}

// Bài 3
@PostMapping(value = "/bmi", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public double countBMI(@RequestBody BMI bmi) {
  return bmi.getWeight() / (bmi.getHeight() * bmi.getHeight());
}

// Bài 4
ArrayList<Student> listOfStudents = new ArrayList<>();
  @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ArrayList<Student> listStudent(){
    return listOfStudents;

  }

  @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Student addStudents(@RequestBody Student student) {
        listOfStudents.add(student);
        return student;
  }
}



