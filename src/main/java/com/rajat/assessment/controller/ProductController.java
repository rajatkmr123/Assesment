package com.rajat.assessment.controller;

import com.rajat.assessment.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class ProductController {
    @GetMapping("/api/getproductdetails")
    public ResponseEntity getProductDetails() {
        final List<ProductDTO> productDTOS = new ArrayList<>();
        IntStream.range(1, 10).forEach(e -> {
                    final ProductDTO productDTO = new ProductDTO();
                    productDTO.setId((long) e);
                    productDTO.setName("Product_" + e);
                    productDTO.setPrice(100D * e);

                    productDTOS.add(productDTO);
                }
        );
        return ResponseEntity.status(HttpStatus.OK).body(productDTOS);
    }
}
