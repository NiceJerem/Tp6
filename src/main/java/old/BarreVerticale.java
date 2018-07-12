package old;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class BarreVerticale {
    WebDriver driver;

    public BarreVerticale(  WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void registrationClick()
    {
        btnRegistration.click();
    }

    @FindBy(id="menu-registration")
    private WebElement btnRegistration;

    //menu-interactions
    @FindBy(id = "menu-interactions")
    private WebElement btnDraggable;

    @FindBy(id="menu-interactions")
    private WebElement btnDroppable;

    @FindBy(id="menu-interactions")
    private WebElement btnResizable;

    @FindBy(id="menu-interactions")
    private WebElement btnSelectable;

    @FindBy(id="menu-interactions")
    private WebElement btnSortable;

    //menu-widget

}
