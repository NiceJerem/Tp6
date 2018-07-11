import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GamesPage {
    WebDriver driver;

    public GamesPage(  WebDriver driver )
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

    @FindBy(id="mainResults")
    WebElement results;
    public ItemPage openItem(int item)
    {
        List<WebElement> ListResults = results.findElements(By.tagName("li"));
        ListResults.get(item).findElement(By.tagName("h2")).click();
        return new ItemPage(driver);
    }

}
