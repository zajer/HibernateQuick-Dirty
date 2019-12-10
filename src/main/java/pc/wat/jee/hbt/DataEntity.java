
package pc.wat.jee.hbt;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;


@Data
@Entity
@Table(name="SomeData")
@Builder
public class DataEntity implements Serializable {
    @Id
    private String id;
    private String c1;
    private String c2;
}
