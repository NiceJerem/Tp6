import old.HomePage;
import old.RegistrationPage;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TP6 {
    WebDriver driver;

    @Before
    public void beforeTest()
    {
        String browser = System.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else{
            driver = new ChromeDriver();
        }

        driver.get("http://demoqa.com/");
    }

    @Test
    public void t1()
    {
        HomePage home = new HomePage(driver);
        RegistrationPage rp =home.OpenRegistration();
        rp.writeNames("test","testu");
        rp.checkDance().setSingle();
        rp.writeComplementaryInfo("0545154245","user","DESC");
        rp.writePassword("fhzojiefjz","fhzojiefjz");
        rp.selectCountry("France");
        rp.selectDate("12","5","2012");
        //rp.writeEmail("fheife@emak.com");
        rp.submit();
        Assert.assertThat(rp.isEmailError(), Is.is(true));
        System.out.println(" OK : "+ rp.isEmailError());
        //legend_txt

    }

    @After
    public void tearDown()
    {

    }
}
