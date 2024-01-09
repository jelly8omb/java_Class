package object.day8_Interface;

//인터페이스를 다중(여러개)으로 사용하는 구현 클래스 연습입니다.
public class MyClassB implements InterfaceA , InterfaceX {
		
	//InterfaceA의 추상메소드 구현
	@Override
	public void methodA() {
		System.out.println("ㅋㅋ");
		
	}
	
	@Override
	public int methodB(int num) {
		
		return num * 20;
	}
	
	//InterfaceX의 추상메소드 구현
	@Override
	public String methodX() {
		
		return "ㅋㅋㅋ";
	}
}
