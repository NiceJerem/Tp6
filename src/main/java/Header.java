import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    WebDriver driver;

    public Header(  WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="nav-link-shopall")
    private WebElement menu;

    public WebElement getMenu()
    {
        return menu;
    }

    @FindBy(css = "span[data-nav-panelkey=\"VideogamesConsolesPanel\"]")
    WebElement jeuxVideos;
    public WebElement getVideoGame()
    {
        return jeuxVideos;
    }
    public ConsolePage openVideoGames(String textLink)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(getMenu());
        WebDriverWait wait = new WebDriverWait(driver, 5);
        actions.build().perform();
        WebElement jeuxVideo = getVideoGame();
        wait.until(ExpectedConditions.visibilityOf(jeuxVideo));
        actions.moveToElement(jeuxVideo);
        actions.build().perform();
        WebElement link = driver.findElement(By.xpath("//span[text()=\""+textLink+"\"]"));
        link.click();
        return new ConsolePage(driver);
    }
    @FindBy(id="hlb-view-cart-announce")
    WebElement btnOpenCart;

    public CartPage openCart(){
        btnOpenCart.click();
        return new CartPage(driver);
    }

    public void openBooks(String textLink) {

    }
}
