import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GamesPage extends AmazonPage{


    public GamesPage(  WebDriver driver )
    {
        super(driver);
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
