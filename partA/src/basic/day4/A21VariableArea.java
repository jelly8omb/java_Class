package basic.day4;
// 변수 선언 위치  -> 변수 사용 범위가 결정됩니다.
public class A21VariableArea {

    int number = 999;   // 1. 클래스 범위에서 사용되는 변수
    static int number2 = 999;

    public static void main(String[] args) {
        
        int a = 23;     // 2. main 메서드 범위에서 사용되는 변수

        for(int i = 0; i < 10; i++){        // 3. 특정 블럭(for) 안에서 사용되는 변수 - i
            System.out.println("i = " + i);
        }

        while (a == 23) {       // 참
            int count;      // 3. 특정 블럭(while) 안에서 사용되는 변수 - count
            System.out.println("a = " + a);
            count = 100;
            System.out.println("count = " + count);
            // 종료 조건이 없으면 무한 반복(loop)
            a = 24;
        }
        System.out.println("a = " + a);
        // System.out.println("i = " + i);          // 문법 오류 - 이 지점에서 i는 알수 없는 변수
        // System.out.println("count = " + count);  // 문법 오류 - count
        /*
         * 진도를 이후에 나갈 내용 : main 메서드에 static 메서드입니다. static은 static 끼리만 서로 사용할 수 있다.
         */
        // System.out.println("number = " + number);   // static 이 아닌 클래스 선언 변수는 사용 못함.
        System.out.println("number2 = " + number2);
    }
}
