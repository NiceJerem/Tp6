import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(  WebDriver driver )
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

    @FindBy(xpath="//*[@id=\"activeCartViewForm\"]/div[2]")
    WebElement cartList;
    public void changeItemQuantity(int indexItem, int quantity)
    {
        List<WebElement> list = cartList.findElements(By.tagName("div"));
        WebElement element=  list.get(indexItem);
        ////*[@id="activeCartViewForm"]/div[2]/div[1]/div[4]/div/div[3]/div/div/span/select
        //
        WebElement quantityBox=  element.findElement(By.xpath("//*[@id=\"activeCartViewForm\"]/div[2]/div["+String.valueOf(indexItem+1)+"]/div[4]/div/div[3]/div/div/span/select"));
        //WebElement quantityBox=  element.findElement(By.xpath("quantity"));
        System.out.println("TEXT :"+quantityBox.getText()+".");
        Select quantitySelect = new Select(quantityBox);
        quantitySelect.selectByValue( String.valueOf(quantity));
    }

    @FindBy(id="sc-subtotal-amount-activecart")
    WebElement priceResult;
    public String getTotalPrice()
    {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.id("sc-subtotal-amount-activecart"), "EUR 161,96"));
        return priceResult.getText();
    }
}
