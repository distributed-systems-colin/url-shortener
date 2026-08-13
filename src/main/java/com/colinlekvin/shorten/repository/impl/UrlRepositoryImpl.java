package com.colinlekvin.shorten.repository.impl;

import com.colinlekvin.shorten.repository.UrlRepository;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UrlRepositoryImpl implements UrlRepository {
    private final JdbcTemplate jdbcTemplate;

    UrlRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(String shortUrl, String originalUrl) {
        String sql = "INSERT INTO url_mapping (original_url, short_url) VALUES ('" + originalUrl + "','" + shortUrl + "')";
        this.jdbcTemplate.update(sql);
    }

    public String findOriginalUrl(String shortUrl) {
        String sql = "SELECT original_url FROM url_mapping WHERE short_url = " + shortUrl;
        return this.jdbcTemplate.queryForObject(sql, String.class);
    }
}
