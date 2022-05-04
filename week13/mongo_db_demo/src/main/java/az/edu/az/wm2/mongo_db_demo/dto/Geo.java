
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
public class Geo implements Serializable
{

    public String lat;
    public String lng;
    private final static long serialVersionUID = -5068868017795377748L;

}
