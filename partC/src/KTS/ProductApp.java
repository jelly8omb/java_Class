package KTS;

public class ProductApp {
    public static void main(String[] args) {

        Product cart[] = new Product[10];

        cart[0] = new Bike(123000, "MTB", 25);
        cart[3] = new Bike(99000, "삼천리", 15);

        cart[1] = new Electronics(35000, "USB");
        cart[5] = new Electronics(527000, "스마트TV");
        cart[7] = new Electronics(2250000, "LG냉장고");

        Electronics tv = null;
        if (cart[5] instanceof Electronics) {
            tv = (Electronics) cart[5];
            tv.setKwh(0.9);
            System.out.println(tv.power());
        }
        
        for(Product p : cart){
            if (p != null && p.price > 100000) {
                System.out.println(p);
            }
        }

        for(Product p : cart){
            if(p != null && p instanceof Bike){
                Bike bike = (Bike) p;
                System.out.println(bike.ride());
            }
        }

        String result = cart[3].sell(20);
        System.out.println(result);

        String result1 = cart[5].sell("사운드바");
        System.out.println(result1);
    }
}
