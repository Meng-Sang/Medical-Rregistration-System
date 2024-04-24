import com.sangmeng.dao.impl.*;
import com.sangmeng.entity.*;
import com.sangmeng.service.DoctorService;
import com.sangmeng.service.impl.*;
import com.sangmeng.tag.OutAdministrativeTag;
import com.sangmeng.util.DataSourceUtil;
import com.sangmeng.util.PageUtil;
import com.sangmeng.util.TagUtil;

import javax.print.Doc;
import javax.swing.text.html.HTML;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        System.out.println(DataSourceUtil.getDataSourceByDBPCAndFile("dbcpconfig.properties").getConnection());
//        System.out.println(DataSourceUtil.getDataSourceByDBPC(new DataSourceEntity()).getConnection());
//        System.out.println(DataSourceUtil.getDataSourceByC3P0AndName("sangmeng").getConnection());
//        System.out.println(DataSourceUtil.getDataSourceByC3P0(new DataSourceEntity()).getConnection());
//        Login login = new Login("username","password","custum","normal","email","tel");
//        Login login = new Login(username,password,"custum","normal",email,tel);
//        List<Administrative> administratives = new AdministrativeServiceImpl().queryAll();
//        System.out.println(administratives);
//        if(administratives==null&&administratives.isEmpty())
//        {
//            System.out.println("null");
//        }
//        else
//        {
//            for (Administrative i:
//                 administratives) {
//                System.out.println(i);
//            }
//        }
//        new Main().getResult();
//        List<Doctor> doctors = new DoctorServiceImpl().queryAllDoctorsByAd_no("1");
//        System.out.println(doctors);
////        System.out.println(new TagUtil().getThumbnail(doctors));
//        IdInformation idInformation = new IdInformation("sangmeng", "桑蒙", "341281199712062816", "辽宁省", "沈阳市", "谯城区淝河镇", "2020-02-26", "1585667245391.jpg", "1585667245391.jpg");
//        System.out.println(new IdInformationServiceImpl().addIdInformation(idInformation));
//        System.out.println(new IdInformationServiceImpl().queryIdInformationByUsername("sangmeng")==null);
//        System.out.println(new LoginServiceImpl().checkLogin("sangmeng","123"));
//        System.out.println(new LoginDaoImpl().queryByUserName("sangmeng123"));
//        System.out.println((int )(new OrderDaoImpl().queryOrderNumForSelf("sangmeng")));
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        System.out.println(orderService.queryTotalOrderForSelf("sangmeng"));
//        System.out.println(orderService.queryUnpaidOrderForSelf("sangmeng"));
//        System.out.println(orderService.queryPaidOrderForSelf("sangmeng"));
        PageUtil pageUtil = PageUtil.getInstance();
        int totalCount = new OrderServiceImpl().queryTotalOrderNum();
        pageUtil.init(1,100,100);
//        String username = "sangmeng";
//        List<Order> orders = null;
//        InvestServiceImpl investService = new InvestServiceImpl();
//        int total = (new OrderServiceImpl().queryTotalOrderNumForSelf("sangmeng"));
//        List<Invest> invests = investService.queryTotalInvest(pageUtil);
//        System.out.println(invests);
//        System.out.println(new TagUtil().getInvest(invests,pageUtil,false));
//        System.out.println(new TagUtil().getInvest(invests,pageUtil,true));
//        System.out.println(investService.queryTotalInvestForSelf(username,pageUtil));
//        System.out.println(investService.queryTotalInvestNum());
//        System.out.println(investService.queryTotalInvestNumForSelf(username));
//        String sql = "select * from invests where state='paid'";
//        System.out.println(new InvestDaoImpl().queryInvestNum(sql));
//        System.out.println(new TagUtil().getOrder(orders,pageUtil));
//        List<Order> orders = new OrderServiceImpl().queryTotalOrder();
//        System.out.println(orders);
//        System.out.println(new TagUtil().getOrder(orders,pageUtil));
//        List<Doctor> doctors = new DoctorServiceImpl().queryTotalDoctors(pageUtil);
//        List<Doctor> audits = new DoctorServiceImpl().queryAuditDoctors(pageUtil);
//        List<Doctor> auditeds = new DoctorServiceImpl().queryAuditedDoctors(pageUtil);
//        System.out.println(doctors);
//        System.out.println(audits);
//        System.out.println(auditeds);
        List<Doctor> doctors = new DoctorServiceImpl().queryTotalDoctors(pageUtil);
        System.out.println(new TagUtil().getDoctors(doctors,pageUtil));
    }

    public void getResult()
    {
        List<Administrative> administratives = new AdministrativeServiceImpl().queryAll();
        String str = "";
        for(int i=0;i<administratives.size();i+=4)
        {
            String t_str = "";
            for(int j=i;j<i+4;j++)
            {
                String s = j>=administratives.size()?getTd(""):getTd(administratives.get(j).getAd_name());
                t_str+=s;
            }
            str+=getTr(t_str);
            System.out.println(getTr(t_str));
        }
        System.out.println(str);
    }
    private String getTd(String str){
        return "<td>"+str+"</td>";
    }
    private  String getTr(String str)
    {
        return "<tr>"+str+"</tr>";
    }
}
