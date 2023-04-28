package az.edu.ada.wm2.resfuldemo.model.mapper;

import az.edu.ada.wm2.resfuldemo.model.dto.ProductDto;
import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "pricePerItem", target = "price")
    ProductDto productToProductDto(Product product);

    List<ProductDto> productListToProductDtoList(List<Product> products);

    Product productDtoToProduct(ProductDto productDto);
}
