package android.saikiranpro.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import android.saikiranpro.test.Helper;

public class HomePage extends Helper {

	WebDriver driver;
	
	@Test
	public void runMinimalCalculations() throws Exception {
		
//		this.driver = setUpAndroidDriver("1.8.1","1e54fcea","com.android.calculator2",".Calculator");
		this.driver = setUpAndroidDriver("1.8.1","1e54fcea","in.amazon.mShop.android.shopping","com.amazon.mShop.android.home.HomeActivity");
//		sumOfTwoNumbers();
		WebElement burgerIcon = driver.findElement(By.className("android.widget.ImageView"));
		burgerIcon.click();
	}

	/**
	 * @author saikirannataraja
	 * @see returns sum of two numbers
	 */
	@SuppressWarnings("unused")
	private void sumOfTwoNumbers() {
		// locate the Text on the calculator by using By.name()
		WebElement two = driver.findElement(By.xpath("//android.widget.Button[@text='2']"));
		two.click();
		WebElement plus = driver.findElement(By.xpath("//android.widget.Button[@text='+']"));
		plus.click();
		WebElement four = driver.findElement(By.xpath("//android.widget.Button[@text='4']"));
		four.click();
		WebElement equalTo = driver.findElement(By.xpath("//android.widget.Button[@text='=']"));
		equalTo.click();
		// locate the edit box of the calculator by using By.tagName()
		WebElement results = driver.findElement(By.xpath("//android.widget.TextView[@index='2']"));
		// Check the calculated value on the edit box
		assert results.getText().equals("6") : "Actual value is : " + results.getText() +" did not match with expected value: 6";
	}

}
