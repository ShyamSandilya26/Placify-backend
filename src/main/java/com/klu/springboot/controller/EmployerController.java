package com.klu.springboot.controller;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.springboot.DTO.ApplicationDTO;
import com.klu.springboot.model.Applications;
import com.klu.springboot.model.Employer;
import com.klu.springboot.model.Jobs;
import com.klu.springboot.service.EmployerService;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin // Allow requests from React frontend
public class EmployerController {

    @Autowired
    private EmployerService employerService;
    

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployer(@RequestBody Employer employer) {
        try {
            String message = employerService.employerRegistration(employer);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error registering employer: " + e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginEmployer(
            @RequestParam String username,
            @RequestParam String password) {
        try {
            Employer employer = employerService.checkEmployerLogin(username, password);
            if (employer != null) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid name or password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during login: " + e.getMessage());
        }
    }
    
    
    @PostMapping("/post-job")
    public ResponseEntity<?> postJob(@RequestBody Jobs jobs) {
        try {
            String message = employerService.postJob(jobs);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error posting job: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/viewallapplications")
    public ResponseEntity<List<ApplicationDTO>> viewAllApplications() {
        List<Applications> applications = employerService.viewAllApplications();

        // Map Applications to ApplicationDTO
        List<ApplicationDTO> applicationDTOs = applications.stream().map(application -> { // Renamed lambda parameter
            ApplicationDTO dto = new ApplicationDTO();
            dto.setId(application.getId());
            dto.setName(application.getName());
            dto.setEmail(application.getEmail());
            dto.setTenthcgpa(application.getTenthcgpa());
            dto.setTwelethcgpa(application.getTwelethcgpa());
            dto.setGradutioncgpa(application.getGradutioncgpa());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(applicationDTOs);
    }

    @GetMapping("/viewResume")
    public ResponseEntity<byte[]> viewResume(@RequestParam int id) {
        Applications application = employerService.displayApplicationById(id);
        
        try {
            // Retrieve the Blob object
            Blob resumeBlob = application.getResume();

            // Convert Blob to byte array
            byte[] resumeBytes;
            try (InputStream inputStream = resumeBlob.getBinaryStream()) {
                resumeBytes = inputStream.readAllBytes();
            }

            // Return the response as a PDF
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF) // Adjust Content-Type if necessary
                    .body(resumeBytes);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Return an appropriate response in case of an error
        }
    }
    
}
