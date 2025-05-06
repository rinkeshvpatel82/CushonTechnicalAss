package utils;

import com.microsoft.playwright.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightDriver {
  private static final ThreadLocal<Playwright> pw = new ThreadLocal<>();
  private static final ThreadLocal<Browser> br = new ThreadLocal<>();
  private static final ThreadLocal<Page> pg = new ThreadLocal<>();
  public static Page page;
  public static Properties prop;
  public static PlaywrightDriver playwrightDriver;
  private static final ThreadLocal<BrowserContext> bc = new ThreadLocal<>();
  Playwright playwright;
  Browser browser;
  private FileInputStream fis;

  public static Playwright getPlaywright() {
    return pw.get();
  }

  public static Browser getBrowser() {
    return br.get();
  }

  public static BrowserContext getBrowserContext() {
    return bc.get();
  }

  public static Page getPage() {
    return pg.get();
  }

  public static void setupDriver() {
    playwrightDriver = new PlaywrightDriver();
  }

  public static void openPage() {
    prop = playwrightDriver.init_prop();
    page = playwrightDriver.initBrowser(prop);
  }

  public static void closeBrowser() {
    getPage().close();
    getBrowser().close();
  }

  public static void quitPlaywright() {
    if (getPage() != null) {
      getPlaywright().close();
    }
  }

  public Page initBrowser(Properties prop) {
    String browserName = prop.getProperty("browser");
    System.out.println(browserName + " browser launch....!");
    pw.set(Playwright.create());
    switch (browserName.toLowerCase()) {
      case "chrome":
        br.set(
            getPlaywright()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
        break;
      case "firefox":
        br.set(
            getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
        break;
      case "safari":
        br.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));
        break;
      case "chromium":
        br.set(
            getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
        break;
      default:
        System.out.println("Please pass the right browser name.....");
        break;
    }
    bc.set(getBrowser().newContext());
    pg.set(getBrowserContext().newPage());
    getPage().navigate(prop.getProperty("testUrl").trim());
    return getPage();
  }

  public Properties init_prop() {
    try {
      fis = new FileInputStream("./src/main/resources/properties/config.properties");
      prop = new Properties();
      prop.load(fis);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return prop;
  }
}
