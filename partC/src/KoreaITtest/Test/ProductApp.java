package KoreaITtest.Test;

public class ProductApp {
    public static void main(String[] args) {
        Product cart[] = new Product[10];
        cart[0] = new Bike(25, "MTB", 123000);
        cart[1] = new Bike(25, "삼천리", 123000);
        cart[2] = new Bike(25, "", 123000);
        cart[3] = new Bike(25, "", 123000);
        cart[4] = new Bike(25, "", 123000);
        cart[5] = new Bike(25, "", 123000);
        cart[6] = new Bike(25, "", 123000);
        cart[7] = new Bike(25, "", 123000);
        cart[8] = new Bike(25, "", 123000);
        cart[9] = new Bike(25, "", 123000);
    }
}
