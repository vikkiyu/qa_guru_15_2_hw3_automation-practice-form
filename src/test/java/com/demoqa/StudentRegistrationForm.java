package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillNameTest() {
    open("/automation-practice-form");
    $("[id=firstName]").setValue("Victoria");
    $("[id=lastName]").setValue("Yu");
    $("[id=userEmail]").setValue("victoria.yu1724@gmail.com");
    $(byText("Female")).click();
    $("[id=userNumber").setValue("9876543210");
    $("[id=dateOfBirthInput]").click();
    $("[class=react-datepicker__month-select]").selectOption("December");
    $("[class=react-datepicker__year-select]").selectOption("1989");
    $(".react-datepicker__day--017").click();
    $("#subjectsInput").setValue("English").pressEnter();
    $(byText("Music")).click();
    $("#uploadPicture").uploadFile(new File("src/test/resources/pika.png"));
    $("#currentAddress").setValue("New street");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    $("[id=react-select-3-input]").setValue("Haryana").pressEnter();
    $("[id=react-select-4-input]").setValue("Karnal").pressEnter();
    $("[id=submit]").click();

    $("[class=table-responsive]").shouldHave(text("Victoria"),
            text("Yu"),
            text("victoria.yu1724@gmail.com"),
            text("Female"),
            text("9876543210"),
            text("17 December,1989"),
            text("English"),
            text("Music"),
            text("New street "),
            text("Haryana Karnal"));
    $("[id=closeLargeModal]").click();
    }
}
