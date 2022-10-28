import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy (id="login-username")
    WebElement txtUsername;

    @FindBy(xpath = "//input[@id='login-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement btnSubmit;

    public Login (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

 public void setTxtUsername(String username){
     txtUsername.sendKeys(username);
 }

 public void setTxtPassword(String password){
     txtPassword.sendKeys(password);
 }

 public void clickLoginBtn() {
        btnSubmit.click();
    }
}
