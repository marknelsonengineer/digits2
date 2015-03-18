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
