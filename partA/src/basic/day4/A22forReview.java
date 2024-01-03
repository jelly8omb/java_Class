package basic.day4;

public class A22forReview {
    public static void main(String[] args) {
        
        int n;
        int m;
        int sum = 0;
        int result = 1; // 곱셈 결과를 저장할 변수

        // 1) 1부터 정수 n까지 더하기
        n = 100;
        
        for(int i = 1; i<=n; i++){
            sum += i;
        }
        System.out.println(String.format("문제1) 1부터 %d까지의 합계 : %d ", n, sum));
        System.out.println("문제1) 1부터 " + n + " 까지의 합계 " + sum);
        // 2) 1부터 정수 n까지 곱하기
        n = 15;     // int 타입은 정수 -2147483648 ~ +2147483647 그래서 곱셈결과 큰 값이 나올것을 예상하면
        // n = 20;으로 int result에 결과를 저장하면 - 음수값이 나옵니다.
        long longResult = 1;
        for(int i = 1; i <= n; i++){
            longResult *= i;
        }
        System.out.println(String.format("문제2) 1부터 %d까지의 곱 : %,d ", n, longResult));
        // 3) 시작값 정수 m부터 n까지 더하기
        m = 5; n = 8;
        sum = 0;
        for(int i = m; i <= n; i++){
            sum += i;
        }
        System.out.println(String.format("문제3) %d부터 %d까지의 합 : %d ", m, n, sum));

        // 4) 시작값 정수 m부터 n까지 곱하기
        m = 5; n = 8;
        longResult = 1;
        for(int i = m; i <= n; i++){
            longResult *= i;
        }
        System.out.println(String.format("문제4) %d부터 %d까지의 곱 : %,d ", m, n, longResult));

        // 5) 2의 n승 구하기 : 2를 n번 곱하기
        n = 10;
        longResult = 1;
        for(int i = 1; i<=n; i++){
            longResult *= 2;
        }
        System.out.println(String.format("문제5) 2의 %d승 구하기 : %,d ", n, longResult));

        // 6) 구구단 출력
        n = 9;
        result = 1;
        for(int i = 1; i <= n; i++){
            
        }
    }
}
