package io.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D09StringSplit {
    //전역변수 : 모든 메소드에서 사용할수 있는 변수
    private static String filePath = "Score.txt";

    public static void main(String[] args) {
        List<Score> list = makeList();
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println("i = " + i + ", score object = " + list.get(i));
        }
        for(Score temp : list){
            System.out.println(temp);
        }
    }

    public static Score makeScore(String line){
        String[] temp = line.split(",");
        Score score = new Score(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));

        return score;
    }

    public static List<Score> makeList(){
        //1. Score.txt 에서 모든 데이터를 읽어오고 
        //2. Score 객체로 변환하여 
        //3. 리스트에 담고 
        //4. 리턴하기.
        List<Score> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String sc;
            while ((sc=br.readLine())!= null) {
                 list.add(makeScore(sc));
            }
        } catch (IOException e) {
            System.out.println("파일 입력 오류 : " + e.getMessage());
        }
        return list;
    }



    //BufferedReader 클래스는 파일에서 1줄씩 읽어올수 있습니다.
    //               1줄 읽고  -> Score 객체 만들기 (변수명 모두 str 로 참조하고 출력하기)
    public static void Split_Test2(){
        int count = 0;
        
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // String[] temp = line.split(",");
                // Score str = new Score(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
                Score str = makeScore(line);
                System.out.println(String.format("count=%d, score object = %s", count, str));
                count++;
            }
        } catch (IOException e) {
            System.out.println("파일 입력 오류 : " + e.getMessage());
        }
        System.out.println();
        System.out.println("scroe 객체 : " + count + " 개 생성완료!!");
    }

    public static void Split_Test1() {
        String str = "김사과,67,77,88";

        //Split method = 지정된 구분자(구분기호)를 이용해서 문자열을 분리하고
        //               배열에 저장해서 리턴합니다.

        String[] temp = str.split(",");
        System.out.println("1. split 실행한 결과 문자열 배열은 ? ");
        // System.out.println(Arrays.toString(temp));
        for(String t : temp){
            System.out.println("배열 요소 : " + t);

        
        }
        System.out.println("분리된 결과로 Score 객체를 만들면 ? ");
        //temp[0] = name, temp[1] ~ temp[3] = 점수 문자열 => 정수로 변환
        Score score = new Score(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
        System.out.println("Score 출력1 : " + score.datas());
        System.out.println("Score 출력2 : " + score); //toString
    }
}
