package com.colinlekvin.shorten.controller;

import com.colinlekvin.shorten.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    private final UrlRepository urlRepository;

    HelloWorldController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/testDb")
    public String testDb() {
        try {
            this.urlRepository.save("testing short save", "originalurl.com/longhashgoeshere");
            return this.urlRepository.findOriginalUrl("'testing short save'");
        } catch (Exception e) {
            System.out.println(e);
            // slf4j logger here
        }
        return null;
    }
}
