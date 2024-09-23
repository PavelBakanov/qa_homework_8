package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends TestBase {
    String firstName = "Ivan";
    String lastName = "Ivanov";
    String userEmail = "ivanov@ivan.com";
    String gender = "Male";
    String userNumber = "8999111223";
    String negativeUserNumber = "FFFF";
    String dayOfBirth = "28";
    String monthOfBirth = "October";
    String yearOfBirth = "1992";
    String subjectsOne = "English";
    String subjectsTwo = "Maths";
    String hobbiesOne = "Reading";
    String hobbiesTwo = "Music";
    String pictureName = "example.jpg";
    String address = "Same street, 1";
    String state = "Uttar Pradesh";
    String city = "Merrut";


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationWithPageObjectsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectsOne)
                .setSubject(subjectsTwo)
                .setHobby(hobbiesOne)
                .setHobby(hobbiesTwo)
                .uploadPicture(pictureName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .pushSubmitButton();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjectsOne + ", " + subjectsTwo)
                .checkResult("Hobbies", hobbiesOne + ", " + hobbiesTwo)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    public void minimalDataRequiredTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .pushSubmitButton();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    public void negativePhoneNumberTest() {
        registrationPage.openPage()
                .removeBanner()
                .setUserNumber(negativeUserNumber);
        registrationPage.checkNegativeResult();
    }

}
