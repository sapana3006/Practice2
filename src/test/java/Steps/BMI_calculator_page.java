package Steps;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterTest;
        import org.testng.annotations.BeforeTest;
        import org.testng.annotations.Test;

public class BMI_calculator_page

{

    WebDriver driver;
    @BeforeTest
    public void  setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sapna\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/bmi-calculator.html?ctype=metric");
    }
    public String BMIcalulator(String age, String gender, String height, String weight)
    {
        driver.findElement(By.xpath("//input[@id='cage']")).clear();
        driver.findElement(By.xpath("//input[@id='cage']")).sendKeys(age);
        driver.findElement(By.xpath("//label[contains(text(),'"+gender+"')]")).click();
        driver.findElement(By.xpath("//input[@id='cheightmeter']")).clear();
        driver.findElement(By.xpath("//input[@id='cheightmeter']")).sendKeys(height);
        driver.findElement(By.xpath("//input[@id='ckg']")).clear();
        driver.findElement(By.xpath("//input[@id='ckg']")).sendKeys(weight);
        driver.findElement(By.xpath("//input[@type='image']")).click();
        String actual_result = driver.findElement(By.xpath("//div[@class='bigtext']//b")).getText().trim();
        return actual_result;
    }
    @Test
    public void test1()
    {

        BMIcalulator("20","Male","180","60");
        Assert.assertEquals(BMIcalulator("20", "Male", "180", "60"), "BMI = 18.5 kg/m2");
    }
    @Test
    public void test2() {
        BMIcalulator("35", "Female", "160", "55");
        Assert.assertEquals(BMIcalulator("35", "Female", "160", "55"), "BMI = 21.5 kg/m2");
    }
    @Test
    public void test3() {
        BMIcalulator("50", "Male", "175", "65");
        Assert.assertEquals(BMIcalulator("50", "Male", "175", "65"), "BMI = 21.2 kg/m2");

    }
    @Test
    public void test4() {
        BMIcalulator("45", "Female", "150", "52");
        Assert.assertEquals(BMIcalulator("45", "Female", "150", "52"), "BMI = 23.1 kg/m2");


    }
    @AfterTest
    public  void close()
    {
        driver.quit();








    }
}


