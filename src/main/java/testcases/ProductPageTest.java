package main.java.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ProductPage;
import pages.PagesFactory;


public class ProductPageTest extends BaseTest {
    ProductPage ProductPage;

    @Test(priority = 1)
    public void validateProductPageLoadSuccessfully() {
        try {
            initializeTest("ProductPage loading test",
                    "This test verifies that the Product page is loaded successfully",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkProductPageLoaded();
            Assert.assertTrue(result, "Product page is not loaded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void validateTableMessage() {
        try {
            initializeTest("Table message test",
                    "This test verifies that the table message is displayed",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkTableMessage();
            Assert.assertTrue(result, "Table message is not displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void validateShowTableButtonFunctionality() {
        try {
            initializeTest("Show Table Button Functionality",
                    "This test verifies that the Show Table Button Functionality is working",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkShowTableButtonFunctionality();
            Assert.assertTrue(result, "Show Table Button Functionality is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void validateShowTableButtonHidesTheTableOnSecondClick() {
        try {
            initializeTest("Show Table Button hides the table on second click",
                    "This test verifies that the Show Table Button hides the table on second click",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkShowTableButtonHidesTheTableOnSecondClick();
            Assert.assertTrue(result, "Show Table Button hides the table on second click");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5)
    public void validateSearchInputFieldShowingOnShowTableButtonClick() {
        try {
            initializeTest("Search input field showing on Show Table Button click",
                    "This test verifies that the Search input field showing on Show Table Button click",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkSearchInputFieldShowingOnShowTableButtonClick();
            Assert.assertTrue(result, "Search input field showing on Show Table Button click");
        } catch (Exception e) {
            e.printStackTrace();
    }}

    @Test(priority = 6)
    public void validateContextMenuButtonWorkingForTableRows() {
        try {
            initializeTest("Context menu button working for table rows",
                    "This test verifies that the Context menu button working for table rows",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkContextMenuButtonWorkingForTableRows();
            Assert.assertTrue(result, "Context menu button working for table rows");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test(priority = 7)
    public void validateAllTableColumnsAreVisible() {
        try {
            initializeTest("All table columns are visible",
                    "This test verifies that all table columns are visible",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkAllTableColumnsAreVisible();
            Assert.assertTrue(result, "All table columns are not visible");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8)
    public void validateAddProductFunctionality() {
        try {
            initializeTest("Add Product Button Functionality",
                    "This test verifies that the Add Product Button Functionality is working",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkAddProductButtonFunctionality();
            Assert.assertTrue(result, "Add Product Button Functionality is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9)
    public void validateCancelButtonFunctionalityOnAddProductPage() {
        try {
            initializeTest("Cancel Button Functionality on Add Product Page",
                    "This test verifies that the Cancel Button Functionality on Add Product Page is working",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkCancelButtonFunctionalityOnAddProductPage();
            Assert.assertTrue(result, "Cancel Button Functionality on Add Product Page is not working");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10)
    public void validateAddProductFormGetsFillUpCorrectly() {
        try {
            initializeTest("Add Product Form gets fill up correctly",
                    "This test verifies that the Add Product Form gets fill up correctly",
                    "Integration Testing");

            ProductPage = PagesFactory.getProductPage();
            boolean result = ProductPage.checkAddProductFormGetsFillUpCorrectly();
            Assert.assertTrue(result, "Add Product Form gets fill up correctly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}