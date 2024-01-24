package KoreaITtest.Test;

public class Bike extends Product {
    private int speed;

    public Bike(int speed, String prdName, int price) {
        this.speed = speed;
        this.prdName = prdName;
        this.price = price;
    }


    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void ride(){
        System.out.println("당신은 이것을 시속 " + speed + "km로 탈수 있습니다.");
    }
    
    public String sell(Object arg){
        
        return String.format("[%s] 행사 - %d %% 인하", prdName, arg);
    }


    @Override
    public String toString() {
        return "Bike [speed=" + speed + "]";
    }


    

    
}

class Electrics extends Product {
    private double kwh;
    private int price;
    private String prdName;

    public Electrics(double kwh, int price, String prdName) {
        this.kwh = kwh;
        this.price = price;
        this.prdName = prdName;
    }

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public double power(){
        return kwh * 24.0;
    }

    public String sell(Object arg){
        return String.format("[%s] 증정 - %s", prdName, arg);
    }


    @Override
    public String toString() {
        return "Eletronics [kwh=" + kwh + ", price=" + price + ", prdName=" + prdName + "]";
    }
    
}
