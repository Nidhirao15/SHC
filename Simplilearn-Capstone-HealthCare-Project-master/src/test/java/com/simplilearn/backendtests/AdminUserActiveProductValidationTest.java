package com.simplilearn.backendtests;

import com.simplilearn.hibernate.dao.ProductDetailsDao;
import com.simplilearn.hibernate.entity.ProductDetails;
import com.simplilearn.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class AdminUserActiveProductValidationTest extends BaseTest {

    @DataProvider(name = "product1NameDataProvider")
    public Object[][] productName1DataProvider(){
        return new Object[][] {{"Acetaminophen"}};
    }

    @DataProvider(name = "product2NameDataProvider")
    public Object[][] productName2DataProvider(){
        return new Object[][] {{"Ibuprofen"}};
    }

    @Test(dataProvider="product1NameDataProvider")
    public void adminUserEnableProductValidationTest(String product){

        ProductDetailsDao productDetailsDao = new ProductDetailsDao();

        List<ProductDetails> productDetails = productDetailsDao.getProductDetails(product);

        System.out.println("getproduct is active - "+productDetails.get(0).getIsActive());

        Assert.assertTrue(productDetails.get(0).getIsActive().equals("1"));
    }

    @Test(dataProvider = "product2NameDataProvider")
    public void adminUserDisableProductValidationTest(String product){
        ProductDetailsDao productDetailsDao = new ProductDetailsDao();

        List<ProductDetails> productDetails = productDetailsDao.getProductDetails(product);

        System.out.println("getproduct is not active - "+productDetails.get(0).getIsActive());

        Assert.assertTrue(productDetails.get(0).getIsActive().equals("0"));

    }
}
