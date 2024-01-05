package object.day6;

import java.util.Arrays;

public class Product {
    
    private String productName;
    private int price;
    private String company;
    private String[] etc;
    private int[] ec;

    //커스텀 생성자 만들기
    public Product(String productName, int price, String company, String[] etc, int[] ec){
        this.productName=productName;
        this.price=price;
        this.company=company;
        this.etc=etc;
        this.ec=ec;
    }

    //getter
    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }

    public String[] getEtc() {
        return etc;
    }

    public int[] getEc() {
        return ec;
    }
    //모든 필드값을 이용해서 문자열을 만들어 리턴합니다.
    public String getData(){
        return String.format("%s\t %d\t %s\t %s\t %d", productName, price, company, Arrays.toString(etc), Arrays.toString(ec));
                            //자리크기 지정한 것에 대해 정렬은 %s 문자열은 가운데 -를 붙이면 왼쪽
                            //                              %d 정수는 오른쪽
    }
}
