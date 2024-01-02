package basic.day3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A20BankExam {
    public static void main(String[] args) {
        int menu;
        int money = 0;
        int balance = 0;
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        

       // 3자리마다 , 찍기
        DecimalFormat df = new DecimalFormat("#,###");
        while (run) {
                System.out.println("--------------------------------");
                System.out.println("1. 예금 | 2. 출금 | 3. 잔액 | 4. 종료");
                System.out.println("--------------------------------");
                System.out.print("메뉴선택 >>>> ");
                menu = sc.nextInt();

                
            switch (menu) {
                
                case 1:
                    System.out.print("입금금액 : ");
                    money = sc.nextInt();
                    balance += money;
                    System.out.println("예금액 : " + money);
                    System.out.println("잔액은 : " + df.format(balance) + "원 입니다.");
                    break;
                case 2:
                    System.out.print("출금금액 : ");
                    money = sc.nextInt();
                    System.out.println("출금액 : " + money);
                    if(money < balance){
                        balance -= money;
                    }else{
                        System.out.println("잔액이 출금액보다 부족합니다.");
                        break;
                    }
                    balance -= money;
                    System.out.println("잔액은 : " + df.format(balance) + "원 입니다.");
                    break;
                case 3:
                    System.out.println("현재 잔고 : " + df.format(balance) + "원");
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    run = false;
                    break;
            
                default:
                    System.out.println("1 ~ 4 까지만 입력가능");
                    break;
            }
            
        }
    }
}
