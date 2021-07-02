package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class BasketPage extends Page {

    private By basket = By.xpath("//span[text()='Корзина']");
    private By findCostProduct = By.xpath("//span[@class='j-basket__cost']");
    private By quantityProduct = By.xpath("//input[@class='g-form__text j-basket__counter']");

    public By getQuantityProduct() {
        return quantityProduct;
    }

    public void goToBasket() {
        Selenide.element(basket).shouldBe(Condition.enabled, HelperTimeOut.timeout()).click();//переходим на страницу корзины
    }

    public void searchName(String productName) {
        setNameProduct(Selenide.element(By.xpath("//div[@id='b-basket-container']//a[text()='" + productName + "']")).getText());//находим и сохряняем название продукта

    }

    public void searchCost() {
        setCostProduct(Selenide.element(findCostProduct).getText());//находим и сохряняем цену продукта
    }
}
