package basic.day4;

public class A25mySampleMethod {
            // A22번 1 ~ 5 을 각각 메서드로 정의해보기  - 메서드안에서 출력문 만들지 않기
            // 1. sumToN    2. MultiplyToN  3. sumMToN  4. multiplyMToN 5. multiplyNof
            // 6. 구구단 출력하는 메서드 리턴은 void. printGuguDan
    public static void main(String[] args) {
        int n;
        int m;
        int sum;
        int result;
        int dan = 1;

        int reSult = addMToN(2,5);
        boolean isOk = checkJumsu(67);
        
        System.out.println("sumToN : " + sumToN(3));
        System.out.println("MultiplyToN : " + MultiplyToN(4));
        System.out.println("sumMToN : " + sumMToN(3,12));
        System.out.println("multiplyMToN : " + multiplyMToN(2,5));
        System.out.println("multiplyNof : " + multiplyNof(9));
        printGuguDan(dan);
    }

    private static boolean checkJumsu(int i) {
        return i>=0 && i<=100;
    }

    private static int addMToN(int i, int j) {
        int sum = 0;
        for(int k = i; k <= j; k++){
            sum += k;
        }
        return 0;
    }

    public static int sumToN(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public static int MultiplyToN(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }

    public static int sumMToN(int m, int n){
        int sum = 0;
        for(int i = m; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public static int multiplyMToN(int m, int n){
        int result = 1;
        for(int i = m; i <= n; i++){
            result *= n;
        }
        return result;
    }

    public static int multiplyNof(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= 2;
        }
        return result;
    }

    public static void printGuguDan(int dan){
        for(int i = 2; i <= 9; i++){
            for(int g = 1; g <= 9; g++){
                System.out.println(i + " * " + g + " = " + (i * g));
            }
            
        }
        
    }
}
