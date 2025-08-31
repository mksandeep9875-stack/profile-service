package com.menon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer/v1")
public class MainRestController {
    private static final Logger logger = LoggerFactory.getLogger(MainRestController.class);

    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    CustomerService tokenService;

    @PostMapping("update/profile")
    public ResponseEntity<?> updateUserDetails(@RequestBody Profile profile,
                                               @RequestHeader("Authorization") String token) {
        logger.info("Request received to update user profile: " + profile);
        Principal principal = tokenService.validateToken(token);
        if (principal.getState().equals("VALID")) {
            logger.info("Token validated successfully");
            // Token is valid, proceed with the update

            if (profile.getPhone().equals(principal.getUsername())) // AUTHORIZATION OF REQUEST HAPPENS HERE
            {
                logger.info("Phone number matches with the token");
                profileRepository.save(profile);
                logger.info("Profile updated successfully in the database: " + profile);
                return ResponseEntity.ok("Profile Updated Successfully");
            } else {
                logger.info("Phone number does not match with the token");
                return ResponseEntity.status(401).body("Unauthorized: Phone number does not match with the token");
            }

        } else {
            logger.info("Token not valid");
            return ResponseEntity.status(401).body("Unauthorized: Invalid Token");
        }
    }
}
