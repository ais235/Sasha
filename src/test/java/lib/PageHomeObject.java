package lib;

import org.openqa.selenium.By;


public class PageHomeObject extends MainPageObject{

    private static final String
            MARKET_LINK = "//a[contains(text(),'Маркет')]";

    public void goToMarket()
    {
        this.waitForElementAndClick(
                By.xpath(MARKET_LINK),
                "Упс, что-то пошло не так - не найдена ссылка перехода на 'Маркет'",
                5
        );
    }



}
