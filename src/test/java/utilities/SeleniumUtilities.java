package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SeleniumUtilities {

    public WebElement findElement(WebDriver driver, By locator){
        try{
            return driver.findElement(locator);
        } catch (NoSuchElementException e){
            System.out.println("The element was not found " + e.getMessage());
            return null;
        }
    }


    public WebElement findElementRetry(WebDriver driver, By locator, int numberOfRetries) throws InterruptedException {
        for (int i = 1; i < numberOfRetries; i++) {
            try {
                return driver.findElement(locator);
            } catch (NoSuchElementException e){
                Thread.sleep(1000);
            }
        }
        return null;
    }



//String format can be: dd/MM/yyyy ; yyyy/MM/dd ; MM/dd/yyyy
    public String getCurrentDate(String format) {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return dateObj.format(formatter);
    }



}
