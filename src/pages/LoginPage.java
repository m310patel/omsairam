package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	/*WebElement email = driver.findElement(By.id("email"));
	WebElement password = driver.findElement(By.id("pass"));
	WebElement login = driver.findElement(By.name("login"));
	WebElement creatnewacc = driver.findElement(By.linkText("Create new account"));
	WebElement firstname = driver.findElement(By.name("firstname"));
	WebElement lastname =  driver.findElement(By.name("lastname"));
	WebElement phonenumber = driver.findElement(By.name("reg_email__"));
	WebElement newpassword = driver.findElement(By.name("reg_passwd__"));
	WebElement signin = driver.findElement(By.xpath("//button[@name='websubmit']"));
	WebElement findyouracc =  driver.findElement(By.linkText("Find your account and log in."));
	WebElement identifyemail =  driver.findElement(By.id("identify_email"));
	WebElement submit = driver.findElement(By.name("did_submit"));*/
	
	
	@FindBy(id= "email")
	public WebElement email;
	
	@FindBy(id = "pass")
	public WebElement password;
	
	@FindBy(name = "login")
	public WebElement login;
	
	@FindBy(linkText = "Create new account")
	public WebElement creatnewacc;
	
	@FindBy(name = "firstname")
	public WebElement firstname;
	
	@FindBy(name = "lastname")
	public WebElement lastname;
	
	@FindBy(name= "reg_email__")
	public WebElement phonenumber;
		
	@FindBy(name= "reg_passwd__")
	public WebElement newpassword;
	
	@FindBy(xpath= "//button[@name='websubmit']")
	public WebElement signin;
	
	@FindBy(linkText= "Find your account and log in.")
	public WebElement findyouracc;
	
	@FindBy(id= "identify_email")
	public WebElement identifyemail;
	
	@FindBy(name= "did_submit")
	public WebElement submit;
	
	
	
	public void OpenBrowser() throws IOException {
		
		FileInputStream f = new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
	    System.out.println("browser");
	   
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\SeleniumJars\\geckodriver.exe");
	 driver = new FirefoxDriver();

	    }else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		}else {
			System.setProperty("webdriver.safari.driver","C:\\SeleniumJars\\safaridriver.exe");
			 driver = new SafariDriver();
		}
		PageFactory.initElements(driver, this);
		}
	
	public void OpenLoginpage() {
		 driver.get("https://www.facebook.com/");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
	
	public void CloseBrowser() {
	
	     driver.quit();
	   }
	

	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		login.click();
		Thread.sleep(2000);
		
		findyouracc.click();
		identifyemail.sendKeys(a);
		submit.click();
		 
		 
		 }

	
   public String ReadEmailError() {
	String actualerror = driver.findElement(By.className("_9ay7")).getText();
	System.out.println(actualerror);
	return actualerror;

}
   public String ReadFindyourAccError () {
	   String actualerror = driver.findElement(By.xpath("//div[@class='pam uiBoxRed' or xpath='1']")).getText();
	     System.out.println(actualerror);
		return actualerror;
   }
   
   public void CreateNewAcc() throws InterruptedException {
       
	creatnewacc.click();
  	 Thread.sleep(2000);
  	firstname.sendKeys("hjikllll");
  	lastname.sendKeys("mhfgbvhfb");
  	phonenumber.sendKeys("2412253145");
  	newpassword.sendKeys("mjgbfrt");
  	signin.click();

}
   
   
   













}