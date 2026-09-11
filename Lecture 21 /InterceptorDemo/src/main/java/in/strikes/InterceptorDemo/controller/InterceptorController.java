package in.strikes.InterceptorDemo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/students")

public class InterceptorController {

    @PostMapping
    public ResponseEntity<String> createStudent(){


        System.out.println("controller called");
        return ResponseEntity.ok("student created");
    }

}
