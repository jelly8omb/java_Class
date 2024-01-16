package io.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D08FileReader {

    public static void main(String[] args) {

        long start = System.currentTimeMillis(); //1000분의 1초
        readByCharBuffer();
        long end = System.currentTimeMillis();
        System.out.println(String.format("실행 소요 시간 : %,d", (end-start)));

    }

    
    public static void readByChar(){
        String filePath = "C:\\\\Windows\\\\PFRO.log";      //251ms
        //문자열 저장하고 변경할수 있는 가변 객체
        StringBuilder content = new StringBuilder();
        int charValue;
        int count=0;

       try( FileReader fr = new FileReader(filePath)){

         while ((charValue = fr.read()) != -1) {        //read는 문자단위 입력
            System.out.print((char)charValue);   //문자단위이므로 표준 출력가능
            //파일에서 줄바꿈 2바이트 \r\n (10과13)
            // int 값을 char로 변환하여 StringBuilder에 추가
             content.append((char)charValue);
             count++;
        }   
    } catch (Exception e) { }
        // FileReader 닫기
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // 파일에서 읽은 내용 출력
        System.out.println(content.toString());
        System.out.println("읽은 문자수 : "+count);
    }

    public static void readByCharArray(){
        // String filePath = "단어장.txt";
        String filePath = "C:\\Windows\\PFRO.log";      //27ms
        // StringBuilder content = new StringBuilder();
        char[] charValues = new char[256];
        int charCount = 0;
        int count=0;
        int b;

       try( FileReader fr = new FileReader(filePath)){
        
         while ((b = fr.read(charValues,0,256)) != -1) {
            //읽은 문자의 개수는 리턴. b에 저장
            System.out.print(new String(charValues,0,b)); 
                                                //String 생성자 : 배열이름, 시작위치, 길이를 인자로 문자열 만듭니다.
            // int 값을 char로 변환하여 StringBuilder에 추가
            //  content.append(charValues,0,b);    //
             count+=b;
             charCount+=b;      //문자의 개수 회수 수식
             count++;           //while 반복 회수 수식
        }   
    } catch (Exception e) { }
        // FileReader 자동 닫기

        // 파일에서 읽은 내용 출력
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        // System.out.println(content.toString());
        System.out.println("읽은 문자수 : " + charCount);
        System.out.println("반복 횟수 : "+count);
    }
    //읽은 문자수 : 17252
    //반복 횟수 : 17320

    public static void readByCharBuffer(){
        String filePath = "C:\\Windows\\PFRO.log";      
        //40ms. 한 줄이 256문자보다 많이 적으면 위의 char 배열보다 시간은 더 소요될수 있습니다.
        char[] charValues = new char[256];
        int count=0;        //읽은 라인. 문자기반 버퍼스트림 `라인(줄) 단위로 입출력` 기능이 있습니다.
        int b;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;    //라인 단위로 읽어서 저장할 변수
            while ((line = br.readLine()) != null) {        //readLine 은 String 리턴
                System.out.println(line);
                count++;
            }
        }catch(IOException e){
            System.out.println("파일 입력 제외 : " + e.getMessage());
        }
        System.out.println("읽어온 라인 수 : " + count);
    }
    
    
}
