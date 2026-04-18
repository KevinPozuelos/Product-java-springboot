package com.ecommer.product_service.dataloader;

import com.ecommer.product_service.model.Product;
import com.ecommer.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Product product = Product.builder()
                .name("Samung Galaxy S24")
                .description("Smart Phone")
                .price(BigDecimal.valueOf(1200))
                .build();
        productRepository.save(product);
        System.out.println("Saved product" + product);
    }
}
