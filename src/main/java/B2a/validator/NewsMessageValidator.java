package B2a.validator;

import B2a.domain.newsMessage.NewsMessage;
import B2a.repository.NewsMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class NewsMessageValidator implements Validator {

    @Autowired
    NewsMessageRepository newsMessageRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewsMessage.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "subject", "not.empty");

        ValidationUtils.rejectIfEmpty(errors, "message", "not.empty");
    }
}
