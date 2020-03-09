import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;



public class CardDelivery {
    @BeforeAll
    static void setUpAll(){
        SelenideLogger.addListener("allure",new AllureSelenide());}

    @AfterAll
    static void tearDownAll(){
        SelenideLogger.removeListener("allure");}


    @Test
    void shouldScheduleDateOfCardDelivery() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(DataHelper.getNewCity());
        $("[type='tel']").sendKeys(Keys.CONTROL, "a");
        $("[type='tel']").sendKeys(Keys.DELETE);
        $("[type='tel']").setValue(DataHelper.getFormattedRandomDate());
//      $("[type='tel']").setValue(String.valueOf(LocalDate.now().plusDays(5).getDayOfMonth() + "." + LocalDate.now().getMonthValue() + "." + LocalDate.now().getYear()));
        $("[name='name']").setValue(DataHelper.getNewName());
        $("[name='phone']").setValue(DataHelper.getNewPhone());
        $("[class='checkbox__box']").click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 25000);
        $("[type='tel']").sendKeys(Keys.CONTROL, "a");
        $("[type='tel']").sendKeys(Keys.DELETE);
        $("[type='tel']").setValue(DataHelper.getFormattedRandomDate());
        $$("button").find(Condition.exactText("Запланировать")).click();
        $(withText("Необходимо подтверждение")).waitUntil(Condition.visible, 25000);
        $$("button").find(Condition.exactText("Перепланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 25000);
    }


}
