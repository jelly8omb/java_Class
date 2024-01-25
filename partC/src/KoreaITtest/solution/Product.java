package KoreaITtest.solution;

public abstract class Product {
    //1.
    protected String prdName;
    protected int price;

    //2.
    public abstract String sell(Object arg);

    //10.
    @Override
    public String toString() {
        return "prdName=" + prdName + ", price=" + price;
    }

    
    
}
