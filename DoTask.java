package trellopackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoTask {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ramya\\eclipse-workspace\\Trello_project\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// load the trello login page
		driver.navigate().to("https://trello.com/en/login");
		// Passing username details
		WebElement user = driver.findElement(By.id("user"));
		user.sendKeys("ramya1101998@gmail.com");

		// Logging in with Atlassian
		WebElement loginat = driver.findElement(By.xpath("//input[@id='login']"));
		loginat.submit();

		// Passing password and hit login button
		WebElement nxtpagepwd = driver.findElement(By.xpath("//input[@class='css-wxvfrp']"));
		nxtpagepwd.sendKeys("Kamakshi@1");
		WebElement LOGIN = driver.findElement(By.xpath("//span[text()='Log in']"));
		LOGIN.click();
		
		// Click the create menu present in the brand bar
		WebElement createbutton = driver.findElement(By.xpath("//button[@data-test-id=\"header-create-menu-button\"]"));
		createbutton.click();
		// Click create board option
		WebElement createboard = driver.findElement(By.xpath("//button[@data-test-id=\"header-create-board-button\"]"));
		createboard.click();
		// Entering the title of the board
		WebElement boardname = driver.findElement(By.xpath("//input[@data-test-id=\"create-board-title-input\"]"));
		boardname.sendKeys("Sampleboard");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //Hit the create button to create the board
		WebElement submitboard = driver.findElement(
				By.xpath("//button[@class=\"G2lWjDVJsvar3H Ts+YceGnvTbKoG HPCwi137Em5EYI JIXQq8gDYY04N6\"]"));
		submitboard.click();

		// Create a list and name it as List A
		WebElement createlistA = driver.findElement(By.className("list-name-input"));
		createlistA.sendKeys("List A");
		WebElement addlistA = driver.findElement(By.xpath("//input[@value=\"Add list\"]"));
		addlistA.click();
		Thread.sleep(2000);

		// Create another list and name it as List B
		WebElement createlistB = driver.findElement(By.className("list-name-input"));
		createlistB.sendKeys("List B");
		WebElement addlistB = driver.findElement(By.xpath("//input[@value=\"Add list\"]"));
		addlistB.click();
		Thread.sleep(2000);

		// Move to List A and add a card in it
		WebElement Addcard = driver.findElement(By.xpath("//*[@id=\"board\"]/div[1]/div/div[3]/a"));
		Addcard.click();
		WebElement cardtitle = driver
				.findElement(By.xpath("//textarea[@placeholder=\"Enter a title for this card…\"]"));
		cardtitle.sendKeys("Hello");
		WebElement addcardsubmit = driver.findElement(By.xpath("//input[@value='Add card']"));
		addcardsubmit.click();
		Thread.sleep(3000);

		// Finding the elements of source and destination
		WebElement source = driver.findElement(By.xpath("//span[@class=\"list-card-title js-card-name\"]"));
		WebElement target = driver.findElement(By.xpath("(//div[@class=\"list js-list-content\"])[2]"));
		// Do drag and drop using Action class.i.e. Drag and drop a created card in List B
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).build().perform();
		
		// Finding the xy coordinates using getlocation()
		WebElement getposition = driver.findElement(By.xpath("//div[@class=\"list-card-details js-card-details\"]"));
		Point xypoint = getposition.getLocation();
		int x = xypoint.getX();
		int y = xypoint.getY();
		System.out.println("X value =" + x);
		System.out.println("y value =" + y);

		//Open the user profile and give logout
		WebElement userprofile = driver.findElement(By.xpath("//span[@class=\"p6oJr7SHjK+vLr aqePx81u4BGHTH Glb3QqRGpd64YB\"]"));
		userprofile.click();
		WebElement logout=driver.findElement(By.xpath("//button[@data-test-id=\"header-member-menu-logout\"]"));
		logout.click();
		driver.findElement(By.id("logout-submit")).click();
	}

}
