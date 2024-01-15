package collection.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaWordApp {
    //JavaWord 는 단어 객체, JavaWordBook 은 단어장 객체
    //단어장을 시작하는 프로그램입니다.
    public static void main(String[] args) {
        

        //단어장을 시작하는 프로그램입니다.
        //1. 단어장을 생성
        JavaWordBook myBook = new JavaWordBook();


        //2. 단어를 추가
        JavaWord newWord = new JavaWord("public", "공용의", 1);
        myBook.addWord(newWord);
        myBook.addWord(new JavaWord("private", "개인적인", 1));
        myBook.addWord(new JavaWord("protected", "보호하는", 1));
        myBook.addWord(new JavaWord("iterate", "반복하다", 3));
        myBook.addWord(new JavaWord("collection", "수집", 2));
        myBook.addWord(new JavaWord("application", "응용프로그램", 2));
        myBook.addWord(new JavaWord("binary", "2진수의", 3));

        //메모장 출력
        myBook.wordAll();

        //3. 단어를 조회
        //(1) 영어단어를 입력하면 찾아주기
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("단어 입력 >>> ");
            String findWord = sc.nextLine();
            JavaWord word = myBook.searchWord(findWord);
            if(findWord.equals("e")){
                break;
            }
            if(word != null){
                System.out.println(String.format("조회 결과 : %5s\t %5s\t %3d", word.getEnglish(),word.getKorean(),word.getLevel()));
            }else{
                System.out.println("단어 없음");
            }
            
        }

        //(2) List<JavaWord> searchWordByLevel(int level) : 레벨로 조회하기
        // myBook.wordListPrint(list);
        List<JavaWord> list = myBook.searcJavaWordByLevel(2);
        JavaWordBook.wordListPrint(list);
        
        

        //4. 단어를 삭제
        while (true) {
            System.out.print("삭제할 단어 입력 >>> ");
            String eng = sc.nextLine();
            myBook.removeWord(eng);
            if(eng.equals("e")){
                break;
            }
        }
        myBook.wordAll();
        


        
        

    sc.close();
    }
}
