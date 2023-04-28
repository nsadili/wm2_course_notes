package ada.edu.az.wm2.restconsumerdemo.dto;

import lombok.Data;

@Data
public class ProductResultDto {
    private String name;

    private String desc;

    private Integer id;

    private Double pricePerItem;
}
