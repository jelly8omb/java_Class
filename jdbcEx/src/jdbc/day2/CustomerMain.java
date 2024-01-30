package jdbc.day2;

import java.util.ArrayList;
import java.util.List;

import project.dao.TblBuyDao;
import project.dao.TblCustomerDao;
import project.dao.TblProductDao;
import project.vo.CustomerBuyVo;
import project.vo.CustomerVo;
import project.vo.ProductVo;

public class CustomerMain {
    
    public static void main(String[] args) {
        // System.out.println("[고객관리시스템]고객을 조회합니다.");
        // System.out.print("고객 아이디 입력 _ ");
        // String customerId = System.console().readLine();
        // System.out.println("\n------------------조회 결과---------------------");
        // TblCustomerDao dao = new TblCustomerDao();
        // CustomerVo vo = dao.getCustomer(customerId);
        // if(vo==null){
        //     System.out.println("조회한 고객이 존재하지 않습니다.");
        // }else{
        //     System.out.println(vo);
        // }
        // -----------------------------------------------------------------------------
        // System.out.print("CATEGORY _ ");
        // String category = System.console().readLine();
        // TblProductDao dao = new TblProductDao();
        // ProductVo vo = dao.getProductVo(category);
        // System.out.println(vo);
        // -----------------------------------------------------------------------------
        // System.out.print("PNAME _ ");
        // String pname = System.console().readLine();
        // List<ProductVo> list = dao.selectByPname(pname);
        // System.out.println(list);
        // -----------------------------------------------------------------------------
        System.out.print("customId _ ");
        String id = System.console().readLine();
        TblBuyDao dao1 = new TblBuyDao();
        List<CustomerBuyVo> list = dao1.selectCustomerBuyList(id);
        System.out.println(list);

    }
}
