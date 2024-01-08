package object.Homework;

import java.util.Scanner;

public class ADDQUIZMAIN {
    public static void main(String[] args) {
        int jumsuCounts = 0;
        int dutSem = 10;
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈 " + dutSem + " 문제 퀴즈를 시작합니다.");
        System.out.println(String.format("%10s\t %-10s\t %-10s\t %-10s", "문제","제출한답","정답","채점"));
        for(int i=1; i <= dutSem; i++){
            ADDQUIZ AQ = new ADDQUIZ();
            AQ.setData1();
            AQ.setData2();
            AQ.setUserAnswer(dutSem);

            System.out.println(i + "번. " + AQ.getData1() + " + " + AQ.getData2() + " = ");
            System.out.print("답을 입력하세요 >>> ");
            int userAnswer = sc.nextInt();
            

            boolean isRight = AQ.CorrectAnswer(userAnswer);
            if(isRight){
                jumsuCounts++;
            }
            
            System.out.println(String.format("%10s\t %-10s\t %-10s\t %-10s", AQ.getData1() + " + " + AQ.getData2(), userAnswer, AQ.CAlCULATE(), isRight ? "O" : "X"));
        }
        System.out.println("::::: 채점 하고 있습니다. :::::");
        System.out.println("::::: 맞은 개수" + jumsuCounts + "개 입니다.");

        sc.close();
    }
}
/*
 * 덧셈 10문제 퀴즈를 시작합니다.
 * 1번. data1 + data2 = userAnswer
 * 답을 입력하세요 >>> 
 * 2번 data1 + data2 = userAnswer
 * 답을 입력하세요 >>> 
 * 3번 data1 + data2 = userAnswer
 * ::::: 채점 하고 있습니다. :::::
 *              문제        제출한답        정답        채점
 * 1번.     data1+data2     userAnswer      ?           O
 * 2번.     data1+data2     userAnswer      ?           O
 * 3번.     data1+data2     userAnswer      ?           O
 * ::::: 맞은 개수 ?? 개 입니다. :::::
 */