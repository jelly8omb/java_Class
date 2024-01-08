package object.test;

import object.day7.Diamond;

public class B11DiamondTest {
    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        System.out.println("다이아몬드 너비 : " + diamond.getWidth());
        System.out.println("다이아몬드 높이 : " + diamond.getHeight());
        System.out.println("다이아몬드 넓이 : " + diamond.calculateArea());
        diamond.print();

        // diamond.round = 3;
        // diamond.etc = "테스트";
        // System.out.println("변경된 내용 확인 : " + diamond.round);
        // System.out.println("변경된 내용 확인 : " + diamond.etc);

        diamond.border = 3.45; //패키지도  다르고  상속관계도 아니지만
    }
}
