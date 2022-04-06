package vn.techmaster.jobhunt.controller;

import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.jobhunt.model.Employer;

@Controller
@RequestMapping("/employer")
public class EmployerController {
    ConcurrentHashMap<String, Employer> employerList =new ConcurrentHashMap<>();
    public EmployerController(){
        employerList.put("01",new Employer("Jonh", "jonh.edu.vn", "jonh@gmail.com"," Hanoi"));
        employerList.put("02",new Employer("MCuong", "MCuong248.edu.vn", "nggmanhcuong2001@gmail.com"," HoChiMinh"));
        employerList.put("03",new Employer("Anna", "anna.edu.vn", "anna@gmail.com"," DaNang"));
        employerList.put("04",new Employer("Zoro", "zoro123.edu.vn", "zoro123@gmail.com"," HaiPhong"));
        employerList.put("05",new Employer("Shark", "shark456.edu.vn", "shark456@gmail.com","NhaTrang"));
    }

    @GetMapping("/list")
    public String employersList(Model model) {
        var employers = employerList.values().stream().collect(Collectors.toList());
        model.addAttribute("employers", employers);
        return "employer/list";
    }

    @GetMapping("/add")
    public String employerForm(Model model){
        model.addAttribute("employer", new Employer());
        return "employer/add";
    }
}
