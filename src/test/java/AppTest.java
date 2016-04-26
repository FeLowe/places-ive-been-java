import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Places I have been");
  }

  @Test
public void placeIsCreatedTest() {
  goTo("http://localhost:4567/");
  fill("#place").with("Costa Rica");
  submit(".btn");
  assertThat(pageSource()).contains("Your place has been saved.");
}
@Test
public void placeIsDisplayedTest() {
  goTo("http://localhost:4567/");
  fill("#place").with("New York");
  submit(".btn");
  click("a", withText("Go Back"));
  assertThat(pageSource()).contains("New York");
}
@Test
public void multipleTasksAreDisplayedTest() {
  goTo("http://localhost:4567/");
  fill("#place").with("Florida");
  submit(".btn");
  click("a", withText("Go Back"));
  fill("#place").with("Mexico");
  submit(".btn");
  click("a", withText("Go Back"));
  assertThat(pageSource()).contains("Florida");
  assertThat(pageSource()).contains("Mexico");
}

}
