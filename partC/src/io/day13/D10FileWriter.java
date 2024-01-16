package io.day13;

import java.beans.JavaBean;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import collection.day10.JavaWord;

public class D10FileWriter {

    public static void main(String[] args) {
       
        readByScanner();

    }
    public static void writeByBuffer(){
        String filePath = "단어장2.txt";
        int count=0;
      

        try( BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){

            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                bw.append("안녕하세요"+i+"\r\n");        
                //append 기존 내용 뒤에 추가 //new FileWriter(filePath, true) 생성자에 설정필요
                // bw.write("안녕하세요"); //기존파일에 덮어쓰기
                count++;
            }
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }

    public static void writeByPrintWriter(){        
        String filePath = "단어장3.txt";
        int count=0;
        File file = new File(filePath);
        //PrintWriter : 1. print,println 메소드 사용할 수 있음. 
        //              2. File 객체를 인자로 합니다.
        try(FileWriter fw = new FileWriter(file, Charset.forName("UTF-8"));
            PrintWriter pw = new PrintWriter(fw)){
            
            
            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                pw.append("할로~"+i+"\r\n");
                pw.print("안녕하세요"+i+"\r\n");       
                count++;
            }
            
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }

     public static void readByScanner(){
        String filePath = "단어장.txt";
        int count=0;
        List<JavaWord> list = new ArrayList<>();
        //Scanner 클래스 : 1. 한줄씩 읽어오는 nextLine() 메소드, 2. 구분기호로 분리해서 읽어오는 방법
        try( Scanner fc = new Scanner(new FileReader(filePath))){

            fc.useDelimiter(",|\\n");       //구분기호(delimiter)를, 또는 엔터

            // 파일의 끝까지 반복
            while (fc.hasNext()) {                  //구분기호로 분리된 데이터가 있으면
                list.add(new JavaWord(fc.next(), fc.next(), Integer.parseInt(fc.next().trim())));
                // String token = fc.next();           //next 메소드로 가져오기
                // System.out.println(token);
                count++;
            }

    } catch (Exception e) { }
        System.out.println(list);
        System.out.println("읽은 단어수 : "+count);
        for(JavaWord word : list){
            System.out.println("생성된 객체 : " + word);
        }
    }
}
