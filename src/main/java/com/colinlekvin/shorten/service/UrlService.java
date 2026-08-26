package com.colinlekvin.shorten.service;

import com.colinlekvin.shorten.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    // Creates a shortened URL for the provided long URL and saves the mapping to the database.
    public String createShortUrl(String longUrl) {
        String shortUrl = UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 8);

        this.saveUrl(shortUrl, longUrl);
        return shortUrl;
    }

    // Saves a short URL and its corresponding long URL to the database.
    public void saveUrl(String shortUrl, String longUrl) {
        try {
            this.urlRepository.save(shortUrl, longUrl);
        } catch (Exception e) {
            // slf4j log
        }
    }

    // Retrieves the original URL associated with a shortened URL.
    public String redirectUrlFromShort(String shortUrl) {
        try {
            return this.urlRepository.findOriginalUrl(shortUrl);
        } catch (Exception e) {
            // slf4j log
        }
        return null;
    }
}
