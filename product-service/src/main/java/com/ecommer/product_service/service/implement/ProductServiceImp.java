package com.ecommer.product_service.service.implement;

import com.ecommer.product_service.dto.ProductRequestDTO;
import com.ecommer.product_service.dto.ProductResponseDTO;
import com.ecommer.product_service.exception.ResourceNotFoundException;
import com.ecommer.product_service.mapper.ProductMapper;
import com.ecommer.product_service.model.Product;
import com.ecommer.product_service.repository.ProductRepository;
import com.ecommer.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        Product product = mapper.toProduct(productRequestDTO);

        repository.save(product);
        log.info("Producto {} guardado", product.getName());

        return mapper.toProductResponseDTO(product);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {

        return repository.findAll()
                .stream()
                .map(mapper::toProductResponseDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(String id) {
        Product product = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Producto", "id", id)
        );
        return mapper.toProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(String id, ProductRequestDTO productRequestDTO) {
        Product product = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Producto", "id", id)
        );
        mapper.updateProduct(productRequestDTO, product);
        Product savbedProduct = repository.save(product);

        log.info("Producto{} actualizado", savbedProduct.getName());
        return mapper.toProductResponseDTO(savbedProduct);
    }

    @Override
    public void deleteProduct(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Producto", "id", id);
        }
        repository.deleteById(id);

        log.info("Producto con el id:{} fue eliminado", id);
    }
}
