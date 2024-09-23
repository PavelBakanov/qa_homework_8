package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {
    private final TextBoxPage textBoxPage = new TextBoxPage();

    private final String fullName = "Ivan Ivanov";
    private final String userEmail = "ivanov@ivan.ru";
    private final String currentAddress = "Some street, 1";
    private final String permanentAddress = "Some street, 25";


    @Test
    public void textBoxWithPageObjectsTest() {
        textBoxPage.openPage()
                .setFullName(fullName)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .pushSubmitButton();

        textBoxPage.checkResult(fullName)
                .checkResult(userEmail)
                .checkResult(currentAddress)
                .checkResult(permanentAddress);

    }

}
