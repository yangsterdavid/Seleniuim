import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class TestApp2 {
	public static void main(String[] args) throws InterruptedException{
		System.out.println("North America or Europe?");
		Scanner scanThis=new Scanner(System.in);
		String inputContinent=scanThis.nextLine();
		System.setProperty("webdriver.chrome.driver", "C:/Users/David Yang/Downloads/homeork/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://staging-webapp.titanhst.com");
		if (inputContinent.equals("North America")) {
			driver.findElement(By.xpath("//IMG[@class='country-america']")).click();
		}
		//driver.manage().window().maximize();
		System.out.println("Password?");
		String inputpass=scanThis.nextLine();
		inputUsPass("admin@e.com",inputpass,driver);
		while(true) {
			System.out.println("Send alert, Send broadcast, Send status, Upload document, Send out lockdown, or Edit Name?");
			String inputCommand=scanThis.nextLine();
			if (inputCommand.equals("Send alert")){
				AlertsSendingAndReception(driver,scanThis);
			}
			else if(inputCommand.equals("Send broadcast")) {
				BroadCastSend(driver);
			}
			else if(inputCommand.equals("Send status")) {
				
			}
			else if(inputCommand.equals("exit")) {
				break;
			}
			else {
				System.out.println("Not a valid command, type the action you want letter for letter.");
				continue;
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
	public static void AlertsSendingAndReception(WebDriver drive1,Scanner scan1) throws InterruptedException {
		String[] alertTypes= {"//DIV[@title='shooter']","//DIV[@title='weapon']","//DIV[@title='stranger']","//DIV[@title='fire']","//P[@class='icon-heading'][text()='medical']","//P[@class='icon-heading'][text()='earthquake']","//P[@class='icon-heading'][text()='weather']","//P[@class='icon-heading'][text()='drugs']","//DIV[@title='other']","//DIV[@title='package']","//DIV[@title='bomb']","//DIV[@title='Bullying']","//DIV[@title='Home Visit']","//DIV[@title='biohazard']","//DIV[@title='violence']","//DIV[@title='flood']","//DIV[@title='Suspicious Vehicle']","//DIV[@title='tornado']"};
		Random randnum=new Random();
		int randchoose=randnum.nextInt(18);
		drive1.findElement(By.xpath("(//IMG[@class='show-image-color sidebar-image-hw'])[1]")).click();
		drive1.findElement(By.xpath(alertTypes[randchoose])).click();
		drive1.findElement(By.xpath("//SPAN[text()='Send Alert']")).click();
		TimeUnit.SECONDS.sleep(4);
		drive1.findElement(By.xpath("//BUTTON[@type='button'][text()='OK']")).click();
		System.out.println("Sending text and picture....");
		drive1.findElement(By.xpath("//TEXTAREA[@name='message']")).sendKeys("Testing :");
		drive1.findElement(By.xpath("//I[@class='glyphicon glyphicon-send']")).click();
		TimeUnit.SECONDS.sleep(5);
		WebElement fileInput = drive1.findElement(By.name("files"));
		fileInput.sendKeys("C:/Users/David Yang/Pictures/2015-06/IMG_20150626_124643479.jpg");
		//driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[4]/div[1]/div[2]/div[1]/div/div[3]/div/div/div/form/div/input")).click();
		TimeUnit.SECONDS.sleep(13);
		drive1.findElement(By.xpath("//I[@class='glyphicon glyphicon-send']")).click();
		drive1.findElement(By.xpath("//A[@class='btn btn-default pull-right all-white-btn submit-button custom-short-button ']")).click();
		//drive1.findElement(By.xpath("//A[@class='btn btn-default pull-right btn-video all-white-btn submit-button custom-short-button']")).click();
		/*System.out.println("Call or Video?");
		String inputData2=scan1.nextLine();
		if(inputData2.equals("Call")) {
			drive1.findElement(By.xpath("//A[@class='btn btn-default pull-right all-white-btn submit-button custom-short-button ']")).click();
		}
		else if(inputData2.equals("Video")) {
			drive1.findElement(By.xpath("//A[@class='btn btn-default pull-right btn-video all-white-btn submit-button custom-short-button']")).click();
		}*/
	}
	public static void BroadCastSend(WebDriver drive1) throws InterruptedException {
		drive1.findElement(By.xpath("(//H4[@class='sidebar-image-align'])[3]")).click();
		TimeUnit.SECONDS.sleep(4);
		drive1.findElement(By.xpath("//SPAN[text()='Send broadcast']")).click();
		//WebElement fileInput=drive1.findElement(By.xpath("//DIV[@class='Select-placeholder'][text()='Select site(s)...']"));
		//fileInput.sendKeys(arg0);
		TimeUnit.SECONDS.sleep(3);
		drive1.findElement(By.xpath("//SPAN[@class='Select-arrow']")).click();;
		TimeUnit.SECONDS.sleep(1);
		drive1.findElement(By.className("Select-menu-outer")).click();
		drive1.findElement(By.xpath("//LABEL[@for='1939b705-2f09-11e5-9f58-025ba85b3601'][text()='Select all']")).click();
		drive1.findElement(By.xpath("(//TEXTAREA[@name='message'])[2]")).sendKeys("Testing");
		WebElement fileInput=drive1.findElement(By.name("files"));
		fileInput.sendKeys("C:/Users/David Yang/Pictures/2015-06/IMG_20150626_124643479.jpg");
		drive1.findElement(By.xpath("//*[@id=\"SendBroadcastsTab\"]/div[2]/form/div[2]/div[2]/label[4]")).click();
		drive1.findElement(By.xpath("(//SPAN[text()='Submit'][text()='Submit'])[2]")).click();
		TimeUnit.SECONDS.sleep(9);
		drive1.findElement(By.xpath("//BUTTON[@type='button'][text()='OK']")).click();
	}
}
