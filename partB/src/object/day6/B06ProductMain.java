package object.day6;

public class B06ProductMain {
    public static void main(String[] args) {


        // Product 객체를 4개 만들어보자.
        Product snack = new Product("새우깡", 1200, "농심", new String[3], new int[2]); 
        Product soju = new Product("Jinro", 1800, "하이트", new String[3], new int[2]); 
        Product icecream = new Product("투게더", 7000, "빙그레", new String[3], new int[2]); 
        Product fruit = new Product("바나나", 2500, "농원", new String[3], new int[2]); 

        //출력
        System.out.println(snack);
        System.out.println(soju);
        System.out.println(icecream);
        System.out.println(fruit);

        // object.day6.Product@2f92e0f4 - 2f92e0f4은 객체 참조값(식별값) -> 주소라고 부름
        // object.day6.Product@28a418fc - object.day6.Product 는 패키지이름. 클래스이름.
        // object.day6.Product@5305068a
        // object.day6.Product@1f32e575

        //Quiz snack의 etc필드 배열요소 0번에 "10개 묶음" 문자열을 저장하기
        String[] temp = snack.getEtc();
        temp[0]="1";
        temp[1]="2";
        temp[2]="3";

        String[] t = soju.getEtc();
        t[0]="1";
        t[1]="2";
        t[2]="3";
        // snack.setPrice(1000); //set 메서드 없음 -> 오류
        // snack.price = 1000;   //private -> 오류
        String[] tp = fruit.getEtc();
        tp[0]="1";
        tp[1]="2";
        tp[2]="3";

        String[] tmp = icecream.getEtc();
        tmp[0]="1";
        tmp[1]="2";
        tmp[2]="3";

        int[] a = snack.getEc();
        a[0]=123;
        a[1]=312;

        int[] b = soju.getEc();
        b[0]=123;
        b[1]=312;

        int[] c = icecream.getEc();
        c[0]=123;
        c[1]=312;

        int[] d = fruit.getEc();
        d[0]=123;
        d[1]=312;

        Product[] mycart = new Product[5];      //Product 객체 배열 - Product 객체의 참조값 저장 배열
        mycart[0]=snack;
        mycart[1]=icecream;
        mycart[2]=soju;
        mycart[3]=fruit;
        System.out.println("~~~~~ my cart ~~~~~");
        //배열이므로 반복문으로 출력할 수 있다.
        for (int i = 0; i < mycart.length; i++) {
            if (mycart[i] != null) {
                System.out.println(mycart[i].getData());
            } else {
                System.out.println("카트에 제품이 할당되지 않았습니다.");
            }
        }

        System.out.println(snack.getData());
        System.out.println(soju.getData());
        System.out.println(icecream.getData());
        System.out.println(fruit.getData());

    }
}
