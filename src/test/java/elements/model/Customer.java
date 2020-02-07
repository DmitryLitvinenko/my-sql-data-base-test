package elements.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String cust_code;
    private String cust_name;
    private String cust_city;
    private String working_are;
    private String cust_country;
    private double grade;
    private BigDecimal opening_amt;
    private BigDecimal receive_amt;
    private BigDecimal payment_amt;
    private String outstanding_amt;
    private String phone_no;
    private List<Agents> agent_code;
}
