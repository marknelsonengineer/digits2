/**
 * Unit tests for the Application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see http://junit.org
 * @see https://www.playframework.com
 */

package test;

import models.Contact;
import models.ContactDB;
import org.junit.Test;
import play.twirl.api.Content;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;


/**
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 */
public class ApplicationTest {

  /**
   * Pre-test to ensure that the testing framework is working correctly.
   */
  @Test
  public void simpleCheck() {
    int a = 1 + 1;
    assertThat(a).isEqualTo(2);
  }


  /**
   * Exercise rendering the Home page.  Specifically, make sure that content passed into render appears on the page.
   */
  @Test
  public void renderTemplate() {
    List<Contact> contacts = ContactDB.getContacts();

    Content html = views.html.Home.render(contacts);
    assertThat(contentType(html)).isEqualTo("text/html");
  }


  /**
   * Ensure Bootstrap is properly configured.
   */
  @Test
  public void renderBootstrapTest() {
    List<Contact> contacts = ContactDB.getContacts();

    Content html = views.html.Home.render(contacts);
    assertThat(contentAsString(html)).contains("bootstrap.min.css");  // To Do: Make sure the URL targets are good.
    assertThat(contentAsString(html)).contains("jquery.min.js");
    assertThat(contentAsString(html)).contains("bootstrap.min.js");
  }


  /**
   * Ensure Google Fonts are available.
   */
  @Test
  public void renderGoogleFontsTest() {
    List<Contact> contacts = ContactDB.getContacts();

    Content html = views.html.Home.render(contacts);
    assertThat(contentAsString(html)).contains("fonts.googleapis.com");  // To Do: Make sure the URL targets are good.
  }


  /**
   * Ensure the navigation bar is fully represented.
   */
  @Test
  public void renderNavbarTest() {
    List<Contact> contacts = ContactDB.getContacts();

    Content html = views.html.Home.render(contacts);
    assertThat(contentAsString(html)).contains("<a href=\"/\">Home</a>");
    assertThat(contentAsString(html)).contains("<a href=\"/contact\">New Contact</a>");
  }

}
