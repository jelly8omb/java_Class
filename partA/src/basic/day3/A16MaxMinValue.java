package basic.day3;

public class A16MaxMinValue {
    public static void main(String[] args) {
        int n1 = 23;
        int n2 = 34;
        int n3 = 32;
        int max;
        int min;
        // 1) 조건식이 참/거짓 각각 실행명령어가 다름.
        if(n1 < n2){
            min = n1;
            max = n2;
        }else {
            min = n2;
            max = n1;
        }
        // 2) 조건식이 참일 때만 실행하는 명령어
        // 앞으로 참 또는 거짓일 때 실행하는 명령문이 1개이면 { } 생략하고 할 수 있다.
        if(min > n3) min = n3;
        if(max < n3) max = n3;
        System.out.println("최대값, 최소값 : "+ max + ", " + min);

    }
}
