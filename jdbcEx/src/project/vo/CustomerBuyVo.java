package project.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class CustomerBuyVo {
    private int buy_idx;
    private String pcode;
    private String pname;
    private int price;
    private int QUANTITY;
    private Timestamp buy_date;

    

   


    @Override
    public String toString() {
        return "CustomerBuyVo [" + buy_idx + ", " + pcode + ", " + pname + ", " + price
                + ", " + QUANTITY + ", " + buy_date + "]";
    }

    
    

    
}
