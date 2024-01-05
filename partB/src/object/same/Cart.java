package object.same;

public class Cart {
    private String userid;
    private String[] productNames;
    private int[] prices;
    private int total_Money;

    public int[] getPrices() {
        return prices;
    }

    public String[] getProductNames() {
        return productNames;
    }

    public int getTotal_Money() {
        return total_Money;
    }

    public String getUserid() {
        return userid;
    }

    public void setPrices(int[] prices) {
        this.prices = prices;
    }

    public void setProductNames(String[] productNames) {
        this.productNames = productNames;
    }

    public void setTotal_Money(int total_Money) {
        this.total_Money = total_Money;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    public void total_Money(int[] select){
        int sum = 0;
        for(int i=0;i<select.length;i++){
            int temp = select[i];
            sum += prices[temp];
        }
        this.total_Money=sum;
    }
    
}
