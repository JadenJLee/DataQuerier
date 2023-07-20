package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Object to retrieve response from JSON object from Solr API Endpoint.
 * Contains Response Object.
 */
@JsonIgnoreProperties("responseHeader")
public class Reference {
    public Response response;

    public Response getResponse() {
        return response;
    }
}
