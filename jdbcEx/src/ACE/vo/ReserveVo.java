package ACE.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class ReserveVo {
    private int res_idx;
    private String custom_id;
    private String title;
    private Date res_date;

    
    @Override
    public String toString() {
        return "ReserveVo [res_idx=" + res_idx + ", custom_id=" + custom_id + ", title=" + title + ", res_date="
                + res_date + "]";
    }


}
