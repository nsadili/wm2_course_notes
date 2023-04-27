package az.edu.ada.wm2.demoForRest.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private Integer id;
    private String name;
    private String description;
    private Double price;

}
