package vn.techmaster.joblisting.controller;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.joblisting.dto.JobRequest;
import vn.techmaster.joblisting.location.location;
import vn.techmaster.joblisting.model.Job;

@RestController
@RequestMapping("/job")
public class JobController {
    private ConcurrentHashMap<String, Job> jobs;
    public JobController() {
        jobs = new ConcurrentHashMap<>();
        jobs.put("MC123",new Job("MC01","Fullstack Developer","Fulltime", location.HaNoi, 2000,10000,"mc123@gmail.com"));
        jobs.put("MC345",new Job("MC02","Back-end Developer","Partime", location.HaiPhong, 2000,4400,"jobHCM@gmail.com"));
        jobs.put("MC567",new Job("MC03","Fron-end Developer","SV năm 1-2", location.DaNang,1000,5000,"fe@gmail.com"));
        jobs.put("MC789",new Job("MC04","IOS Developer","SV năm 3-4", location.HoChiMinh,1000,5000,"ios@gmail.com"));
}
@GetMapping
    public List<Job> getJob(){
        return jobs.values().stream().toList();
    }

@PostMapping
public Job createNewBook(@RequestBody JobRequest jobRequest) {
    String uuid = UUID.randomUUID().toString();
    Job newJob = new Job(uuid, jobRequest.title(),jobRequest.description(),jobRequest.location(),jobRequest.min_salary(),jobRequest.max_salary(),jobRequest.email_to());
        jobs.put(uuid, newJob);
        return  newJob;
  }

@GetMapping(value = "/{id}")
public Job getJobById(@PathVariable("id") String id){
    return jobs.get(id);
}

@PutMapping(value = "/{id}")
public Job updateJobById(@PathVariable("id") String id, @RequestBody JobRequest jobRequest){
    Job updateJob = new Job(id, jobRequest.title(),jobRequest.description(),jobRequest.location(),jobRequest.min_salary(),jobRequest.max_salary(),jobRequest.email_to());
    jobs.replace(id, updateJob);
    return updateJob;
}

@DeleteMapping (value = "/{id}")
public Job deleteJobById(@PathVariable("id") String id){
    Job removeJob = jobs.remove(id);
    return removeJob;
}

// Bài 1
@GetMapping (value = "/sortbylocation")
public List<Job> sortByLocation(){
    return jobs.values().stream().sorted(Comparator.comparing(Job::getLocation)).collect(Collectors.toList());
   }

// Bài 2
@GetMapping (value = "/salary/{salary}")
public List<Job> getJobBySalary(@PathVariable("salary") int salary){
    return jobs.values().stream().filter(s -> (s.getMin_salary() <= (salary)) && (s.getMax_salary() >= (salary))).collect(Collectors.toList());
}

// Bài 3
@GetMapping (value = "/keyword/{keyword}")
public List<Job> getJobByKeyword(@PathVariable("keyword") String keyword){
    return jobs.values().stream().filter(s -> (s.getTitle().contains(keyword)) || (s.getDescription().contains(keyword))).collect(Collectors.toList());
}

// Bài 4
@GetMapping (value = "query")
public List<Job> getJobByKeywordAndLocation(@RequestParam("keyword") String keyword, @RequestParam("location") location location){
    return jobs.values().stream().filter(s -> ((s.getTitle().contains(keyword) || (s.getDescription().contains(keyword))) && (s.getLocation().contains(keyword))).collect(Collectors.toList());
}
}

