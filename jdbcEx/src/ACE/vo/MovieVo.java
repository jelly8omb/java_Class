package ACE.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class MovieVo {
    private String title;
    private String category;
    private int view_age;
    private int price;


    @Override
    public String toString() {
        return String.format("%5s %10s %20s \t %8d", title, category, view_age, price);
    }
}
