
package az.edu.az.wm2.mongo_db_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.annotation.Generated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Generated("jsonschema2pojo")
public class Address implements Serializable
{
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;
    private final static long serialVersionUID = -745778365325712202L;

}
