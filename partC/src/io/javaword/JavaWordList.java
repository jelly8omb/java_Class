package io.javaword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import collection.day10.JavaWord;

/**
 * JavaWordApp_V4 : 메모장 list 초기화를 initialize 메소드 사용하지 않고
 *                  단어장.txt 파일에서 읽어오도록 변경
 */
public class JavaWordList implements WordList{
    private List<JavaWord> words;
    private String filePath;
    
    public JavaWordList(String filePath) {
        System.out.println("단어장의 최대 저장 개수 : " + WordList.MAX_LENGTH);
        words = new ArrayList<>();
        this.filePath=filePath;
    }

    //새로운 단어등록, 기존단어 삭제 등의 변경사항을 파일에 저장하기
    public void fileSave(){
        File file = new File("단어장.txt");
        try(PrintWriter pw = new PrintWriter(file)) {
            //words 에 있는 리시트의 모든 데이터를 파일로 출력하기
            for(JavaWord word : words){
                pw.println(word);
            }
        } catch (IOException e) {
            System.out.println("파일 출력 예외 : " + e.getMessage());
        }
    }
   
    //단어장.txt에서 데이터를 읽어와서 words 리스트에 담기
    public void fileLoad() {
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line=br.readLine())!=null) {
                String[] str = line.split(",");
                JavaWord javaword = new JavaWord(str[0].trim(), str[1].trim(), Integer.parseInt(str[2].trim()));
                words.add(javaword);
            }
        } catch (IOException e) {
            System.out.println("파일 입력 오류 : " + e.getMessage());
        }
    }

    // 지정된 인덱스 i 의 JavaWord 객체 리턴
    @Override
    public JavaWord getWord(int i) {
       return words.get(i);
    }


    //단어장 전체 리스트 리턴
    @Override
    public List<JavaWord> list() {     //getWords 에서 이름 변경
        return words;
    }

    //단어 추가
    @Override
    public void add(JavaWord word) {
        if(words.size()==WordList.MAX_LENGTH){
            System.out.println("단어장이 꽉 찼습니다. 단어장을 새로 만들어주세요.");
            return;
        }
        words.add(word);
    }

    //전달받은 영어 단어의 인덱스를 배열로 리턴합니다.-조회 및 삭제 기능에 사용할 새로운 메소드
    //words 리스트의 인덱스 위치 position부터 단어 english를 찾기.
    @Override
    public int indexOfWord(String english,int position){
        for(int i=position;i<words.size();i++){
            if(words.get(i).getEnglish().equals(english))
                return i;       //찾으면 인덱스 리턴
        }   
        return -1;
    }

    //단어를 인덱스로 삭제
    @Override
    public JavaWord remove(int index) {
        JavaWord word = words.remove(index);    //삭제한 데이터를 리턴합니다.
        return word;
    }

    //단어 1개 조회(여러개 일때는 처음 1개)
    public JavaWord searchFirstByEnglish(String english) {
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
                return word;        //인자로 전달된 english 와 같은 word 리턴(메소드 종료)
            }
        }
        return null;            
    }
    
    //단어 목록 조회
    @Override
    public List<JavaWord> searchAllByEnglish(String english){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getEnglish().equals(english)) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }
    public List<JavaWord> searchAllByLevel(int level){
        List<JavaWord> list = new ArrayList<>();    //검색 결과 저장할 리스트
        for(JavaWord word : words) {
            if(word.getLevel()==level ) {
               list.add(word);          //일치하는 하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }
    //인스턴스 메소드 : 인스턴스 필드 words 를 사용하여 동작.
    @Override
    public void print(){
        for(JavaWord word : words) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }
   
    // 출력 메소드 
    // static 메소드 : 인스턴스 필드를 사용하지 않고 메소드 인자를 받아 동작.
    public static void print(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
    }

   
   

}