package com.example.service;

import com.example.api.model.Product;
import com.example.api.model.Reference;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ProductService {

    private List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();
    }

    public Product getProduct(Integer id) throws IOException {
        URL urlString = new URL("http://localhost:8983/solr/testcollection/select?q=sku_id:" + id);
        HttpURLConnection con = (HttpURLConnection) urlString.openConnection();
        con.setRequestMethod("GET");
        Reference ref = null;

        int responseCode = con.getResponseCode();

        if (responseCode == HttpsURLConnection.HTTP_OK) {
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(con.getInputStream());
            while(scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            ref = new Gson().fromJson(String.valueOf(sb), Reference.class);
        } else {
            System.out.println("Error in sending GET Request");
        }
        con.disconnect();

        if (ref == null) {
            throw new NullPointerException("ref is null");
        }
        return ref.getResponse().getDocs().get(0);
    }

    public List<Product> selectQuery(String columnName, String searchValue) throws IOException {
        URL urlString = new URL("http://localhost:8983/solr/testcollection/select?q=" + columnName + ':' + searchValue);
        HttpURLConnection con = (HttpURLConnection) urlString.openConnection();
        con.setRequestMethod("GET");
        Reference ref = null;
        int responseCode = con.getResponseCode();

        if (responseCode == HttpsURLConnection.HTTP_OK) {
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(con.getInputStream());
            while(scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }
            ref = new Gson().fromJson(String.valueOf(sb), Reference.class);
        } else {
            System.out.println("Error in sending GET Request");
        }
        con.disconnect();

        if (ref == null) {
            throw new NullPointerException("ref is null");
        }
        return ref.getResponse().getDocs();
    }
}
