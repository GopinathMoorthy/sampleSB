package com.example.demo;

import com.example.demo.dto.CustomerDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.util.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SampleController {

    @Autowired
    CustomerDetails customerDetails;

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

    @GetMapping("/child3")
    public String helloWorld3() throws IOException{
        System.out.println("child3 called");
        customerDetails.setResponseCode("503");
        customerDetails.setResponseData("{\"errorCode\":\"503\",\"errorDesc\":\"customerror\"}");
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(customerDetails);
        return jsonInString;
    }

    @GetMapping("/child4")
    public String helloWorld4() throws JsonProcessingException {
        System.out.println("child4 called");
        customerDetails.setResponseCode("200");
        customerDetails.setResponseData("{\"customerName\":\"test_user_name\",\"location\":\"test_location\"}");
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(customerDetails);
        return jsonInString;
    }
}
