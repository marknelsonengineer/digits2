/**
 * An in-memory, non-persistent repository for all Contact objects.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * An in-memory, non-persistent repository for all Contact objects.
 */
public class ContactDB {

  static List contacts = new ArrayList<Contact>();

  /**
   * Add a contact from an HTML form.
   *
   * @param contactView A container holding data entered into the form.
   * @return A contact object.
   */
  public static Contact addContactFromView(ContactFormData contactView) {
    Contact contact = new Contact(contactView.firstName, contactView.lastName, contactView.telephone);

    contacts.add(contact);

    return contact;
  }

  /**
   * Return all of the contacts.
   *
   * @return A List of Contact objects.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }

}
