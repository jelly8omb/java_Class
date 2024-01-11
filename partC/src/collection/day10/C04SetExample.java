package collection.day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("햄버거");
        set.add("피자");
        set.add("콜라");
        set.add("감자튀김");
        set.add("햄버거");
        set.add("케챱");
        System.out.println("~~~~~ HashSet ~~~~~");
        System.out.println("set : " + set);
        System.out.println("set size : " + set.size());

        //set 인덱스 없습니다.
        //           for(int i=0;i<set.size();i++) 와 같은 방식은 불가.

        Set<String> set2 = new LinkedHashSet<>();
        //본래의 set은 순서가 없으므로 무작위 접근
        //Linked는 다음 입력데이터의 참조값을 저장하여 입력 순서대로 접근하도록 합니다.
        set2.add("햄버거");
        set2.add("피자");
        set2.add("콜라");
        set2.add("감자튀김");
        set2.add("햄버거");
        set2.add("케챱");
        System.out.println("~~~~~ LinkedHashSet ~~~~~");
        System.out.println("set : " + set2);
        System.out.println("set size : " + set2.size());

        Set<String> set3 = new TreeSet<>();
        //이진트리 알고리즘을 이용하여 데이터를 정렬된 방식으로 접근합니다.
        set3.add("햄버거");
        set3.add("피자");
        set3.add("콜라");
        set3.add("감자튀김");
        set3.add("햄버거");
        set3.add("케챱");
        System.out.println("~~~~~ TreeSet ~~~~~");
        System.out.println("set : " + set3);
        System.out.println("set size : " + set3.size());
    }
}
/*
 * Set : 수학시간에 배운 집합
 * 순서(인덱스)가 없습니다.
 * 중복값이 없습니다.
 * Map 의 구성요소 : Key, Value 중에서 Key 는 Set 의 특성을 갖고 있습니다.
 */