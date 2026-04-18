package com.ecommer.product_service.mapper;

import com.ecommer.product_service.dto.ProductRequestDTO;
import com.ecommer.product_service.dto.ProductResponseDTO;
import com.ecommer.product_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequestDTO requestDTO);

    ProductRequestDTO toProductRequestDTO(Product product);

    @Mapping(source = "description", target = "description")
    ProductResponseDTO toProductResponseDTO(Product product);

    @Mapping(target = "id", ignore = true)
    void updateProduct(ProductRequestDTO productRequest, @MappingTarget Product product);
}
