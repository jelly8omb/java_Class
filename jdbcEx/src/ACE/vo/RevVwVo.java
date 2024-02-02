package ACE.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class RevVwVo {
    private int res_idx;
    private String custom_id;
    private String name;
    private String title;
    private Timestamp res_date;

    @Override
    public String toString() {
        return "예매 번호 : " + res_idx + ", 예매자 이름 : "+ name + ", 예매자 아이디 : " + custom_id + ", 영화 제목 : " + title + ", 예매 날짜 : " + res_date;
    }

    
}
