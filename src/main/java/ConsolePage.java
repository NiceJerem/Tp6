import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolePage extends AmazonPage {


    public ConsolePage(  WebDriver driver )
    {
        super(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(linkText="Jeux")
    WebElement categoryElement;
    public GamesPage openGamesCategory()
    {
        categoryElement.click();
        return new GamesPage(driver);
    }

}
