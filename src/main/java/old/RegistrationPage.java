package old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name_3_firstname")
    private WebElement txtFirstName;

    //menu-interactions
    @FindBy(id = "name_3_lastname")
    private WebElement txtLastName;

    public RegistrationPage writeNames(String firstName, String lastName) {
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")
    private WebElement chkSingle;

    public RegistrationPage setSingle()
    {
        chkSingle.click();
        return this;
    }

    @FindBy(xpath = "//*[@id=\"pie_register\"]/li[3]/div/div/input[1]")
    private WebElement chkDance;
    public RegistrationPage checkDance()
    {
        if(!chkDance.isSelected()) {
            chkDance.click();
        }
        return this;
    }

    @FindBy(id="dropdown_7")
    private Select selectCountry;
    public RegistrationPage selectCountry(String country)
    {
        WebElement ele = driver.findElement(By.id("dropdown_7"));
        selectCountry = new Select(ele );
        selectCountry.selectByValue(country);
        return this;
    }
    //-------
    @FindBy(id="mm_date_8")
    private Select selectMonth;
    @FindBy(id="dd_date_8")
    private Select selectDay;
    @FindBy(id="yy_date_8")
    private Select selectYear;
    public RegistrationPage selectDate(String dd,String mm, String yyyy) {
        WebElement dd_ele = driver.findElement(By.id("dd_date_8"));
        selectMonth = new Select(dd_ele );
        selectMonth.selectByValue(dd);

        WebElement mm_ele = driver.findElement(By.id("mm_date_8"));
        selectDay = new Select(mm_ele );
        selectDay.selectByValue(mm);

        WebElement yy_ele = driver.findElement(By.id("yy_date_8"));
        selectYear = new Select(yy_ele );
        selectYear.selectByValue(yyyy);
        return this;
    }

    //---------
    public void writeComplementaryInfo(String phone,String userName, String desc)
    {
        txtPhone.sendKeys(phone);
        txtUserName.sendKeys(userName);
        txtDescription.sendKeys(desc);
    }
    public void writeEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void writePassword(String password, String confirmPass)
    {
        txtPassword.sendKeys(password);
        confirmPassword.sendKeys(confirmPass);
    }
    //
    @FindBy(xpath="//*[@id=\"pie_register\"]/li[8]/div/div/span")
    WebElement errorEmail;
    public boolean isEmailError()
    {
        return errorEmail.isDisplayed();
    }
    //legend_txt

    @FindBy(id="phone_9")
    private WebElement txtPhone;
    @FindBy(id="username")
    private WebElement txtUserName;
    @FindBy(id="email_1")
    private WebElement txtEmail;
    @FindBy(id="profile_pic_10")
    private WebElement txtProfilePic;
    @FindBy(id="description")
    private WebElement txtDescription;
    @FindBy(id="password_2")
    private WebElement txtPassword;

    @FindBy(id="confirm_password_password_2")
    private WebElement confirmPassword;
    public void submit()
    {
        btnSubmit.click();
    }
    @FindBy(name="pie_submit")
    private WebElement btnSubmit;


}
