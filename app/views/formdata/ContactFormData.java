/**
 * The Play contact page backing class.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

/*
 * Public fields are allowed in a Play backing class.
 */

package views.formdata;

/**
 * The contact's vital information.
 */
public class ContactFormData {
  /** The first name. */
  public String firstName = "";

  /** The last name. */
  public String lastName = "";

  /** The telephone number. */
  public String telephone = "";

  /** The address. */
  public String address = "";
}
