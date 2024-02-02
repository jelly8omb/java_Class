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
        return "예매 번호 : " + res_idx + ", 예매자 닉네임 : " + custom_id + ", 영화 제목 : " + title + ", 예매일 : "
                + res_date + "]";
    }


}
