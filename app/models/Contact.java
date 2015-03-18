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

  /**
   * Builds a contact object.
   *
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The contact's telephone number.
   */
  public Contact(String firstName, String lastName, String telephone) {
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
}
