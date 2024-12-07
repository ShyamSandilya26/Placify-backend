package com.klu.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.springboot.model.Admin;
import com.klu.springboot.model.Employer;
import com.klu.springboot.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
    private AdminService adminService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username,@RequestParam String password) {

	    if (username == null || password == null) {
	        return ResponseEntity.badRequest().body("Missing username or password");
	    }

	    Admin admin = adminService.checkAdminLogin(username, password);

	    if (admin != null) {
	        return ResponseEntity.ok("Login successful");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	    }
	}

	
	@GetMapping("/employers")
    public ResponseEntity<List<Employer>> getAllEmployers() {
        try {
            List<Employer> employers = adminService.viewAllEmployers();
            if (employers.isEmpty()) {
                return ResponseEntity.noContent().build(); // Return 204 if no employers found
            }
            return ResponseEntity.ok(employers); // Return 200 with the list of employers
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Return 500 in case of errors
        }
    }
	
	
	@PatchMapping("employers/{EmployerId}/status")
	public ResponseEntity<?> updateEmployerStatus(
	        @PathVariable int EmployerId, // Ensure the type matches
	        @RequestBody Map<String, String> body) {
	    String status = body.get("status");
	    // Validate status
	    if (status == null || (!status.equalsIgnoreCase("Approved") && !status.equalsIgnoreCase("Pending"))) {
	        return ResponseEntity.badRequest().body("Invalid status value. Allowed values: Approved, Pending.");
	    }

	    // Perform the status update
	    adminService.updateEmployerStatus(EmployerId, status);
	    return ResponseEntity.ok("Employer status updated successfully.");
	}

}
