package com.colinlekvin.shorten.controller;

import com.colinlekvin.shorten.repository.UrlRepository;
import com.colinlekvin.shorten.service.UrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {
    private final UrlService urlService;

    UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestParam String fullUrl) {
        return this.urlService.createShortUrl(fullUrl);
    }

    @GetMapping("/recallRedirect")
    public String recallRedirect(@RequestParam String shortUrl) {
        return this.urlService.redirectUrlFromShort(shortUrl);
    }
}
