package vn.techmaster.joblisting.dto;

public record JobRequest(String id, String title, String description, String location, String min_salary, String max_salary, String email_to) {
    
}
