import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

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
    public void loginTest2(String user , String pass)
    {
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

        driver.close();

//        login.setTxtUsername("admi1");
//        login.setTxtPassword("admin");
//        login.clickLoginBtn();

    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data=new Object[4][2];
        data[0][0]="admin1";
        data[0][1]="admin1";
        data[1][0]="admin2";
        data[1][1]="admin2";
        data[2][0]="admin3";
        data[2][1]="admin3";
        data[3][0]="admin4";
        data[3][1]="admin4";

        return data;
    }
}
