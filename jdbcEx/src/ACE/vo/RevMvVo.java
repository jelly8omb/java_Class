package ACE.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class RevMvVo {
    private String custom_id;
    private String title;
    private int price;
    private Timestamp res_date;

    @Override
    public String toString() {
        return "RevMvVo [" + custom_id + ", " + title + ", " + price + ", " + res_date
                + "]";
    }

    
}
