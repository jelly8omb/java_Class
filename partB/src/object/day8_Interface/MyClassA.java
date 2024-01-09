package object.day8_Interface;

//인터페이스 InterfaceA를 사용하는 구현 클래스 
// -> 객체 생성
public class MyClassA implements InterfaceA {
//InterfaceA 의 추상메소드는 반드시 구현해야한다.
// -> 인터페이스의 구현 클래스가 객체로 생성됍니다.
	
	//오버라이드는 상속에서 사용
	//인터페이스에서는 `구현`이 더 맞다.
	@Override
	public void methodA() {
		System.out.println("ㅎㅎㅎ");
	}
	
	@Override
	public int methodB(int num) {
		System.out.println("ㅎㅎ" + num);
			return num;
	}
	
	
	//InterfaceA 의 static 메소드를 별도로 정의할 수 있습니다.
	//이름이 같아도 override 로 처리하지 않습니다.
	public static void medthodD() {
		System.out.println("MyClassA methodD~~");
	}
}
