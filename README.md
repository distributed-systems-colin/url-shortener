# URL Shortener

## Overview

This project is a simplified system design implementation of a URL shortening service. It focuses on converting long URLs into short, unique identifiers and efficiently redirecting users back to the original destination at scale.

The goal is to understand how high-read, low-write systems are designed and how simple services can scale into globally distributed systems.

---

## Problem Statement

URL shorteners must generate unique, compact identifiers for long URLs and resolve them quickly and reliably. While the core functionality is simple, scaling introduces challenges around uniqueness, storage, caching, and high read traffic.

This project explores how to design a system that supports fast redirection, collision-free ID generation, and scalable storage.

---

## Learning Objectives

- Understand high read-to-write system design patterns
- Learn unique ID generation strategies (hashing vs base encoding vs counters)
- Explore database modeling for fast lookups
- Understand caching strategies for hot URLs
- Learn about scalability and partitioning of key-value systems
- Explore tradeoffs between simplicity and global uniqueness
- Build intuition for stateless service design

---

## Core Features

### URL Mapping
- Convert long URLs into short identifiers
- Retrieve original URL from short code
- Handle duplicate URL submissions (optional behavior)

### ID Generation
- Base62 encoding of numeric IDs
- Hash-based generation (conceptual alternative)
- Collision handling strategies

### Redirect System
- Fast lookup and redirect to original URL
- HTTP redirect handling (301/302 conceptually)
- Low-latency read optimization

### Storage Layer
- Key-value mapping of short code → long URL
- Persistent storage for URL mappings
- Efficient lookup by short ID

---

## Architecture (Conceptual)

### API Layer
- Accepts URL shortening requests
- Returns generated short URLs
- Handles redirect requests

### ID Generator
- Produces unique identifiers for each URL
- Ensures no collisions in generated keys

### Storage Layer
- Stores mapping between short code and original URL
- Optimized for fast read access

### Cache Layer (Optional)
- Stores frequently accessed URLs
- Reduces database load for hot links

---

## Engineering Considerations

- Collision-free ID generation strategies
- Read-heavy workload optimization
- Cache hit rate impact on latency
- Horizontal scaling of redirect service
- Key space exhaustion considerations
- Tradeoffs between deterministic vs random IDs
- Consistency vs availability in distributed storage

---

## Integration Ideas

- Rate Limiter (prevent abuse/spam link creation)
- Distributed Cache (hot URL acceleration)
- Load Testing (redirect latency benchmarking)
- Monitoring system (track click-through and latency)
- Backend services (shared utility for link generation)

---

## Status

🟡 Planned
