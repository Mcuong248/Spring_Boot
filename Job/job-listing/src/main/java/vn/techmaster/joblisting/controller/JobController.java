package vn.techmaster.joblisting.controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.joblisting.dto.JobRequest;
import vn.techmaster.joblisting.model.Job;

@RestController
@RequestMapping("/job")
public class JobController {
    private ConcurrentHashMap<String, Job> jobs;
    public JobController() {
        jobs = new ConcurrentHashMap<>();
        jobs.put("MC123",new Job("1","IT","Develop SoftWare", "HANOI",2000,10000,"techmaster@gmail.com"));
        jobs.put("MC321",new Job("2","Desktop","Help Desk", "HO CHI MINH",2000,4400,"techmaster@gmail.com"));
}
@GetMapping
    public List<Job> getJob(){
        return jobs.values().stream().toList();
    }

@PostMapping
public Job createNewBook(@RequestBody JobRequest jobRequest) {
    String id = UUID.randomUUID().toString();
    Job newJob = new Job(id,jobRequest.title(),jobRequest.description(),jobRequest.location(),jobRequest.min_salary(),jobRequest.max_salary(),jobRequest.email_to());
        listJob.put(id,newJob);
        return  newJob;
  }
}

