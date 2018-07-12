package old;

import old.BarreVerticale;
import old.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(  WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        menu= new BarreVerticale(driver);
    }

    @FindBy(id="secondary")
    BarreVerticale menu;

    public RegistrationPage OpenRegistration()
    {
        menu.registrationClick();
        return new RegistrationPage(driver);
    }
}
