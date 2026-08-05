package com.healthclinicapp;

import com.clinic.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Backward-compatible launcher retained for the original Spring Initializr project. */
@SpringBootApplication(scanBasePackages = "com.clinic")
public class HealthClinicAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
