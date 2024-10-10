package com.example.healthcheck2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @GetMapping("/api/health")
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now().toString());
        return response;
    }
}

@Controller
class UiController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Health Check Status");
        model.addAttribute("status", "Service is running!");
        model.addAttribute("timestamp", LocalDateTime.now().toString());
        return "index";
    }
}