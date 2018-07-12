import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AmazonPage {

    protected WebDriver driver;

    @FindBy(id="navbar")
    protected Header head;

    public Header getHeader()
    {
        return head;
    }


    public AmazonPage(  WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        head= new Header(driver);
    }

}
