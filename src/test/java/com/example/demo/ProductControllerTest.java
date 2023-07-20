package com.example.demo;

import com.example.api.controller.ProductController;
import com.example.service.ProductService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTest {
    @Test
    public void check_controller_gives_right_sku_id_back() throws Exception {
        ProductController controller = new ProductController(new ProductService());
        int response = controller.getProduct(55609029).getSku_id();
        assertEquals(55609029, response);
    }

    @Test
    public void check_controller_gives_right_array_size() throws Exception {
        ProductController controller = new ProductController(new ProductService());
        int response = controller.select("color", "RINSE").size();
        assertEquals(10, response);
    }

    @Test
    public void check_controller_gives_empty_array() throws Exception {
        ProductController controller = new ProductController(new ProductService());
        int response = controller.select("color", "blue").size();
        assertEquals(0, response);
    }

    @Test
    public void status_code_is_good() throws IOException {
        HttpUriRequest req = new HttpGet("http://localhost:8080/product?sku_id=55609029");
        HttpResponse response = HttpClientBuilder.create().build().execute(req);
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void status_code_is_bad() throws IOException {
        HttpUriRequest req = new HttpGet("http://localhost:8080/product?somethingwrong=32");
        HttpResponse response = HttpClientBuilder.create().build().execute(req);
        assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }
}
