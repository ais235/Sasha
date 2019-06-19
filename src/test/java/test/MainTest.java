package test;

import lib.CoreTestCase;
import lib.PageMarket;
import lib.PageSearchResult;
import org.junit.Test;
import lib.PageHomeObject;


public class MainTest extends CoreTestCase {


    @Test
    public void testAllSteps()
    {
        System.out.println("Запуск теста");
        PageHomeObject pageHomeObject = new PageHomeObject();
        pageHomeObject.goToMarket();


        PageMarket pageMarket = new PageMarket();
        String productName ="Ноутбуки";

        pageMarket.fillSearchField(productName);
        pageMarket.checkSearchField(productName);
        pageMarket.startSearching();


        PageSearchResult pageSearchResult = new PageSearchResult();


        pageSearchResult.selectCompanyApple();
        pageSearchResult.selectCompanyASUS();
        pageSearchResult.selectCompanyHP();
        pageSearchResult.selectCompanyXIAOMI();

        pageSearchResult.checkCompanyApple();
        pageSearchResult.checkCompanyASUS();
        pageSearchResult.checkCompanyHP();
        pageSearchResult.checkCompanyXIAOMI();

        pageSearchResult.selectCorei7();
        String minPrice ="100000";
        pageSearchResult.fillThePriceMin(minPrice);
        String maxPrice ="200000";
        pageSearchResult.fillThePriceMax(maxPrice);
        pageSearchResult.priceComparing(100000, 200000);

        pageSearchResult.searchFieldClear();

        String productName2 ="Зеленый слоник";
        pageMarket.fillSearchField(productName2);
        pageMarket.startSearching();

        pageSearchResult.searchElementText();
        pageSearchResult.goToPage();
        System.out.println("Тест окончен");
    }


}
