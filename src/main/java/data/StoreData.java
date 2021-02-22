package data;

import com.lizi.utils.ExcelDataUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

/**
 * @Author: lizi
 * @Date: 2020/12/4 6:04 下午
 */
public class StoreData {
    @DataProvider
    public static Object[][] getData() throws Exception {
        ExcelDataUtil excel =new ExcelDataUtil("src/main/resources/crmparams/store.xlsx");
        Object[][] stores = excel.getTestData("store");
        return stores;

    }
}
