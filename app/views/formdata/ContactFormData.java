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

import models.Contact;
import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;

/**
 * The contact's vital information.
 */
public class ContactFormData {
  private static final int TELEPHONE_NUMBER_LENGTH = 3;

  /** The first name. */
  public String firstName = "";

  /** The last name. */
  public String lastName = "";

  /** The telephone number. */
  public String telephone = "";

  /** A unique ID number. */
  public long id;

  /**
   * No-arg constructor requred by Play.
   *
   */
  public ContactFormData() {
    // Empty.
  }


  /**
   * Build a ContactFormData backing class from a model Contact object.
   *
   * @param contact A Contact object from the model.
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.id = contact.getId();
  }

  /**
   * Check ContactForm for invalid data.
   *
   * @return Null if no errors, otherwise a list of ValidationErrors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() <= 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }

    if (lastName == null || lastName.length() <= 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }

    if (telephone == null || telephone.length() <= 0) {
      errors.add(new ValidationError("telephone", "A telephone number is required."));
    }

    if (telephone == null || telephone.length() <= TELEPHONE_NUMBER_LENGTH) {
      errors.add(new ValidationError("telephone",
          "The telephone number must be at least " + TELEPHONE_NUMBER_LENGTH + " digits long."));
    }

    return errors.isEmpty() ? null : errors;
  }

}
