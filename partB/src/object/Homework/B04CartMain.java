package object.Homework;

import java.util.Scanner;

public class B04CartMain {
    

    public static void main(String[] args) {
        Cart ca = new Cart();

        String[] products = {"김사과","반하나","이메론","베애리","두리안"};
        int[] price = {1000,2500,4000,1200,9000};

        ca.setUserid("김머머");
        ca.setProductNames(products);
        ca.setPrices(price);

        Scanner sc = new Scanner(System.in);

        System.out.println(ca.getUserid() + " 님의 카트");
        System.out.println(String.format("%s\t %s\t %s", "Num.","Name.","Price."));
        
        for(int i=0;i<ca.getProductNames().length;i++){
            System.out.println(String.format("%d\t %d\t %d", i, products[i], price[i]));
        }
        
        System.out.println("~~~~~ ----- ~~~~~");
        int sct = 0;
        int[] select = new int[5];
        int c = 0;

        while (sct!=-1 && c<select.length) {
            
        }
        sc.close();
    }
}
