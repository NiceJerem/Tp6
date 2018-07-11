import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemAddedPage {
    WebDriver driver;

    public ItemAddedPage(  WebDriver driver )
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
}
