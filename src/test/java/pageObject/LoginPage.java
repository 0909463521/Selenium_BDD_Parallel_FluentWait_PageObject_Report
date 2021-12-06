package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import services.FluentWaitCode;

//rahulonlinetutor@gmail.com
public class LoginPage extends FluentWaitCode {


//     WebDriver driver ; không nên tạo biến bừa bãi
    // Find by Relative
    By email=By.xpath("//input[@name='email']");
    By password=By.xpath("//input[@name='password']");
    By login=By.xpath("//button[@type='submit']");

    // TODO Find element by Sibling ( special )

    By yourlocation = By.xpath("(//div[@class='dashboard-main-content']//div[@class='form-content'][//strong[contains(text(),'Your IP location')]]/preceding-sibling::div//h3)");


//
    public LoginPage(WebDriver driver) {
        // TODO Auto-generated constructor stub

        this.driver=driver;

    }




    public WebElement getEmail()
    {

        return waitedElement(email);
    }


    public WebElement getPassword()
    {
        return waitedElement(password);
    }

    public WebElement getLogin()
    {
        return waitedElement(login);
    }

    public WebElement yourLocation()
    {
        return waitedElement(yourlocation);
    }



}
