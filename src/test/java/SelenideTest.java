import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class SelenideTest {

    @BeforeAll
    public static void beforeAllMethod() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    public void checkSelenidePage() {

        String ExampleJunit5 = "@ExtendWith({SoftAssertsExtension.class})\n"
                +"class Tests {\n"
                +"@Test\n"
                +" void test() {\n"
                +"Configuration.assertionMode = SOFT;\n"
                +"open(\"page.html\");\n"
                +"\n"
                +"$(\"#first\").should(visible).click();\n"
                +" $(\"#second\").should(visible).click();\n"
                +"}\n" +
                "}";

        open("/selenide/selenide"); // открыть страницу селенид

        $("#wiki-tab").click(); // открыть вики

        $("#wiki-pages-filter").setValue("SoftAssertions"); //ввести в поиске SoftAssertions

        $("a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click(); //переход по результату поиска

        checkCode(ExampleJunit5);

    }

    private static void checkCode(String ExampleJunit5) {
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

        $("#wiki-body").shouldHave(text(ExampleJunit5));
    }
}
