
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
public class Company implements Serializable
{

    public String name;
    public String catchPhrase;
    public String bs;
    private final static long serialVersionUID = -3084810873172116939L;

}
