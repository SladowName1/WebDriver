import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class WebDriverSeleniumHQ {
    private final String selectedProductCost="22 руб.";

    @Test
    public void AddToBasketProductWithCorrespondingArticleTest() throws InterruptedException {
        WebDriver chromeDriver=new ChromeDriver();
        chromeDriver.get("https://igromaster.by/");

        WebElement searchButton= new WebDriverWait(chromeDriver, 6)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//span[@class='top-panel__search-icon']")));
        searchButton.click();


        WebElement searchInput = new WebDriverWait(chromeDriver, 9)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='title-search-input']")));

        searchInput.sendKeys("Карты Bicycle Standard (красные)");
        searchInput.sendKeys(Keys.ENTER);

        WebElement addingToBasketButton = new WebDriverWait(chromeDriver, 6)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//*[@id='bx_3966226736_10205_7e1b8e3524755c391129a9d7e6f2d206_buy_link']")));

        new WebDriverWait(chromeDriver, 8)
                .until(ExpectedConditions.elementToBeClickable(addingToBasketButton));
        addingToBasketButton.click();

        WebElement costOfProduct=new WebDriverWait(chromeDriver,9)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='allSum_FORMATED']")));

        Assert.assertEquals(costOfProduct.getText(),selectedProductCost);

        chromeDriver.quit();
    }


}
