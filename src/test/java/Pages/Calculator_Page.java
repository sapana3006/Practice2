package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Calculator_Page {
    WebDriver driver;
   public Calculator_Page(WebDriver driver1)
   {
    driver=driver1;
   }

   public void goto_url(String url)
   {
       driver.get(url);


   }

  public String GetTitle()
   {
      return driver.getTitle();
   }

    public void enterNumber(String n)//123 value passing
   {
       int count=n.length();
       for (int i=0;i<count;i++) {


           driver.findElement(By.xpath("//span[@onclick=\"r(" + n.charAt(i)+ ")\"]")).click();
       }

   }
    public  void enterOperator(String op)
   {
       driver.findElement(By.xpath("//span[@onclick=\"r('"+op+"')\"]")).click();

   }


    public String getResult()
    {

        String actual_result = driver.findElement(By.id("sciOutPut")).getText().trim();
        System.out.println("result" + actual_result);
        return actual_result;
    }
}
