import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class TestApp {
	public static void main(String[] args) throws InterruptedException{
		System.out.println("North America or Europe?");
		Scanner scanThis=new Scanner(System.in);
		String inputContinent=scanThis.nextLine();
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/David Yang/Downloads/homeork/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://staging-webapp.titanhst.com");
		//driver.manage().window().maximize();
		if (inputContinent.equals("North America")) {
			
			driver.findElement(By.className("country-america")).click();
			String password=scanThis.nextLine();
			inputUsPass("admin@e.com",password,driver);
		}
		
		
		else if(inputContinent.equals("Europe")) {
			driver.findElement(By.className("country-europe")).click();
			String password=scanThis.nextLine();
			inputUsPass("admin@e.com",password,driver);
		}
		System.out.println("Send alert,Send broadcast,Send status,Upload document,Send out lockdown,or Edit Name?");
		String inputCommand=scanThis.nextLine();
		if(inputCommand.equals("Send alert")) {
			String[] alertTypes= {"//DIV[@title='shooter']","//DIV[@title='weapon']","//DIV[@title='stranger']","//DIV[@title='fire']","//P[@class='icon-heading'][text()='medical']","//P[@class='icon-heading'][text()='earthquake']","//P[@class='icon-heading'][text()='weather']","//P[@class='icon-heading'][text()='drugs']","//DIV[@title='other']","//DIV[@title='package']","//DIV[@title='bomb']","//DIV[@title='Bullying']","//DIV[@title='Home Visit']","//DIV[@title='biohazard']","//DIV[@title='violence']","//DIV[@title='flood']","//DIV[@title='Suspicious Vehicle']","//DIV[@title='tornado']"};
			Random randnum=new Random();
			int randchoose=randnum.nextInt(18);
			driver.findElement(By.xpath(alertTypes[randchoose])).click();
			driver.findElement(By.xpath("//SPAN[text()='Send Alert']")).click();
			TimeUnit.SECONDS.sleep(5);
			driver.findElement(By.xpath("//BUTTON[@type='button'][text()='OK']")).click();
			System.out.println("Send text and picture/video?(yes/no)");
			String inputData=scanThis.nextLine();
			if(inputData.equals("yes")) {
				driver.findElement(By.xpath("//TEXTAREA[@name='message']")).sendKeys("Testing :");
				driver.findElement(By.xpath("//I[@class='glyphicon glyphicon-send']")).click();
				TimeUnit.SECONDS.sleep(5);
				WebElement fileInput = driver.findElement(By.name("files"));
				fileInput.sendKeys("C:/Users/David Yang/Pictures/2015-06/IMG_20150626_124643479.jpg");
				//driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[4]/div[1]/div[2]/div[1]/div/div[3]/div/div/div/form/div/input")).click();
				TimeUnit.SECONDS.sleep(15);
				driver.findElement(By.xpath("//I[@class='glyphicon glyphicon-send']")).click();
				
			}
			
			System.out.println("Call or Video?");
			String inputData2=scanThis.nextLine();
			if(inputData2.equals("Call")) {
				driver.findElement(By.xpath("//A[@class='btn btn-default pull-right all-white-btn submit-button custom-short-button ']")).click();
			}
			else if(inputData2.equals("Video")) {
				driver.findElement(By.xpath("//A[@class='btn btn-default pull-right btn-video all-white-btn submit-button custom-short-button']")).click();
			}
		}
		
		//driver.close();
		//driver.quit();
		//testGoogleSearch();
		
	}
	public static void inputUsPass(String username,String password,WebDriver chromeDrive) {
		chromeDrive.findElement(By.xpath("//INPUT[@type='email']")).sendKeys(username);
		chromeDrive.findElement(By.xpath("//INPUT[@type='password']")).sendKeys(password);
		chromeDrive.findElement(By.xpath("//SPAN[text()='Log in']")).click();
		chromeDrive.findElement(By.xpath("//BUTTON[@type='button'][text()='I agree']")).click();
		
	}
	public static void AlertsSendingAndReception() {
		  
	}
	public static void BroadCastSend(String CallOrVideo) {
		
	}
}
