package etc.day15;



/**
 * InnerMyCalendar
 */
public class InstanceTest {

    public static void main(String[] args) {
        MyCalendar my1 = MyCalendar.getInstance();
        // MyCalendar my2 = new MyCalendar();
        // MyCalendar my3 = MyCalendar.object;

        YourCalendar you1 = YourCalendar.of("2024", "03");
    }
    
}
//main 메소드는 1개 파일에 하나만 있어야 합니다.
//public 클래스도 1개 파일에 하나만 있어야 합니다.
//위에 2가지 지키고 1개 파일에 클래스는 여러개 만들수 있습니다.
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArhsConstructor
// @ToString
// @EqualsAndHashCode
class Member{
    private String name;
    private int age;
    private int point;


}

class MyCalendar {
    private static MyCalendar object = new MyCalendar();
    //field가 현재 클래스의 타입. 미리 생성자로 객체를 만듭니다.

    private MyCalendar() {  //생성자는 private. 다른 클래스에서 사용못함.
    }

    public static MyCalendar getInstance(){
        //미리 만들어진 현재 클래스 타입의 객체를 리턴
        return object;
    }

}

class YourCalendar {
    private String month;
    private String day;

    private YourCalendar(){
        //다른 클래스에서 new 연산 사용못함.
    }
    public static YourCalendar of(String month, String day){
        YourCalendar result = new YourCalendar();
        result.month = month;
        result.day = day;
        return result;
    }
    public String getMonth() {
        return month;
    }
    public String getDay() {
        return day;
    }

    
}
