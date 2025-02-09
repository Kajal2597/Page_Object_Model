package org.example.datadriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_ex {
    @DataProvider
    public Object[][]datas() throws InterruptedException {
        Object[][] data=new Object[2][2];
        data[0][0]="kajal";
        data[0][1]="kajal1233";
        Thread.sleep(5000);

        data[1][0]="kiran";
        data[1][1]="Kiran133";
return data;

    }
    @Test(dataProvider="datas")
    public void login(String name,String pass) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.giva.co/account/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='CustomerEmail']")).sendKeys(name);
        driver.findElement(By.name("customer[password]")).sendKeys(pass);
        Thread.sleep(5000);

        driver.findElement(By.xpath("//img[@alt='GIVA Jewellery']"));

    }

}
