package lib;

        import org.openqa.selenium.By;

public class PageMarket extends MainPageObject{

    private static final String
            MAIN_SEARCH_INPUT = "//input[@id='header-search']",
            SEARCH_BTN = "//span[@class='search2__button']";

    public void fillSearchField(String productNameStartSearching) {

        this.waitForElementAndSendKeys(
                By.xpath(MAIN_SEARCH_INPUT),
                productNameStartSearching,
                "Упс, что-то пошло не так - не могу найти поле поиска товара",
                10
        );
    }
    public void checkSearchField(String productNameStartSearching) {
        String productNameCheckSearching = waitForElementAndGetAttribute(
                By.xpath(MAIN_SEARCH_INPUT),
                "value",
                "Упс, что-то пошло не так - не могу найти поле поиска товара",
                10
        );

        if(productNameCheckSearching==null)
        {
            fail("Не получили значение атрибута у поля поиска");

        }
        System.out.println("productNameCheckSearching = " + productNameCheckSearching);
        if (productNameCheckSearching.equals(productNameStartSearching)) {

            System.out.println("Найденное значение идентично вводимому ранее в поле поиска");
        } else System.out.println("Найденное значение не равно вводимому ранее в поле поиска");
    }

    public void startSearching()
    {
        this.waitForElementAndClick(
                By.xpath(SEARCH_BTN),
                "Упс, что-то пошло не так - не могу найти кнопку 'Найти'",
                5
        );
    }
}
