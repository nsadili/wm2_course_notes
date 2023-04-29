package az.edu.ada.demo.demo_for_rest_client.dto;

import lombok.Data;

@Data
public class ProductResultDto {

    private Integer id;
    private String name;
    private String desc;
    private Double pricePerItem;
}
