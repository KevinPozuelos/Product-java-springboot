package com.ecommer.product_service.service;

import com.ecommer.product_service.dto.ProductRequestDTO;
import com.ecommer.product_service.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(String id);

    ProductResponseDTO updateProduct(String id, ProductRequestDTO productRequestDTO);

    void deleteProduct(String id);
}
