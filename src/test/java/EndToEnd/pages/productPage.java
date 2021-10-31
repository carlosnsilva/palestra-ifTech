package EndToEnd.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage extends basePage{

    @FindBy (xpath = "//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[6]/div/div/div/div")
    private WebElement productElement;

    @FindBy (xpath = "//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[6]/div/div/div/div/div[3]/div[1]/h2/a/span")
    private WebElement descriptionProductElement;

    @FindBy (xpath = "//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[6]/div/div/div/div/div[3]/div[3]/div/div[1]/a/span/span[2]/span[2]")
    private WebElement valueProductElement;

    public productPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void validadeProduct(){
        waitSeconds(5000);
        scrollToElement(productElement);

        Assert.assertEquals(descriptionProductElement.getText(),"XIAOMI 7622 Pulseira Smart Mi Band 6");
        Assert.assertEquals(valueProductElement.getText(),"245");
    }
}
