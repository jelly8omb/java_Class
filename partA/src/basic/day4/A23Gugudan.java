package basic.day4;

public class A23Gugudan {
    public static void main(String[] args) {
        /*
         * 구구단은 반복의 반복
         * 2에 곱을 1 ~ 9
         * 3에 곱을 1 ~ 9
         * 4에 곱을 1 ~ 9
         * .....
         * 9에 곱을 1 ~ 9
         */

        for(int i = 2; i <= 9; i++){
            System.out.println(i + "단");
            for(int j = 1; j <= 9; j++){
                System.out.println(String.format("%3d x %3d = %3d", i, j, i * j));
            }
        }
    }
}
