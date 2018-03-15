package BaseService;

import com.jx.bean.User;
import com.jx.common.EncryptUtils;
import com.jx.service.BaseService;
import com.jx.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/2/2.
 */
public class UserListAllTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getById() {
       User user = (User) userService.getById(1);
        System.out.println(user.getEmail());
    }
    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setEmail("302936105@qq.com");
        user.setPwd(EncryptUtils.md5("123456"));
        user.setQq("123456789");
        userService.update(user);
        System.out.println(user.getPwd());
    }

    @Test
    public void listAll() {
        List<Object> objects =  userService.listAll();
        for (Object obj :objects) {
            System.out.println(((User)obj).getId());
            System.out.println(((User)obj).getPhone());
        }
    }


    @Test
    public void userWriteTest() throws IOException {
        List<Object> objects = userService.listAll();
        writeExcel("src/main/resources/xxx.xlsx",objects);
    }

    public static void writeExcel(String path,List<Object> objects) throws IOException {
        if (path.endsWith(".xls")) {
            writeExcel(path,".xls",objects);
        } else if (path.endsWith(".xlsx")) {
            writeExcel(path,".xlsx",objects);
        }

    }

    public static void writeExcel(String path, String xls, List<Object> userList) throws IOException {
        Workbook workbook = null;
        if (".xls".equalsIgnoreCase(xls)) {
            workbook = new HSSFWorkbook();
        } else if (".xlsx".equalsIgnoreCase(xls)) {
            workbook = new XSSFWorkbook();
        }
        if (workbook != null) {
            Sheet sheet = workbook.createSheet("Sheet1");
            for (int row = 0, totalRow = userList.size(); row < totalRow; row++) {
                Object object = userList.get(row);//获取行数据
                Row rowDate = sheet.createRow(row);
                rowDate.createCell(0).setCellValue(((User)object).getId());
                rowDate.createCell(1).setCellValue(((User)object).getEmail());
                rowDate.createCell(2).setCellValue(((User)object).getPwd());
                rowDate.createCell(3).setCellValue(((User)object).getQq());
                rowDate.createCell(4).setCellValue(((User)object).getName());
                rowDate.createCell(5).setCellValue(((User)object).getPhone());
                rowDate.createCell(6).setCellValue(((User)object).getTwitter());
                rowDate.createCell(7).setCellValue(((User)object).getIntro());
            }
            workbook.write(new FileOutputStream(path));
            workbook.close();
        }

    }
}
