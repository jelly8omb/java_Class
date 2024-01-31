package ACE.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class ViewerVo {
    private String custom_id;
    private String name;
    private int age;

    
    @Override
    public String toString() {
        return "ViewerVo [custom_id=" + custom_id + ", name=" + name + ", age=" + age + "]";
    }

    
}
