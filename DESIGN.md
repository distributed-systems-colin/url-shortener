# Design
## Requirements
- endpoint for shorten url 
- endpoint for redirect url
- stateless java and spring boot service

## MVP Scope
- Creating a shortened URL
- Redirecting a short URL to the original destination
- Storing URL mappings

## High-Level Architecture
- spring boot jar running the api
- database to hold all url mappings

## Data Model
#### Schema design:
- original_url
- short_url
- creation_date
#### Future Fields:
- last_altered_date
- clicks

## API Design
#### POST/shortCode
- take in long url, generate short url, write to db, return short url
#### GET/redirectUrl/{shortCode}
- take in shortUrl and return mapped redirectUrl

## Future Improvements
- endpoint for user dictated short url -- collision and sanitization brings in tons of extra scope
- caching key,value mappings -- consider in app vs db level caching