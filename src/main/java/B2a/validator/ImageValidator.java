package B2a.validator;

import B2a.domain.image.UserImage;
import B2a.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ImageValidator implements Validator {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserImage.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserImage userImage = (UserImage) o;

        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty", "Name may not be empty");

        if(userImage.getFile() != null && userImage.getFile().isEmpty())
            errors.rejectValue("file", "file.empty", "File may not be empty");
    }
}
