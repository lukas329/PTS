import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ais2.ukf.sk/ais/start.do");

        try{
            Thread.sleep(3000);
            driver.findElement(By.id("accept-cookies")).click();
            Thread.sleep(500);
            WebElement login = driver.findElement(By.id("login"));
            login.sendKeys("login");
            WebElement pass = driver.findElement(By.id("heslo"));
            pass.sendKeys("password");
            pass.submit();

            Thread.sleep(2000);

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(scrFile, new File("C:\\Users\\Student\\Desktop\\PTS_Test\\scr1.png"));

            WebElement logout = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/a/span"));
            logout.click();
            Thread.sleep(1000);

            WebElement odhlasit = driver.findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/div/a/span"));
            odhlasit.click();
            Thread.sleep(1000);
        }catch (Exception e ){
            System.out.println(e);
        }

        driver.quit();



    }
}