package com.example.demo;

import com.example.api.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.service.ProductService;
import com.example.api.model.Product;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ProductControllerTest.class})
@Import(ProductController.class)
@WebMvcTest(ProductControllerTest.class)
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    void hello() throws Exception {
        Product prod = new Product();
        prod.setSku_id(55609029);
        when(productService.getProduct(55609029))
                .thenReturn(prod);
        mvc.perform(MockMvcRequestBuilders.get("/product?sku_id=55609029"))
                .andDo(print())
                .andExpect(status().isOk());
        verify(productService).getProduct(55609029);
    }

}
