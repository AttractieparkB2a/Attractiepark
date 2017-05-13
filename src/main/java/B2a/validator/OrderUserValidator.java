package B2a.validator;


import B2a.domain.User;
import B2a.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class OrderUserValidator implements Validator {
    private final UserService userService;

    @Autowired
    public OrderUserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.order.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
        if (user.getFirstName().length() < 2) {
            errors.rejectValue("firstName", "Size.order.firstname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
        if (user.getLastName().length() < 2) {
            errors.rejectValue("lastName", "Size.order.lastname");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
        if (user.getAddress().length() < 2) {
            errors.rejectValue("address", "Size.order.address");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty");
        if (user.getCity().length() < 2) {
            errors.rejectValue("city", "Size.order.city");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipcode", "NotEmpty");
        if (user.getZipcode().length() < 6) {
            errors.rejectValue("zipcode", "Size.order.zipcode");
        }
    }
}
