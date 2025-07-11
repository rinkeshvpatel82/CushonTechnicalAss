package stepDefs;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.nio.file.Paths;
import java.util.Properties;
import utils.PlaywrightDriver;

public class Hooks {

  Page page;
  @Before
  public void setup() {
    PlaywrightDriver.setupDriver();
    PlaywrightDriver.openPage();
  }

  @After
  public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
      page = PlaywrightDriver.getPage();
      byte[] screenshot =
          page.screenshot(
              new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/screenshot.png")));
      scenario.attach(screenshot, "image/png", "screenshot");
    }
    PlaywrightDriver.closeBrowser();
    PlaywrightDriver.quitPlaywright();
  }
}
