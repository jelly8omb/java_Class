package KoreaITtest.Test;

public abstract class Product {
    protected int price;
    protected String prdName;


    public abstract String sell(Object arg);

    public int getPrice() {
        return price;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }
}


