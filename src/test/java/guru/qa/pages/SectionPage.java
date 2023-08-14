package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SectionPage {

    private SelenideElement
            sectionTitle = $(".catalog-title");

    public void checkSectionName(String sectionName) {
        sectionTitle.shouldHave(Condition.text(sectionName));
    }
}