package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewOrderDTO;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.Order;
import nl.getandgo.application.model.Voucher;
import nl.getandgo.application.repository.UserRepository;
import nl.getandgo.application.repository.VoucherRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final UserRepository userRepository;
    private final VoucherRepository voucherRepository;

    /**
     * Adding New Order
     * */
    public String AddingNewOrder(NewOrderDTO newOrderDto){
        //1.Check User exist
        CustomerUser user=userRepository.findCustomerById(newOrderDto.getCustomer_id()).orElse(null);
        if(user==null){return "User not exist";}
        //2.Check Voucher exist
        Voucher voucher = voucherRepository.findById(newOrderDto.getVoucher_id()).orElse(null);
        if (voucher==null){return "Voucher not exist";}
        //3.Creating New Order
        Order order =new Order(newOrderDto.getEmail(),user,voucher.getProduct().getStore(), voucher.getProduct(),voucher);
        //4.Save Order
        user.addOrder(order);
        userRepository.save(user);
        return "Order Placed~!";
    }
}
