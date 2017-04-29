package by.auto.test.tests;

import by.auto.test.model.ContactObject;
import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by aleksey.dobrovolsky on 4/29/2017.
 */
public class ContactComparePhonesAddressesEmailsWithEditForm extends TestBase{
    @Test
    public void contactComparePhonesAddressesEmailsWithEditForm(){
        app.goTo().goToHomePageHeaderLink();
        ContactObject contact = app.contact().all().iterator().next();
        ContactObject contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));


    }

    public String mergePhones(ContactObject contact){
        return Arrays.asList(contact.getContactHome(), contact.getContactMobile(), contact.getContactWork(), contact.getContactHome2())
                .stream()
                .filter((s)-> !s.equals(""))
                .map(ContactComparePhonesAddressesEmailsWithEditForm::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned (String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
