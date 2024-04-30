package org.sopt.daangnClone.controller.dto;

import lombok.RequiredArgsConstructor;
import org.sopt.daangnClone.service.ProductService;
import org.sopt.daangnClone.service.dto.ProductSellDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity createProduct(
            @RequestBody ProductSellDto productSellDto
    ) {
        return ResponseEntity.created(URI.create(productService.createProduct(productSellDto)))
                .build();
    }
}
