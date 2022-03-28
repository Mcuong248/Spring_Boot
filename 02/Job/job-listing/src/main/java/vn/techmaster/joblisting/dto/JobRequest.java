package vn.techmaster.joblisting.dto;
import vn.techmaster.joblisting.location.location;

public record JobRequest(String id, String title, String description, location location, int min_salary, int max_salary, String email_to) {
    
}
