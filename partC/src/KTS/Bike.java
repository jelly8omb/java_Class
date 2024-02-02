package KTS;

public class Bike extends Product{
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Bike ["+ price + ", " + prdName +", " + speed + "]";
    }

    public String ride(){
        return "당신은 이것을 시속 "+ speed + "km 로 탈수 있습니다.";
    }

    public Bike(int price, String prdName, int speed) {
        this.speed = speed;
        this.price = price;
        this.prdName = prdName;
    }
    
    public String sell(Object obj){
        return String.format("[%s] 행사 - %d %% 인하", prdName, obj);
    }

}

class Electronics extends Product{
    private double kwh;

    public double getKwh() {
        return kwh;
    }

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public double power(){
        return kwh * 24.0;
    }

    public Electronics(int price, String prdName) {
        this.prdName = prdName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Electronics ["+ price +", "+ prdName +"]";
    }

    
    public String sell(Object obj){
        return String.format("[%s] 증정 - %s", prdName, obj);
    }
    
   
    
    
}
