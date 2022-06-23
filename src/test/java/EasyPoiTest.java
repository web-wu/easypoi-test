import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.tabwu.qiniuyun.utils.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @ProjectName: qiNiuYun
 * @Author: tabwu
 * @Date: 2021/12/18 17:19
 * @Description:
 */
public class EasyPoiTest {

    /**
    在controller中以附件的形式导出excel报表
    */
    @Test
    public void exportExcel() throws Exception {
        List<User> userList = getUser();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息表", "用户表"), User.class, userList);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode( "material物料报表.xlsx", "UTF-8"));
        workbook.write(response.getOutputStream());

        Logger logger = Logger.getLogger("EasyPoiTest");

        logger.info("导出用户信息表");

    }


    @Test
    public void testPoi() throws Exception {
        List<User> userList = getUser();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息表", "用户表"), User.class, userList);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\76026\\Desktop\\aaa.xlsx");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();

        Logger logger = Logger.getLogger("EasyPoiTest");

        logger.info("导出用户信息表");

    }

    private List<User> getUser() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User(i, new Random().nextInt(26),"tabwu-" + i, new Random().nextInt(10000) + "",new Date(),System.currentTimeMillis() + "");
            users.add(user);
        }

        return users;
    }


    @Test
    public void importExcelTest() throws Exception {
        ImportParams importParam = new ImportParams();
        importParam.setTitleRows(1);
        importParam.setHeadRows(1);
        List<User> users = ExcelImportUtil.importExcel(new FileInputStream("C:\\Users\\76026\\Desktop\\aaa.xlsx"), User.class, importParam);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
