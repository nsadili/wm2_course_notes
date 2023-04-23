package az.edu.ada.wm2.resfuldemo.model.mapper;

import az.edu.ada.wm2.resfuldemo.model.dto.ProductDTO;
import az.edu.ada.wm2.resfuldemo.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
@Mapping(source = )
    ProductDTO productToProductDTO(Product product);

    List<ProductDTO> productListToProductDTOList(List<Product> products);

    Product productDTOToProduct(ProductDTO productDTO);
}
