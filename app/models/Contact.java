/**
 * A single Contact for this Model-View-Controller application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

package models;

/**
 * A single contact for this application.
 */
public class Contact {

  private String firstName;
  private String lastName;
  private String telephone;
  private long id;

  /**
   * Builds a contact object.
   *
   * @param id The id number.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The contact's telephone number.
   */
  public Contact(long id, String firstName, String lastName, String telephone) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
  }


  /**
   * Get the first name.
   *
   * @return The first name.
   */
  public String getFirstName() {

    return firstName;
  }


  /**
   * Get the last name.
   *
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the telephone number.
   *
   * @return The phone number.
   */
  public String getTelephone() {
    return telephone;
  }


  /**
   * Get the ID number.
   *
   * @return The unique ID number for this contact.
   */
  public long getId() {
    return id;
  }
}
