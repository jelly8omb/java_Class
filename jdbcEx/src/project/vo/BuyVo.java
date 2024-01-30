package project.vo;

import java.sql.Date;

public class BuyVo {
    private int buy_idx;
    private String CUSTOMID;
    private String PCODE;
    private int QUANTITY;
    private Date buy_date;


    public BuyVo(int buy_idx, String cUSTOMID, String pCODE, int qUANTITY, Date buy_date) {
        CUSTOMID = cUSTOMID;
        PCODE = pCODE;
        QUANTITY = qUANTITY;
        this.buy_date = buy_date;
    }

    public int getBuy_idx() {
        return buy_idx;
    }

    public String getCUSTOMID() {
        return CUSTOMID;
    }


    public String getPCODE() {
        return PCODE;
    }


    public int getQUANTITY() {
        return QUANTITY;
    }


    public Date getBuy_date() {
        return buy_date;
    }


    


    @Override
    public String toString() {
        return "BuyVo [" + buy_idx + ", " + CUSTOMID + ", " + PCODE + ", " + QUANTITY
                + ", " + buy_date + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CUSTOMID == null) ? 0 : CUSTOMID.hashCode());
        result = prime * result + ((PCODE == null) ? 0 : PCODE.hashCode());
        result = prime * result + QUANTITY;
        result = prime * result + ((buy_date == null) ? 0 : buy_date.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyVo other = (BuyVo) obj;
        if (CUSTOMID == null) {
            if (other.CUSTOMID != null)
                return false;
        } else if (!CUSTOMID.equals(other.CUSTOMID))
            return false;
        if (PCODE == null) {
            if (other.PCODE != null)
                return false;
        } else if (!PCODE.equals(other.PCODE))
            return false;
        if (QUANTITY != other.QUANTITY)
            return false;
        if (buy_date == null) {
            if (other.buy_date != null)
                return false;
        } else if (!buy_date.equals(other.buy_date))
            return false;
        return true;
    }

    

    
}
