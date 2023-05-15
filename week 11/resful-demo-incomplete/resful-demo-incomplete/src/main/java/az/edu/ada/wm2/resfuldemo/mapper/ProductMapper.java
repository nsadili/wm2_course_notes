package az.edu.ada.wm2.resfuldemo.mapper;

import az.edu.ada.wm2.resfuldemo.model.dto.ProductDto;
import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "description", target = "desc")
    ProductDto productToProductDto(Product product);

    List<ProductDto> productListToProductDtoList(List<Product> productList);
}