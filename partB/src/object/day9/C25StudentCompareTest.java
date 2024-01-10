package object.day9;

import java.util.Arrays;
import java.util.Comparator;

//Arrays.sort 메소드에 두번째 인자로 Comparator 인터페이스 타입 객체를 전달하면
//            비교 기준과 정렬 방법을 실행시점에서 결정됩니다.
public class C25StudentCompareTest {
    public static void main(String[] args) {
        
        Student[] students = new Student[4];
        students[0] = new Student("장모모", 23);
        students[1] = new Student("박나연", 22);
        students[2] = new Student("김다현", 24);
        students[3] = new Student("사나", 21);

        System.out.println("초기 students 배열 : " + Arrays.toString(students));
        // Arrays.sort(students);  //오류 : Student 객체를 Comparable 이 아닙니다.
        
        Comparator<Student> ageAscending = new Comparator<Student>() {
            // ascending : 오름차순
            @Override
            public int compare(Student o1, Student o2) {//o1, o2 객체를 비교하는 기준
                return o1.getAge() - o2.getAge();
            }
        }; 
        //o1(왼쪽값) , o2(오른쪽값) 이며 오름/내림 상관없이 교환을 안해도 되는
        //          경우를 음수값으로 리턴합니다. (양수 = 교환)
        // sort 메소드 정렬 알고리즘은 비교결과 음수 리턴하면 교환하지 않고
        //                                   양수 리턴하면 교환합니다.
        // 내림차순 o1 > o2 이 되어야한다. | o2 - o1 < 0 이면 교환
        
        Arrays.sort(students,ageAscending);
        System.out.println("나이 오름차순 정렬 후 students 배열 : " + Arrays.toString(students));
        
        
        //ageDecending
        Arrays.sort(students, (o1,o2) -> o2.getAge() - o1.getAge());
        System.out.println("나이 내림차순 정렬 후 students 배열 : " + Arrays.toString(students));


        //nameAscending
        Arrays.sort(students, (o1,o2) -> o2.getName().compareTo(o1.getName()));
        System.out.println("이름 오름차순 정렬 후 students 배열 : " + Arrays.toString(students));

        //nameDecending
        Arrays.sort(students, (o1,o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("이름 내림차순 정렬 후 students 배열 : " + Arrays.toString(students));

        //C21 번에 int배열 오름차순은 그냥하면 됀다. 내림차순 완성하러 ㄱ
    }
}
