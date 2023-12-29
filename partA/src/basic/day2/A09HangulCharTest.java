package basic.day2;

public class A09HangulCharTest {
    public static void main(String[] args){
        /*
         * 1. 문자 '나' 부터 '냿' 까지 while문으로 출력해보세요. -> char start = '나';
         * 2. 모두 몇 개의 문자가 있는지 갯수 구하기.           int codeNa, codeNet
         */

        //char start = '나';
        //
        //int codeNa;
        //int codeNet;
//
        //System.out.println((int)start);
        //codeNa = 45208;
        //
        //while (start < '냿') {
        //    System.out.print(++start);
        //}
        char start = '나';
        char end = '냿';
        int codeNa = start;
        int codeNet = end;

        while (start <= end) {
            System.out.print(start++);
        }
        //
        System.out.println("\nstart=?" + start);

        System.out.println("Start ~ End : " + (codeNet - codeNa + 1));
    }
    
}
