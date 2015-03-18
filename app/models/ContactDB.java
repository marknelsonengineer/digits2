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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An in-memory, non-persistent repository for all Contact objects.
 */
public class ContactDB {

  static Map contacts = new HashMap<Long, Contact>();
  static long currentContactId = 1; // This is the next, unused Id number.


  /**
   * Return a contact object.
   *
   * @param id The ID number of the contact.
   * @return The contact object.
   */
  public static Contact getContact(long id) {
    Contact contact = (Contact) contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Attempt to retrieve invalid contact id");
    }

    return contact;
  }


  /**
   * Add a contact from an HTML form.
   *
   * @param contactView A container holding data entered into the form.
   * @return A contact object.
   */
  public static Contact addContactFromView(ContactFormData contactView) {
    Contact contact = null;
    if (contactView.id == 0) { // New Contact
      contact = new Contact(currentContactId++, contactView.firstName, contactView.lastName, contactView.telephone);
    }
    else { // Current contact
      contact = new Contact(contactView.id, contactView.firstName, contactView.lastName, contactView.telephone);
    }

    contacts.put(contact.getId(), contact);

    return contact;
  }


  /**
   * Return all of the contacts.
   *
   * @return A List of Contact objects.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }

}
