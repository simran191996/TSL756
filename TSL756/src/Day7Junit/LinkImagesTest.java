package Day7Junit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.BrowserSetup;

public class LinkImagesTest {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = BrowserSetup.browserStart("chrome");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://www.google.com");
		List<WebElement> alllink = driver.findElements(By.xpath("//a"));
		alllink.addAll(driver.findElements(By.tagName("img")));
		for (WebElement webElement : alllink) {
			String url = webElement.getAttribute("href");
			// getUrl(url);

			try {
				URL U = new URL(url);

				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.100.1", 8081));
				URLConnection c = U.openConnection(proxy);
				HttpURLConnection HC = (HttpURLConnection) c;
				HC.connect();
				int res = HC.getResponseCode();
				if (res == 200) {
					System.out.println(url + "working");
				} else {
					System.out.println(url + "not working");
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("error(mue)" + e.getMessage());
				// e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error(io)" + e.getMessage());

				// e.printStackTrace();
			}

		}

	}

	}
