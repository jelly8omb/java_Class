package object.day9;

import java.util.Arrays;

//순차 정렬 알고리즘
public class C22MySortTest {
    public static void main(String[] args) {
        int[] numbers = {67,34,65,89,54};
        System.out.println("초기 numbers : " + Arrays.toString(numbers));
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                int temp;
                if(numbers[i]>numbers[j]){
                    temp = numbers[j];
                    numbers[j]=numbers[i];
                    numbers[i]=temp;
                }
                System.out.println(String.format("중간 상태 : i=%d, j=%d 배열 : %s", i, j, Arrays.toString(numbers)));
            }
        }
        System.out.println("오름차순 정렬 후 numbers : " + Arrays.toString(numbers));

        System.out.println("\n 내림차순 정렬 전 numbers : " + Arrays.toString(numbers));
            for(int i=0;i<numbers.length-1;i++){
                for(int j=i+1;j<numbers.length;j++){
                    int temp;
                    if(numbers[i]<numbers[j]){
                        temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                    System.out.println(String.format("중간 상태 : i=%d, j=%d 배열 : %s", i, j, Arrays.toString(numbers)));
                }
            }
            
        }
        System.out.println("내림차순 정렬 후 numbers : " + Arrays.toString(numbers));
    }
}
