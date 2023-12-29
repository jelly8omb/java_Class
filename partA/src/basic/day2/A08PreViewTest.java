package basic.day2;

public class A08PreViewTest {
    public static void main(String[] args){
        char start = 'A';

        //반복명령 while 맛보기
        while (start <= 'Z') {   // < 는 작다
            System.out.print(start++);
        }
        System.out.println("\n-------------------------");
        
        while (start > 'A') {
            System.out.print(--start);
        }
    }
    
}
