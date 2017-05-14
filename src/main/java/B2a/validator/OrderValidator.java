package B2a.validator;

import B2a.domain.ticket.Order;
import B2a.model.OrderModel;
import B2a.repository.OrderRepository;
import B2a.service.concreteService.OrderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class OrderValidator implements Validator {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return OrderModel.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderModel model = (OrderModel) target;

        //Check if atleast one ticket
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.totalPrice", "NotEmpty");
        if (model.getOrder().getTotalPrice() < 10) {
            errors.rejectValue("order.totalPrice", "Size.order.NoTicket");
        }


        //check if orderdate is afther today
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date d1 = c.getTime();

        //MODEL.DATE KOMT LEEG AAN
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order.date", "NotEmpty");
        if (model.getOrder().getDate() == null || d1.after(model.getOrder().getDate())) {
            errors.rejectValue("order.date", "Size.order.DateError");
        }
    }
}
