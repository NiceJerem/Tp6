import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolePage {

    WebDriver driver;

    public ConsolePage(  WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        head= new Header(driver);
    }

    @FindBy(id="navbar")
    Header head;

    public Header getHeader()
    {
        return head;
    }

    @FindBy(linkText="Jeux")
    WebElement categoryElement;
    public GamesPage openGamesCategory()
    {
        categoryElement.click();
        return new GamesPage(driver);
    }

}
