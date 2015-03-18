/**
 * The Controller leg for this Model-View-Controller application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

package controllers;

import models.Contact;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.NewContact;
import views.html.Home;

import java.util.List;


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
    List<Contact> contacts = ContactDB.getContacts();

    return ok(Home.render(contacts));
  }


  /**
   * New Contact page for the application.
   *
   * @param id The ID number of the contact to create or 0 for new contact.
   * @return HTTP OK with page content.
   */
  public static Result newContact(long id) {

    ContactFormData contactFormData = null;

    if (id == 0) {
      contactFormData = new ContactFormData();
    }
    else {
      contactFormData = new ContactFormData(ContactDB.getContact(id));
    }

    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).fill(contactFormData);

    return ok(NewContact.render("New Contact page successful.", contactForm));
  }


  /**
   * Retrieve information from the newContact form and print it to the console.
   *
   * @return HTTP OK with page content.
   */
  public static Result postContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).bindFromRequest();

    if (contactForm.hasErrors()) {
      System.out.printf("Error in newContact page.\n");
      return badRequest(NewContact.render("Error in newContact page.", contactForm));
    }

    ContactFormData contact = contactForm.get();

    ContactDB.addContactFromView(contact);

    System.out.printf("From newContact:  First: [%s]", contact.firstName);
    System.out.printf("  Last: [%s]", contact.lastName);
    System.out.printf("  Digits: [%s]", contact.telephone);
    System.out.printf("\n");

    return ok(NewContact.render("New Contact page successful.", contactForm));
  }

}
