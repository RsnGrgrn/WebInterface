package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {

    @Test
    public void shouldSubmitCardOrder() {
        open("http://localhost:9999/");
        SelenideElement form = $("form");
        form.$("[data-test-id=name] input").setValue("Епифа-нов Алексей");
        form.$("[data-test-id=phone] input").setValue("+79999999999");
        form.$("[data-test-id=agreement] span").click();
        form.$("button").click();
        $("[data-test-id=order-success]").should(Condition.exactText(
                "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."
        ));
    }
}