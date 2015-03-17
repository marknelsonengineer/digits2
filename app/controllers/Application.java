/**
 * The Controller leg for this Model-View-Controller application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.NewContact;
import views.html.Home;


/**
 * Controllers for the application.
 */
public class Application extends Controller {

  /**
   * Application home page.
   *
   * @return HTTP OK with page content.
   */
  public static Result home() {
    return ok(Home.render("Home page successful."));
  }


  /**
   * New Contact page for the application.
   *
   * @return HTTP OK with page content.
   */
  public static Result newContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class);

    return ok(NewContact.render("New Contact page successful.", contactForm));
  }


  /**
   * Retrieve information from the newContact form and print it to the console.
   *
   * @return HTTP OK with page content.
   */
  public static Result postContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).bindFromRequest();
    ContactFormData contact = contactForm.get();

    System.out.printf("From newContact:  First: [%s]", contact.firstName);
    System.out.printf("  Last: [%s]", contact.lastName);
    System.out.printf("  Digits: [%s]", contact.telephone);
    System.out.printf("\n");

    return ok(NewContact.render("New Contact page successful.", contactForm));
  }

}
