package collection.day10;

// import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class C06TodayMenuVote {
    //Map 연습
    public static void main(String[] args) {
        
        String menu = "Chicken, Spaghetti, Gopchang, Bulgogi, Pork belly";
        //투표 결과 저장을 map에 해봅시다.
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Chicken", 0);
        map.put("Spaghetti", 0);
        map.put("Gopchang", 0);
        map.put("Bulgogi", 0);
        map.put("Pork belly", 0);

        System.out.println("오늘의 메뉴 투표합니다.");
        System.out.println("메뉴 : " + menu);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("영문 메뉴 이름 입력 >>> ");
            String key = sc.nextLine();
            if(key.equals("end")){
                break;
            }
            if(map.containsKey(key)){
                int value = map.get(key);
                map.put(key, ++value);
            }else{
                System.out.println("선정된 메뉴 중에서 선택하세요.");
            }
        }
        System.out.println("투표가 종료되었습니다.");
        System.out.println(map);

        Comparator<Entry<String, Integer>> comparator = new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
                return o1.getValue()-o2.getValue();
            }
        };

        Entry<String, Integer> maxEntry = Collections.max(map.entrySet(),comparator);
        System.out.println("최다 득표 결과");
        System.out.println("\t 메뉴이름 : " + maxEntry.getKey());
        System.out.println("\t 투표수 : " + maxEntry.getValue());

        sc.close();
    }
}
