package com.metlife.utils;

import org.testng.annotations.DataProvider;

public class DataUtils {
    @DataProvider
    public Object[][] validLoginData()
    {
        Object[][] data=new Object[2][3];
        data[0][0]="admin";
        data[0][1]="pass";
        data[0][2]="OpenEMR";

        data[1][0]="accountant";
        data[1][1]="accountant";
        data[1][2]="OpenEMR";

        return data;
    }
}
