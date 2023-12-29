package basic.day2;

public class HomeStringFormat {
    public static void main(String[] args){
        // String.format()에 대한 예제를 작성하고 실행도 시켜보세요.
        // %s = 문자열, %d = 정수
        String name = "길현";
        int age = 27;
        System.out.println(String.format("제 이름은 %s이고 나이는 %d입니다.", name, age));
    }
    
}
