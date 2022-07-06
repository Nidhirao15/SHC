package com.simplilearn.backendtests;

import com.simplilearn.hibernate.dao.AddressDao;
import com.simplilearn.hibernate.dao.UserDetailsDao;
import com.simplilearn.hibernate.entity.AddressDetails;
import com.simplilearn.hibernate.entity.UserDetails;
import com.simplilearn.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class EndUserRegisterValidationTest extends BaseTest {

    @DataProvider(name = "signUpDataProvider")
    public Object[][] signUpDataProvider(){
        return new Object[][]{
                {"Adam", "Smith", "as@gmail.com", "2323232323", "1234", "USER",
                         "Apt 1234", "Beach St", "Los Angeles",
                "123445", "California", "USA"}
        };
    }

    @Test(dataProvider = "signUpDataProvider")
    public void endUserRegisterBackEndValidationTest(String firstname, String lastname, String email, String contact, String password, String role,
                                                     String addressline1, String addressline2, String city, String postalcode, String state, String country){
        UserDetailsDao userDetailsDao = new UserDetailsDao();
        AddressDao addressDao = new AddressDao();

        List<UserDetails> userDetails = userDetailsDao.getUserDetails(firstname);

        int userId = userDetails.get(0).getUserId();

        List<AddressDetails> addressDetails = addressDao.getAddressDetails(userId);

        Assert.assertEquals(firstname, userDetails.get(0).getFirstName());
        Assert.assertEquals(lastname, userDetails.get(0).getLastName());
        Assert.assertEquals(email, userDetails.get(0).getEmail());
        Assert.assertEquals(contact, userDetails.get(0).getContact());
        Assert.assertEquals(role, userDetails.get(0).getRole());
        Assert.assertEquals(addressline1, addressDetails.get(0).getAddressLineOne());
        Assert.assertEquals(addressline2, addressDetails.get(0).getAddressLineTwo());
        Assert.assertEquals(city, addressDetails.get(0).getCity());
        Assert.assertEquals(postalcode, addressDetails.get(0).getPostalCode());
        Assert.assertEquals(state, addressDetails.get(0).getState());
        Assert.assertEquals(country, addressDetails.get(0).getCountry());

    }
}
