package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageSearchResult extends MainPageObject{

    private static final String
            MAIN_SEARCH_INPUT = "//input[@id='header-search']",
            SEARCH_BTN = "//span[@class='search2__button']",
            MIN_PRICE = "//input[@id='glpricefrom']",
            MAX_PRICE = "//input[@id='glpriceto']",
            APPLE_FIX = "//input[@type='checkbox' and @name='Производитель Apple']",
            APPLE_CLICK = "//a[@class='_2RDCAZB4Gk']//span[@class='NVoaOvqe58'][contains(text(),'Apple')]",
            ASUS_FIX = "//input[@type='checkbox' and @name='Производитель ASUS']",
            ASUS_CLICK = "//a[@class='_2RDCAZB4Gk']//span[@class='NVoaOvqe58'][contains(text(),'ASUS')]",
            HP_FIX = "//input[@type='checkbox' and @name='Производитель HP']",
            HP_CLICK = "//a[@class='_2RDCAZB4Gk']//span[@class='NVoaOvqe58'][contains(text(),'HP')]",
            XIAOMI_FIX = "//input[@type='checkbox' and @name='Производитель Xiaomi']",
            XIAOMI_CLICK = "//a[@class='_2RDCAZB4Gk']//span[@class='NVoaOvqe58'][contains(text(),'Xiaomi')]",
            CORE_I7 = "//span[contains(text(),'Core i7')]",
            LIST_OF_PRICES_FOR_SEARCH_RESULT = "//div[@class='price']",
            ALERT_SEARCH_RESULT = "//span[@class='n-search-preciser__results-count']",
            HOODIE_LINK = "//a[contains(text(),'толстовка')]",
            LINC_YANDEX = "//a[@class='logo logo_type_link logo_part_yandex']";

    public void fillThePriceMin(String minPrice)
    {
        this.waitForElementAndSendKeys(
                By.xpath(MIN_PRICE),
                minPrice,
                "Упс, что-то пошло не так - не найдено поле цена от",
                5
        );
    }

    public void fillThePriceMax(String maxPrice)
    {
        this.waitForElementAndSendKeys(
                By.xpath(MAX_PRICE),
                maxPrice,
                "Упс, что-то пошло не так - не найдено поле цена до",
                5
        );
    }

    public void selectCompanyApple()
    {
        this.waitForElementAndClick(
                By.xpath(APPLE_CLICK),
                "Упс, что-то пошло не так - производитель не найден",
                5
        );
    }

    public void checkCompanyApple()
    {
        this.waitForElementAndCheckSelected(
                By.xpath(APPLE_FIX),
                "Упс, что-то пошло не так - чекбокс не выделен",
                5
        );
    }


    public void selectCompanyASUS()
    {
        this.waitForElementAndClick(
                By.xpath(ASUS_CLICK),
                "Упс, что-то пошло не так - производитель не найден",
                5
        );
    }

    public void checkCompanyASUS()
    {
        this.waitForElementAndCheckSelected(
                By.xpath(ASUS_FIX),
                "Упс, что-то пошло не так - чекбокс не выделен",
                5
        );
    }

    public void selectCompanyHP()
    {
        this.waitForElementAndClick(
                By.xpath(HP_CLICK),
                "Упс, что-то пошло не так - производитель не найден",
                5
        );
    }

    public void checkCompanyHP()
    {
        this.waitForElementAndCheckSelected(
                By.xpath(HP_FIX),
                "Упс, что-то пошло не так - чекбокс не выделен",
                5
        );
    }

    public void selectCompanyXIAOMI()
    {
        this.waitForElementAndClick(
                By.xpath(XIAOMI_CLICK),
                "Упс, что-то пошло не так - производитель не найден",
                5
        );
    }

    public void checkCompanyXIAOMI()
    {
        this.waitForElementAndCheckSelected(
                By.xpath(XIAOMI_FIX),
                "Упс, что-то пошло не так - чекбокс не выделен",
                5
        );
    }

    public void selectCorei7()
    {
        this.waitForElementAndClick(
                By.xpath(CORE_I7),
                "Упс, что-то пошло не так - процессор не найден",
                5
        );
    }

    public void priceComparing(int min, int max) {

/*        this.waitForElementAndBecomeEnabled(
                By.xpath(ALERT_SEARCH_RESULT),
                "Упс, что-то пошло не так элемент не найден",
                10
        )*/;

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> elementsList = driver.findElements(By.xpath(LIST_OF_PRICES_FOR_SEARCH_RESULT));
        int s = elementsList.size();
        String price;
        for (int i = 0; i < s; i++) {

            elementsList = driver.findElements(By.xpath(LIST_OF_PRICES_FOR_SEARCH_RESULT));
            price = elementsList.get(i).getText().replaceAll("[^0-9?!]", "");
            if (Double.parseDouble(price) >= min && Double.parseDouble(price) < max) {
                //System.out.println(elementsList.get(i).getText().replaceAll("[^0-9?!]", ""));
                //System.out.println("Цены результатов поиска находятся в заданном диапазоне");
            } else {
                fail("Цена товара выходит за пределы диапазона");
            }
        }
    }
    public void searchFieldClear(){
        this.waitForElementAndClear(
                By.xpath(MAIN_SEARCH_INPUT),
                "Упс, что-то пошло не так - поле не найдено",
                5
        );
    }

    public void searchElementText(){
        List<WebElement> elementsList = driver.findElements(By.xpath(HOODIE_LINK));
        int s = elementsList.size();
        if(s > 0)
            {
                this.waitForElementAndClick(
                        By.xpath(HOODIE_LINK),
                        "Упс, что-то пошло не так - не могу найти товар",
                        5
                );
            } else
            {
                System.out.println("Упс, что-то пошло не так - толстовки зелёный слоник нет на странице");
            }

    }

    public void goToPage(){

        this.waitForElementAndClick(
                By.xpath(LINC_YANDEX),
                "Упс, что-то пошло не так - не найдена ссылка перехода на 'Яндекс'",
                5
        );
    }

   /* public void chooseProdact(){
        this.waitForElementAndClick(
                By.xpath(HOODIE_LINK),
                "Упс, что-то пошло не так - толкстовок нет",
                5
        );
    }*/
}
