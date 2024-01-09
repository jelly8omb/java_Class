package object.day8_Interface;

public class B17MyClassBMain {

    public static void main(String[] args) {
        MyClassB myb = new MyClassB();
        //다중 구현 클래스인 MyClassB는
        //두가지 업 캐스팅 가능
        InterfaceX ifx = new MyClassB();
        InterfaceA ifa = new MyClassB();

        myb.methodA();
        ifa.methodA();
        // ifx.methodA();  //오류 : methodA는 InterfaceA의 추상메서드.
                           //다른 인터페이스 참조 타입으로는 메서드 실행 못함.

        ifx.methodX();
        // ifa.methodX();   //오류 : methodX는 InterfaceX의 추상메서드.
                            //다른 인터페이스 참조 타입으로는 메서드 실행 못함.


        InterfaceX ix = (InterfaceX)ifa;
        ix.methodX();
    }
}