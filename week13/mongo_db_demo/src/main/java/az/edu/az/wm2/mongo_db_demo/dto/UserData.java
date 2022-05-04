
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
public class UserData implements Serializable
{

    public Long id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String phone;
    public String website;
    public Company company;
    private final static long serialVersionUID = 220998645509867944L;

}
