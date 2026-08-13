package com.colinlekvin.shorten.repository;

public interface UrlRepository {
    void save(String shortUrl, String originalUrl);
    String findOriginalUrl(String shortUrl);
}