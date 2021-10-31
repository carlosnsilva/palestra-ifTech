package EndToEnd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage extends basePage{

    @FindBy (xpath = ".//*[@id='twotabsearchtextbox']")
    private WebElement searchBar;

    @FindBy (xpath = ".//*[@class='nav-search-submit nav-sprite']")
    private WebElement searchButton;

    public homePage(String URL) {
        super(null);
        PageFactory.initElements(driver,this);
        start(URL);
    }

    public void quit(){
        close();
    }

    public productPage searchProduct(String value){
        waitSeconds(5000);
        sendKeys(searchBar,value);
        click(searchButton);

        waitSeconds(5000);
        return new productPage(driver);
    }
}
