package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class CartMain {
    public static void main(String[] args) {
        
        Cart ca = new Cart(); // Stirng, String[], int[] 필드는 null

        String[] products = {"사과사과", "바나나", "메론메론", "딸기딸기", "자두자두", "수박수박"};
        int[] prices = {1000, 1500, 1200, 1300, 900, 500};
        

        ca.setUserid("gilhyun");
        ca.setProductNames(products);
        ca.setPrices(prices);

        Scanner sc = new Scanner(System.in);

        System.out.println(ca.getUserid() + "님의 장바구니입니다.");
        System.out.println(String.format("%s\t %20s\t %s", "번호","상품명","가격"));
        
        for(int i=0;i<ca.getProductNames().length;i++){
            System.out.println(String.format("%d\t %20s\t %d", i, products[i], prices[i]));
        }

        System.out.println("구매할 번호 선택 종료는 -1");
        int sel=0;
        int[] select = new int[10];  // 상품 선택 개수
        int k=0;
        while (sel != -1 && k<select.length) {
            System.out.print("상품번호 입력 >>> ");
            sel = sc.nextInt();
            // sel의 선택 범위는 productsNames 범위값만
            if(sel<0 || sel>select.length){
                System.out.println("없는 상품입니다. 상품을 더 담아주세요");
                continue;
            }
            select[k++]=sel;    // 대입 후에 ++
        }

        if(k==select.length)
            System.out.println("감사");

        ca.total_Money(select);
        System.out.println("선택하신 상품은 " + Arrays.toString(select));
        System.out.println(ca.getUserid() + "님이 선택하신 상품 합계 : " + ca.getTotal_Money());

        // 필요에 따라서는 기존의 setter 메서드는 사용하지않고
            // 추가적인 비즈니스 로직을 구현하는 메서드를 만든다. => total_Money() 메서드


        // ca.setTotal_Money(200000); // setter 메서드가 여기서는 필요없음.
                                      // total_Money 메서드가 대신 값을 계산해서 저장함.
        sc.close();
    }
}
