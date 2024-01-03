package basic.day4;

import java.util.Scanner;

public class A26Test25 {
    public static void main(String[] args) {
        // A25클래스에서 만든 메서드를 사용할 수 있습니다.
        int result = A25mySampleMethod.sumMToN(2,5);
        System.out.println(result);


        // 메서드가 private 으로 정의되면 다른 클래스에서 사용 불가
        // boolean isOk = A25mySampleMethod.checkJumsu(67);

        // 자바 (또는 다른 프로그래밍 언어)로 코딩할 때
        // 1. 자바에서 제공하는 클래스와 메서드를 잘 활용하기
        // 2. 필요에 따라 개발자가 직접 잘 만들어서 쓸 것

        Scanner sc = new Scanner(System.in);
        System.out.print("시작값 입력. >>> ");
        int start = sc.nextInt();
        System.out.print("마지막값 입력. >>> ");
        int end = sc.nextInt();

        System.out.println(start + " ~ " + end + " 까지의 곱하기 결과 : " + A25mySampleMethod.multiplyMToN(start, end));
    }
}
