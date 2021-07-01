package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BasketPage;
import pages.MainPage;


public class TestSteps {

    MainPage mainPage = new MainPage();
    BasketPage basketPage = new BasketPage();

    @Given("Open main page")
    public void iGoToMainPage() {
        mainPage.open();
    }

    @When("Find product {string} and add in the Basket")
    public void iAddProductInShoppingBasket(String nameProduct) {
        mainPage.inputName(nameProduct);
        mainPage.addInBasket();
        mainPage.searchName(nameProduct);
        mainPage.searchCost();
    }

    @When("Go to Basket page")
    public void iGoToShoppingBasketPage() {
        basketPage.goToBasket();

    }

    @Then("Check that the name product {string} is correct")
    public void nameIsCorrect(String nameProduct) {
        basketPage.searchName(nameProduct);
        Assert.assertEquals("Product name does not match", basketPage.getNameProduct(), mainPage.getNameProduct());//Проверяем совпадение названия товара
    }

    @Then("Checking the cost of the product")
    public void costIsCorrect() {
        basketPage.searchCost();
        Assert.assertTrue("Product price does not match", basketPage.getCostProduct().contains(mainPage.getCostProduct()));//Проверяем совпадение цены товара
    }

    @Then("Сheck that the product is {string}")
    public void quantityIsCorrect(String quantity) {
        Selenide.$(By.xpath("//input[@class='g-form__text j-basket__counter']")).shouldHave(Condition.value(quantity));//Проверяем, что товар в корзине 1
    }
}

