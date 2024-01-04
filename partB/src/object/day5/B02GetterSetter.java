package object.day5;

public class B02GetterSetter {
    public static void main(String[] args) {
        MyClass2 momo = new MyClass2();
        System.out.println("MyClass2 의 필드 field1 값 : " + momo.getField1());
        momo.setField1("나는 모모.");
        System.out.println("MyClass2 의 필드 field1 값 : " + momo.getField1());
        String message = "WELCOME~";
        momo.setField1(message);
        System.out.println("MyClass2 의 필드 field1 값 : " + momo.getField1());


        System.out.println("MyClass2 의 필드 field2 값 : " + momo.getField2());
        momo.setField2(12345);
        System.out.println("MyClass2 의 필드 field2 값 : " + momo.getField2());
        System.out.println("\n지금까지의 momo 객체 값들은...");
        momo.printData();
        int test = 1234;
        momo.setField2(test);
        System.out.println("MyClass2 의 필드 field2 값 : " + momo.getField2());

        momo.printData();

        System.out.println("~~~~~field3은 double배열 타입입니다.");
        double[] dArray = momo.getField3();
        System.out.println("field3 : " + dArray);
        
        double[] tempArray = {1.2, 3.44, 67.12};
        momo.setField3(new double[5]);
        System.out.println("변경된 field3 : ");
        momo.printData();
        

        System.out.println("변경된 field3 : ");
        momo.setField3(tempArray);
        momo.printData();

        // setField3을 변수로 전달했을 때
        tempArray[2] = 3.1415;
        System.out.println("변경된 field3 : ");
        momo.printData();        


    }
}
