package collection.day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C02MemberList {
    public static void main(String[] args) {
        
        List<Member> list = new ArrayList<>();

        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("dahy", 25));
        list.add(new Member("sana", 21));
        list.add(new Member("momo", 26));

        //hashcode, equals 메소드 재정의하기 before & after 를 비교하세요,
        //컴파일ㄹ러는 객체의 hashcode 같으면 equals 검사합니다. 둘다 통과하면 동일객체로 결정.
        //                          ㄴ remove, indexOf 메소드에 동일 객체 검사 할 때 사용.

        System.out.println("현재 리스트 내용 : " + list + "크기 : " + list.size());
        list.remove(new Member("momo", 23));
        System.out.println("삭제 후 리스트 내용 : " + list);

        System.out.println("특정 멤버 조회 : " + list.indexOf(new Member("momo", 26))); //-1

        //new Member("momo", 23) 에서 인스턴스 필드값이 같다고 동일한 객체가 아니다.
        //remove, indexOf 등의 메소드는 동일한 객체를 찾아서 삭제하거나 조회합니다.
        //참고 : String은 문자열 리터럴이 같으면 주소가 같습니다. 
        //일반적으로 만들어진 클래스는 hashcode 로 메모리의 참조 위치가 결정됩니다.
        //                           인스턴스 필드의 내용이 같으면 hashcode 를 동일하게 만들도록 재정의합니다.

        list.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2){
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(list);

        //List 의 static 메소드
        //      ㄴ 테스트용 리스트 만들 때 많이 사용합니다. 불변객체 입니다.
        List<String> names = List.of("momo","dahy","nana","sana");
        System.out.println("names : " + names);

        // names.add("xxyyzz");

    }
}
