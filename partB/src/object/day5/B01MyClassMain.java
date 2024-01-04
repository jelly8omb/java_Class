package object.day5;

import java.util.Arrays;

public class B01MyClassMain {
    public static void main(String[] args) {
        
        // 정의된 클래스 MyClass1 으로 객체를 만듭니다. - new 연산 사용하기
        MyClass1 my1 = new MyClass1();
        // 객체란 데이터 덩어리. new 연산으로 MyClass1 객체를 저장할 메모리 확보
        //                      MyClass1() 는 생성자 메서드. 무조건 클래스 이름과 같다.
        //                                      ㄴ 메모리에 저장공간을 확보하면서 동시에 실행.
        
        System.out.println("my1.field1 : " + my1.field1);   // Stirng
        System.out.println("my1.field2 : " + my1.field2);   // int
        System.out.println("my1.field3 : " + my1.field3);   // double
        /*
         * my1.field1 : null
         * my1.field2 : 0
         * my1.field3 : null
         */
        my1.field1 = "Hi momo";
        my1.field2 = 999;
        my1.field3 = new double[5];

        System.out.println("my1.field1 : " + my1.field1);   // Stirng
        System.out.println("my1.field2 : " + my1.field2);   // int
        System.out.println("my1.field3 : " + my1.field3);   // double
        System.out.println("my1.field3 배열의 크기 : " + my1.field3.length);
        System.out.println("my1.field3 배열 요소의 값 : " + Arrays.toString(my1.field3));
        /*
         * my1.field1 : Hi momo
         * my1.field2 : 999
         * my1.field3 : [D@33c7353a
         * my1.field3 배열의 크기 : 5
         * my1.field3 배열 요소의 값 : [0.0, 0.0, 0.0, 0.0, 0.0]
         */

        MyClass1 my2 = new MyClass1();      // 새로운 MyClass1 객체 생성
        System.out.println("my2 해쉬코드 초기 값 : " + my2.hashCode());
        my2.field1 = "점심먹으러 갑시다.";
        my2.field2 = 12345;
        my2.field3 = new double[]{34.12, 23.99, 6.7};
        System.out.println("my2 해쉬코드(변경 후) : " + my2.hashCode());
    
        System.out.println("my2.field1 : " + my2.field1);   // Stirng
        System.out.println("my2.field2 : " + my2.field2);   // int
        System.out.println("my2.field3 : " + my2.field3);   // double
        System.out.println("my2.field3 배열의 크기 : " + my2.field3.length);
        System.out.println("my2.field3 배열 요소의 값 : " + Arrays.toString(my2.field3));
        /*
         * my2.field1 : 점심먹으러 갑시다.
        * my2.field2 : 12345
        * my2.field3 : [D@681a9515
        * my2.field3 배열의 크기 : 3
        * my2.field3 배열 요소의 값 : [34.12, 23.99, 6.7]
         */
    }
}
