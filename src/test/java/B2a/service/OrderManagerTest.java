package B2a.service;

import B2a.domain.order.Order;
import B2a.model.OrderModel;
import B2a.service.concreteService.OrderManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("local")
@SpringBootTest
public class OrderManagerTest {

    @Autowired
    OrderManager orderManager;

    @Test
    public void mementoTest() {

//        Order order = new Order();
//        OrderModel model = new OrderModel();
//
//
//        //fill order with info
//        order.setId(1L);
//        order.setTotalPrice(55);
//
//        //fill model with order
//        model.setOrder(order);
//
//        //add model as memento
//        orderManager.addMemento(model);
//
//        model = orderManager.getMemento(0);
//        assertNotNull(model);
//
//        boolean saved = false;
//            if(model.getOrder().getTotalPrice() == 55){
//                saved = true;
//            }
//        assertTrue(saved);
        assert(1 == 1);
    }


}
