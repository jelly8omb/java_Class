package io.day12;

import java.io.FileOutputStream;
import java.io.IOException;

public class D04KeyInputFileOut {
    public static void main(String[] args) {
        int b;
        System.out.print("입력하기. → ");
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("note.txt");
            //인자로 파일명을 전달합니다.
            int count = 0;
            while ((b=System.in.read()) != -1) {    // -1(입력끝)은 Ctrl + Z
                // System.out.println(b);   //문자 인코딩 안하고 정수값 출력
                //System.in.read() 로 입력받은 정수값을 문자로 인코딩하는 메소드
                // System.out.write(b);
                fos.write(b);               //파일출력스트림으로 데이터 보내기
                count++;
            }
            System.out.println("총 입력 바이트 수 : " + count);
            

        }catch(IOException e){
            System.out.println("에외 : " + e.getMessage());
        }finally{
            //입출력 자원을 해제하는 블럭. 예외 발생 상관없이 처리할 명령어
            try {fos.close();} catch (IOException e) {}
        }
    }
}
//File Input -> 화면(표준) 출력
//File Input -> File Output(파일복사)
//바이트 기반은 문자형식의 파일이 아닐때
//문자기반 스트림 : 문자단위 입출력.