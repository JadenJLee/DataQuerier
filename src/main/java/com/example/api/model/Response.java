package com.example.api.model;

import java.util.List;

/**
 * Response Object to hold the response from the JSON.
 * Holds numFound (Documents), start, numFoundExact, and docs (Which in this case, holds the Product information).
 */
public class Response {
    public int numFound;
    public int start;
    public Boolean numFoundExact;
    public List<Product> docs;

    public List<Product> getDocs() {
        return docs;
    }

    public int getNumFound() {
        return numFound;
    }

    public int getStart() {
        return start;
    }

    public boolean getNumFoundExact() {
        return numFoundExact;
    }
}
