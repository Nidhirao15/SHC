package com.simplilearn.backendtests;

import com.simplilearn.hibernate.dao.ProductDetailsDao;
import com.simplilearn.hibernate.entity.ProductDetails;
import com.simplilearn.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AdminUserAddNewProductValidationTest extends BaseTest {

    @DataProvider(name = "productdetailsDataProvider")
    public Object[][] productdetailsDataProvider(){
        return new Object[][]{
                {"Acetaminophen", "Tylenol", "Pain Reliever"}
        };
    }

    @Test(dataProvider = "productdetailsDataProvider")
    public void adminUserAddNewProductBackEndValidationTest(String product, String brand, String description) {

        ProductDetailsDao productDetailsDao = new ProductDetailsDao();

        List<ProductDetails> productDetails = productDetailsDao.getProductDetails(product);
        Assert.assertEquals(product, productDetails.get(0).getName());
        Assert.assertEquals(brand, productDetails.get(0).getBrand());
        Assert.assertEquals(description, productDetails.get(0).getDescription());
    }
}
