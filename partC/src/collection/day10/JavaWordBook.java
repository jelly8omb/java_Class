package collection.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//JavaWord 여러개를 저장할 클래스 입니다.
//          조회 기능에 유리한 Map을 사용하겠습니다.
//굳이 List 대신 Map을 사용한 이유 : 조회를 편하게 하려고
//조회 이외에는 특히 출력에는 map.values() 로 value값만 사용
public class JavaWordBook {
    private Map<String, JavaWord> wordBook;
    //key : 영어 단어
    //value : JavaWord(영어, 한글, 레벨)
    public JavaWordBook() {
        this.wordBook = new TreeMap<>();
        //key 값인 영어 단어 순으로 정렬하여 접근.
    }

    public Map<String, JavaWord> getWordBook() {
        return this.wordBook;
    }

    //단어 추가
    public void addWord(JavaWord word){
        this.wordBook.put(word.getEnglish(), word);
    }
    
    //단어 조회
    public JavaWord searchWord(String english){
        return this.wordBook.get(english);
    }

    //단어 삭제
    public void removeWord(String english){
        this.wordBook.remove(english);
    }

    //전체 단어 출력하기
    public void wordAllPrint(){
        //TreeMap은 정렬되어 있으므로 Map의 values 를 리스트로 변환하여 출력메소드로 전달하기.
        List<JavaWord> all = new ArrayList<>(this.wordBook.values());
        wordListPrint(all);
    }

    //인자로 전달된 list 출력하기
    public void wordListPrint(List<JavaWord> list){
            System.out.println("~".repeat(20) + "~ 단어장 ~" + "~".repeat(20));
            System.out.println(String.format("%-15s %-15s\t %s", "<english>","<korean>","<level>"));

            for(JavaWord word : list){
                System.out.println(String.format("%-15s %-15s\t %d", word.getEnglish(),word.getKorean(),word.getLevel()));
            }
        }

        public List<JavaWord> searcJavaWordByLevel(int level){
            List<JavaWord> results = new ArrayList<>();
            //TO DO : 인자로 전달된 level 만 results 리스트에 저장하기
            for(JavaWord word : this.wordBook.values()){
                if(word.getLevel()==level){
                    results.add(word);
                }
            }
            return results;
        }

        

}
