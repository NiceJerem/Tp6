import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage {
    WebDriver driver;

    public ItemPage(  WebDriver driver )
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

    @FindBy(id="add-to-cart-button")
    WebElement btnAddToCart;
    public ItemAddedPage addToCart()
    {
        btnAddToCart.click();
        return new ItemAddedPage(driver);
    }

}
