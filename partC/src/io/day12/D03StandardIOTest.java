package io.day12;

import java.io.IOException;

//표준 입출력 테스트
//키보드 입력 : new Scanner(System.in); 또는 System.console().readLine();
public class D03StandardIOTest {
    
    public static void main(String[] args) {
        int b;
        System.out.print("입력하기. → ");
        //표준입출력은 모든 글자가 2바이트.=> 윈도우 터미널 인코딩 방식
        try{
            int count = 0;
            while ((b=System.in.read()) != -1) {    // -1(입력끝)은 Ctrl + Z
                // System.out.println(b);   //문자 인코딩 안하고 정수값 출력
                //System.in.read() 로 입력받은 정수값을 문자로 인코딩하는 메소드
                System.out.write(b);
                count++;
            }
            System.out.println("총 입력 바이트 수 : " + count);
            

        }catch(IOException e){
            System.out.println("에외 : " + e.getMessage());
        }
    }
}
