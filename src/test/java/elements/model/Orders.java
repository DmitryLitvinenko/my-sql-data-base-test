package elements.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    private int ord_num;
    private BigDecimal ord_amount;
    private BigDecimal advanced_amount;
    private String ord_date;
    private List<Customer> cust_code;
    private List<Agents> agent_code;
    private String ord_description;
}
