import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://only-testing-blog.blogspot.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();		
		String title1=driver.getTitle();		
		System.out.println(title1);
		System.out.println(driver.getCurrentUrl());		
		Thread.sleep(3000); 	
		
		driver.findElement(By.xpath("//span[text()='Visit MyTest Page']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Visit Testing Page']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Blogger']")).click();
		Thread.sleep(6000);
		
		
		//WindowHandle
		Set<String> wh=driver.getWindowHandles();
		
		for(String i:wh)
		{
			String wTitle=driver.switchTo().window(i).getTitle();
			if(wTitle.equals("Blogger.com - Create a unique and beautiful blog easily."))
			{
				System.out.println(wTitle);
				break;
			}
			
		}
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Create your blog']")).click();
		
	//	driver.switchTo().defaultContent();
		
		
	}

}
