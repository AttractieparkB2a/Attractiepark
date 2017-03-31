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

    @Override
    public boolean supports(Class<?> clazz) {
        return Subscriber.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Subscriber subscriber = (Subscriber) o;

        ValidationUtils.rejectIfEmpty(errors, "email", "NotEmpty", "Email may not be empty");

    }
}
