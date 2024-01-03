package basic.day4;

public class A24StaticMethod {
    // 프로그램을 실행시키는 main이 static 이므로 여기서 같이 사용할 수 있는
    //              다른 static 메서드 연습
    // 메서드를 만드는 목적은 특정 처리 기능을 main 에서 따로 분리하기 (구조화)
    //                  한 번 만들어진 메서드는 여러번 필요할 때 실행할 수 있다. (재사용)
    //                  메서드는 클래스의 구성요소.


    public static void main(String[] args) {
        argumentTest();     // 메서드 호출. 이름과 형식이 맞는 메서드를 찾아서 실행합니다.
        argumentTest(999);
        argumentTest(100, 333);     // 100, 333은 실매개변수
        // 메서드가 실행될 때 실매개변수값이 형식매개변수로 전달, 저장됩니다.
        // argumentTest("100", 333);    // 형식에 맞는 메서드 없음
        int a= 100, b = 999;
        argumentTest(a, b);     // 실매개변수 a, b 입니다.
        
        int result = resultIntTest(); // 리턴값 있는 메서드이므로 결과를 변수에 저장할 수 있습니다.
        System.out.println("result = " + result);

        // result = resultIntTest(); 메서드 리턴형식과 변수형식이 불일치하므로 오류

        boolean bool = resultBooleanTest();
        System.out.println("bool = " + bool);

        String str = resultStringTest();
        System.out.println("str = " + str);

        char ch = resultCharTest();
        System.out.println("ch = " + ch);

        // int add = add(1, 2, 3);
        // System.out.println(add);
        System.out.println("add(13, 14, 15) : " + add(13, 14, 15));
        System.out.println("add(56, 65, 45) : " + add(56, 65, 45));
        System.out.println("add(4.4, 3.3, 43.3) : " + add(4.4, 3.3, 43.3));
        System.out.println("add(4.4, 3.3, 43.3) : " + add(4.4, 3.3, 43.3));

        // double ad = add(1.1, 2.2, 3.3);
        // System.out.println(ad);
        ///////////////////////////////////////////////////////////////
        System.out.println(resultIntTest());
        System.out.println(resultBooleanTest());
        System.out.println(resultStringTest());
        System.out.println(resultCharTest());
    }

    // 1 ~ 4은 리턴은 없다. 인자로 선언된 () 안에 변수는 메서드의 지역변수 입니다.
    // 1) 인자값 없는 메서드
    public static void argumentTest(){
        System.out.println("인자값 없는 메서드입니다.");
    }
    // 2) 인자가 1개 있는 메서드
    public static void argumentTest(int i){     // 인자로 사용된 변수 i는 argumentTest 에서만 사용
        System.out.println("인자가 1개 정수 " + i);
    }
    // 3) 인자가 2개 있는 메서드
    public static void argumentTest(int i, int j){ // i, j 는 형식매개변수
        System.out.println("인자가 2개 정수 i = " + i + ", j = " + j);
        System.out.println("i + j = " + (i + j));
    }
    // 4) 리턴값이 int 정수인 메서드 : 리턴은 메서드 실행한 결과값입니다.
    public static int resultIntTest(){
        System.out.println();
        return 999;
    }
    // 5) 리턴값이 boolean 인 메서드
    public static boolean resultBooleanTest(){
        return false;
    }
    // 6) 리턴값이 String 인 메서드
    public static String resultStringTest(){
        return "Hello";
    }
    // 7) 리턴값이 char 인 메서드
    public static char resultCharTest(){
        return 'a';
    }

    // 4 ~ 7 까지 main 메서드에서 어떻게 실행해야 할지 테스트

    // 인자와 리턴값을 모두 갖는 메서드
    public static int add(int a, int b, int c){
        return a + b + c;
    }

    public static double add(double a, double b, double c){
        return a + b + c;
    }


}
