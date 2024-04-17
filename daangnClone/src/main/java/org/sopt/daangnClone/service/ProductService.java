package org.sopt.daangnClone.service;

import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.sopt.daangnClone.domain.Product;
import org.sopt.daangnClone.repository.ProductRepository;
import org.sopt.daangnClone.service.dto.ProductSellDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public String createProduct(
            ProductSellDto productSellDto
    ) {
        Product product = Product.create(productSellDto.title(),productSellDto.isSell(), productSellDto.price(), productSellDto.suggest(), productSellDto.description(), productSellDto.location() );
        productRepository.save(product);
        return product.getId().toString();
    }
}
