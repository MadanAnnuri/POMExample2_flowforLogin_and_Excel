import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddCusMultiple
{
    WebDriver driver;
    @BeforeClass
    public void doLogin(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");

        WebElement txtUsername= driver. findElement(By.name("username"));
        txtUsername.sendKeys("admin");
        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("admin");
        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test (dataProvider = "getData")
    public void addCustomer(String name,String address , String cont1 ,String con2){
        driver.findElement(By.xpath("//a[normalize-space()='Add Customer']")).click();

        WebElement txtname= driver. findElement(By.xpath("//input[@id='name']")); txtname.sendKeys(name);
        WebElement txtaddress= driver. findElement(By.xpath("//textarea[@placeholder='ENTER YOUR ADDRESS']")); txtaddress.sendKeys(address);
        WebElement contact1= driver. findElement(By.xpath("//input[@id='buyingrate']")); contact1.sendKeys(cont1);
        WebElement contact2= driver. findElement(By.xpath("//input[@id='sellingrate']")); contact2.sendKeys(con2);
        WebElement addBtn= driver. findElement(By.xpath("//input[@name='Submit']")); addBtn.click();

    }

    @DataProvider
    public Object[][] getData() throws IOException {
            FileInputStream fp=new FileInputStream("Data/mydataXlsx.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(fp);

            XSSFSheet sheet = workbook.getSheet("sheet4");

            int rowCount=sheet.getPhysicalNumberOfRows();
            Object[][] data=new Object[rowCount-1][4];

            for (int i=0;i<rowCount-1;i++){
                XSSFRow row =sheet.getRow(i+1);
                for(int j=0;j<4;j++){
                    XSSFCell cell=row.getCell(j);
                    data[i][j]=cell.toString().trim();
                }
            }
        return data;
       }

}
