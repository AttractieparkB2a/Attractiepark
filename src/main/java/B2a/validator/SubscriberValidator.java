package B2a.validator;

import B2a.domain.Subscriber;
import B2a.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SubscriberValidator implements Validator {

    @Autowired
    SubscriberRepository subscriberRepository;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean supports(Class<?> clazz) {
        return Subscriber.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Subscriber subscriber = (Subscriber) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "not.empty");

        if(!subscriber.getEmail().matches(EMAIL_PATTERN))
            errors.rejectValue("email", "incorrect.email");
    }
}
