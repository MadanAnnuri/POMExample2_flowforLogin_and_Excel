import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginTestExcel {

    @Test
    public void loginTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        Login login = new Login(driver);

        login.setTxtUsername("admin");
        login.setTxtPassword("admin");
        login.clickLoginBtn();

    }
    @Test (dataProvider = "getData")
    public void loginTest2(String user , String pass) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

//        Login login = new Login(driver);

        WebElement txtUsername= driver. findElement(By.name("username"));
        txtUsername.sendKeys(user);
        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys(pass);
        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();
        //Thread.sleep(2000);
        //driver.close();

//        login.setTxtUsername("admi1");
//        login.setTxtPassword("admin");
//        login.clickLoginBtn();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File scrFile = ts.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";
        FileUtils.copyFile(scrFile,new File("C:\\Output SS\\"+fileName));

        driver.close();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fp=new FileInputStream("Data/mydata.xls");
        HSSFWorkbook workbook=new HSSFWorkbook(fp);

        HSSFSheet sheet = workbook.getSheet("sheet1");

        int rowCount=sheet.getPhysicalNumberOfRows();
        Object[][] data=new Object[rowCount][2];

        for (int i=0;i<rowCount;i++){
            HSSFRow row=sheet.getRow(i);

            HSSFCell username=row.getCell(0);
            data[i][0]=username.toString().trim();

            HSSFCell password =row.getCell(1);
            data[i][1]=password.toString().trim();
        }

//        Object[][] data=new Object[4][2];
//        data[0][0]="admin1";
//        data[0][1]="admin1";
//        data[1][0]="admin2";
//        data[1][1]="admin2";
//        data[2][0]="admin3";
//        data[2][1]="admin3";
//        data[3][0]="admin4";
//        data[3][1]="admin4";

        return data;


    }

}
