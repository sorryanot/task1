package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class MainPage extends Page {
    private String URL = "https://www.21vek.by/";
    private By searchInputField = By.xpath("//input[@id='j-search']");
    private By AddProductButton = By.xpath("//button[text()='В корзину']");
    private By findCostProduct = By.xpath("//span[@class=' g-price result__price cr-price__in']/span[1]");


    public void open() {
        Selenide.open(URL);
    }

    public void inputName(String productName) {
        Selenide.element(searchInputField).setValue(productName).pressEnter();// вводим название товара в поиск
    }

    public void addInBasket() {
        Selenide.element(AddProductButton).shouldBe(Condition.enabled, HelperTimeOut.timeout()).click();// кликаем добавить в корзину
    }

    public void searchName(String productName) {
        setNameProduct(productName);//сохряняем название продукта
    }

    public void searchCost() {
        setCostProduct(Selenide.element(findCostProduct).getText());//находим и сохряняем цену продукта
    }
}
