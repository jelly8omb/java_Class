package object.same;

import java.util.Arrays;
import java.util.Scanner;

public class B04CartMain {
    

    public static void main(String[] args) {
        Cart cr = new Cart();
        
        String[] products = {"과자","음료수","담배","라이터","소주"};
        int[] prices = {1000, 1200, 5000, 800, 1400};

        cr.setUserid("jelly");
        cr.setProductNames(products);
        cr.setPrices(prices);

        Scanner sc = new Scanner(System.in);

        System.out.println(cr.getUserid() + " 님의 카트");
        System.out.println(String.format("%s\t %5s\t %s", "번호","상품이름","가격"));

        for(int i=0; i<products.length;i++){
            System.out.println(String.format("%d\t %5d\t %d", i, products[i], prices[i]));
        }

        System.out.println("구매 선택 종료 -1");
        int sel=0;
        int k=0;
        int[] select = new int[6];
        while (sel!=-1 && k<select.length) {
            System.out.println("상품 번호 입력 ::: ");
            
        }

    }
}
