package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SampleController {

    @RequestMapping("/child1")
    public String helloWorld(){
            System.out.println("child1 called");
        return "Response of First Child";
    }

    @PostMapping("/child2")
    public String helloWorld2(@RequestBody String msg){
        System.out.println("child2 called with msg:"+msg);
        return "Response of Second Child "+msg;
    }

    @PostMapping("/child3")
    public String helloWorld3(){
        System.out.println("child3 called");
       throw new IllegalArgumentException("Illegal argument exception thrown");
    }
}
