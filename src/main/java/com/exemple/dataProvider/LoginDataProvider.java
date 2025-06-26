package com.exemple.dataProvider;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        return new Object[][]{
                {"eve.holt@reqres.in", "pistol"}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][]{
                {"sydney@fife", null}
        };
    }
}
