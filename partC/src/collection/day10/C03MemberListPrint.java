package collection.day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C03MemberListPrint {
    public static void main(String[] args) {
        
        List<Member> list = new ArrayList<>();
        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("dahy", 25));
        list.add(new Member("sana", 21));
        list.add(new Member("momo", 26));


        //toString 재정의된 출력이 아닌 직접 이름과 나이를 모두 출력
        System.out.println("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        System.out.println(String.format("%15s\t %15s", "name","age"));
        for(int i=0;i<list.size();i++){
            Member temp = list.get(i);
            System.out.println(String.format("%15s\t %15d", temp.getName(),temp.getAge()));
            System.out.println(String.format("%15s\t %15d", list.get(i).getName(),list.get(i).getAge()));
        }

        //컬렉션에서는 반복자(Iterator)로 데이터에 접근합니다. - 인덱스가 없는 자료구조에서 주로 사용.
        //반복자를 이용한 출력
        System.out.println("~~~~~~~~~~반복자를 이용한 출력~~~~~~~~~");
        Iterator<Member> iterator = list.iterator();            //list로 선언된 자료구조에 접근할 반복자 선언
        int count = 0;
        while (iterator.hasNext()) {        //반복자가 접근할 다음 데이터가 있으면 true.
            Member temp = iterator.next();  //반복자가 다음 데이터를 가져옵니다.
            System.out.println("\t count" + count++ + ", 요소 = "+ temp);
        }
        //iterator 로 동작하는 for
        System.out.println();
        System.out.println("~~~~~~~~~~iterator 로 for 출력~~~~~~~~~~");
        count = 0;
        for (Member temp : list) {
            System.out.println("\t count = " + count++ + ", 요소 = " + temp);
            
        }
    }
}
