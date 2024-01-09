package object.day8;

import object.day7.Diamond;
import object.day7.Shape;
import object.day7.Triangle;
import object.test.Square;

/*
 * 모든 자바 클래스의 부모는 Object 타입
 */
public class B14ObjectTest {
    public static void main(String[] args) {
        //Object 타입의 업 캐스팅
        Object ob1 = new String("Hello java~");
        Object ob2 = new Diamond();
        Object ob3 = 3;     //int -> Integer 객체로 변경 -> Object로 참조
        //기본형 타입 Wrapper 클래스로 객체로 변경되서 Object 로 업 캐스팅
        //              ㄴ Byte, Character, Short, Integer, Long, Float, Double
        //              ㄴ 다른 자료구조 List, Map, Set 등은 객체(클라스) 타입만 다릅니다.

        //Object 클래스의 메서드 - 모든 자바클래스가 상속받고 있습니다.
        //                      ㄴ getClass, toString, hashcode, equals, 그 외는 스레드 관련 메서드
        //                      ㄴ String 클래스 equals 는 Object 메서드 재정의(오버라이드)
        
        System.out.println("getClass는 클래스의 타입 정보를 리터합니다. ");
        System.out.println("\t ob1 getClass = " + ob1.getClass().getName());
        //
        System.out.println("\t ob2 getClass = " + ob2.getClass().getName());

        System.out.println("\t ob3 getClass = " + ob3.getClass().getName());

        System.out.println("hashcode는 객체의 참조값(식별값)을 리턴");
        System.out.println("\t ob1 hashcode = " 
        + ob1.hashCode() + "," + Integer.toHexString(ob1.hashCode()));
        System.out.println("\t ob2 hashcode = " 
        + ob2.hashCode() + "," + Integer.toHexString(ob2.hashCode()));
        System.out.println("\t ob3 hashcode = " 
        + ob3.hashCode() + "," + Integer.toHexString(ob3.hashCode()));


        System.out.println("toString 확인-참조변수를 출력할때 문자열 표현값 리턴");
        System.out.println("\t ob1 toString = " + ob1.toString());      //String 은 toString 재정의 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        System.out.println("\t ob1 toString = " + ob2.toString());      //Onject toString 의 기본값 출력
        System.out.println("\t ob1 toString = " + ob3.toString());      //Integer는 toString 재정의
        System.out.println("\t ob1 toString = " + ob1);     //toStirng 메서드는 생략하고 쓸 수 있다.
        System.out.println("\t ob1 toString = " + ob2);
        System.out.println("\t ob1 toString = " + ob3);

        
        System.out.println("우리가 만든 계정의 toString 재정의 확인");
        Shape sh2 = new Shape("아직모름", 25,20);
        Shape diamond = new Diamond();      //인스턴스 필드는 초기값 0입니다.
        Shape square = new Square();
        Triangle triangle = new Triangle("삼각형", 20, 30, 65);
        System.out.println("\t sh2 = " + sh2);
        System.out.println("\t sh2 = " + diamond);  //자식클래스 Diamond 정의한 toString
        System.out.println("\t sh2 = " + square);   //부모 Shape이 정의한 toStirng
        System.out.println("\t sh2 = " + triangle); //부모 Shape이 정의한 toStirng
    }
}
