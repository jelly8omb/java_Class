package collection.day10.day11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import collection.day10.JavaWord;

public class JavaWordApp_V1 {
    //private : 현재 클래스에서만 사용할 목적으로 접근 제한한 것.
    private List<JavaWord> words = new ArrayList<>();
    //프로그램 실행을 시작하는 메소드
    private void start(){
        initialize();           //words초기화
        //단어 등록, 목록, 검색, 삭제 기능을 메뉴로 구현하기
        System.out.println("단어장" + "~".repeat(30));
        while (true) {
            System.out.println("\t 메뉴를 선택하세요!");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 출력");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 단어 수정");
            System.out.println("\t 6. 단어장 종료");
            System.out.print("선택 > ");    //메소드에 입력기능이 있을떄는 Scanner관리가 불편
            int select = Integer.parseInt(System.console().readLine()); //키보드 입력 문자열(parseInt) -> 정수
            //System.console() = 시스템의 콘솔 객체를 리턴해줌. readLine() = 입력메소드 실행
            switch (select) {
                case 1:
                    addWord();      //단어 등록 메소드 실행
                    break;
                case 2: 
                    listWord(); 
                    break;  //단어 목록 조회 메소드 실행
                case 3: 
                    searchWord(); 
                    break;  //단어 목록 조회 메소드 실행
                case 4: 
                    removeWord(); 
                    break;  //단어 목록 조회 메소드 실행
                case 5:
                    updateWord();
                    break;
                case 6: 
                    System.out.println("단어장 종료"); 
                        
                    System.exit(select); //main을 종료함
                    break;  //단어 목록 조회 메소드 실행
            
                default:
                    System.out.println("잘못된 선택값입니다.");
                    break;
            }//swich end;
        }//while end;
    }//start end;

    

    private void initialize() {//words초기화
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("private", "개인적인", 1));
        words.add(new JavaWord("protected", "보호하는", 1));
        words.add(new JavaWord("iterate", "반복하다", 3));
        words.add(new JavaWord("collection", "수집", 2));
        words.add(new JavaWord("application", "응용프로그램", 2));
        words.add(new JavaWord("binary", "2진수의", 3));
    }

    private void updateWord() {
        System.out.println("\t::단어를 수정합니다.:::");
        System.out.print("수정할 단어를 입력하세요. _");
        String find = System.console().readLine();
        boolean updateWord = false;
        for(int i=0;i<words.size();i++){
            JavaWord word = words.get(i);
            if (words.get(i).getEnglish().equals(find)) {
                System.out.println(words.get(i).getEnglish() + ", " + words.get(i).getKorean() + ", " + words.get(i).getLevel());
                System.out.print("수정할 영어 단어 ");
                String newEng = System.console().readLine();
                System.out.print("수정할 한글 단어 ");
                String newKor = System.console().readLine();
                System.out.println("수정할 레벨 ");
                int newLv = Integer.parseInt(System.console().readLine());
                
                word.setEnglish(newEng);
                word.setKorean(newKor);
                word.setLevel(newLv);
                updateWord = true;

                System.out.println(word.getEnglish() + ", " + word.getKorean() + ", " + word.getLevel());
            }
        }
        
    }

    private void removeWord() {
        System.out.println("\t::단어를 삭제합니다.:::");
        System.out.print("삭제할 단어를 영문으로 입력하세요. _");
        // String find = System.console().readLine();
        // boolean isFind = false;
        // for(int i=0;i<words.size();i++){
        //     if(words.get(i).getEnglish().equals(find)){
        //         System.out.println("인덱스" + i + "에서 단어를 찾았습니다.");
        //         System.out.print("삭제하려면 엔터, 취소는 n 을 입력하세요.");
        //         if(System.console().readLine().equals("n")){
        //             continue;
        //         } else{
        //             words.remove(i);
        //             System.out.println("단어 삭제 완료");
        //         }
        //     }
        // }
        // if(!isFind){
        //     System.out.println("삭제할 단어가 없습니다.");
        // }
        String remove = System.console().readLine();
        boolean removed = false;
        Iterator<JavaWord> iterator = words.iterator();
        while (iterator.hasNext()) {
            JavaWord word = iterator.next();
            if (word.getEnglish().equals(remove)) {
                if (System.console().readLine().equals("n")) {
                    continue;
                }else{
                    iterator.remove();
                    removed = true;
                
                    System.out.println("삭제완료");
                }
                
            }
        }
        if(!removed){
            System.out.println("삭제할 단어 없음.");    
        }

        
    }

    private void searchWord() {
        System.out.println("\t::단어 검색합니다.:::");
        System.out.print("검색할 단어를 영문으로 입력하세요. _");
        String find = System.console().readLine();
        // boolean isfind = false;
        for(JavaWord word : words){
            if(word.getEnglish().equals(find)){          //문자열 비교는 무조건 equals이고 등호(==)쓰면 안됌.
                System.out.println("검색 결과는 : " + word.getEnglish() + " = " + word.getKorean() + " Level " + word.getLevel());
                return;     //단어를 한 개 찾으면 searchWord 메소드 종료 //1)같은 단어를 1번만 저장하게 할때 필요
                // isfind=true;//2) 같은 단어가 2번이상 나왔을 때 필요
            }
            
        }
        // if(isfind==false)   //2)이 if문 조건검사는 같은 단어가 2개 이상 단어장에 있을 때 사용
        System.out.println("등록된 단어가 없습니다.");//1), 2)
    }//리스트에 없는 단어를 조회한다면 ? 같은 단어 중복 저장 방법에 따라 위와 같이 할 수 있습니다.

    private void printWordList(List<JavaWord> list){
        for(JavaWord word : list) {
            System.out.println(String.format("%-20s %-30s %-20s",
                                    word.getEnglish(),word.getKorean(),word.getLevel()));
        }
        
    }

    private void listWord() {
        System.out.println("\t::단어 목록 출력합니다.::");
        // TO DO : 리스트 words 에 저장된 요소(항목)들을 모두 출력해보세요.- 예쁘게~~
        System.out.println(String.format("%-20s %-30s %-20s",
                                            "ENGLISH","KOREAN","LEVEL"));

        printWordList(words);
    }

    private void addWord() {
        System.out.println("\t::단어 등록합니다.:::");
        System.out.print("영어 단어 입력하세요. _ ");
        String english = System.console().readLine();
        System.out.print("한글 단어 입력하세요. _ ");
        String korean = System.console().readLine();
        System.out.print("단어 레벨 입력하세요.(1.초급, 2.중급, 3.고급) _ ");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));
    }

    public static void main(String[] args) {
        //프로그램 실행하는 객체 생성하고(메소드로 기능을 분리할 때 main이 호출하는 static을 없애기 위함.)
        //          start 메소드 프로그램 실행 내용을 코딩
        JavaWordApp_V1 app = new JavaWordApp_V1();
        app.start();
    }
}
