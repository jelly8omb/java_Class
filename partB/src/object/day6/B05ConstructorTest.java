package object.day6;

import java.util.Arrays;

public class B05ConstructorTest {
    public static void main(String[] args) {
        MyClass4 my = new MyClass4();
        System.out.println("기본 생성자 실행");
        System.out.println("\tfield2값을 찍어보자 : " + my.getField2());

        System.out.println("인자 1개 커스텀 생성자 실행");
        
        MyClass4 my1 = new MyClass4(999);
        System.out.println("\tmy1 field2 : " + my1.getField2());

        MyClass4 my2 = new MyClass4("Hello");
        System.out.println("\tmy2 field1 : " + my2.getField1());

        System.out.println("인자 2개 커스텀 생성자 실행");
        MyClass4 my3 = new MyClass4("java", 222);
        System.out.println("\tmy3 field1, field2 : " + my3.getField1() + ", " + my3.getField2());

        System.out.println("인자 3개 커스텀 생성자 실행");
        MyClass4 my4 = new MyClass4("java", 123, new double[3]);
        System.out.println("\tmy4 field1, field2, field3 : " + my4.getField1() + ", " + my4.getField2() + ", " + Arrays.toString(my4.getField3()));

        //기본생성자와 setter가 없는 MyClass5객체를 만들어보자.
        System.out.println("my5");
        MyClass5 my5 = new MyClass5("java", 111, new double[2]);
        // MyClass5 my6 = new MyClass5(null, 0, null); //error 기본 생성자가 없는 오류
        System.out.println("\tmy5 field1, field2, field3 : " + my5.getField1() + ", " + my5.getField2() + ", " + Arrays.toString(my5.getField3()));

        MyClass3 test = new MyClass3();
        test.setField1("Python");
        test.setField2(123);
        test.setField3(new double[]{1.1,2.2,3.3});
        //기본 생성자는 det 메서드로 직접 값을 초기화하는 것이 조금 불편합니다.
        //              -> 초기화를 위해서는 커스텀 생성자가 좋습니다.
        
        //결론 : MyClass3과 같이 생성자가 직접 정의된 것이 없으면 기본 생성자만 쓸 수 있다.
        //      MyClass5와 같이 커스텀 생성자 메서드가 하나라도 정의되어 
        //                     있으면 기본 생성자는 생략하고 사용 못 합니다.
        //                  사용하고 싶으면 직접 정의해야 합니다. => public MyClass5(){}
        
    }
}
