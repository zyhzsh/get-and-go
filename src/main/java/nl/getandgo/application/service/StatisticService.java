package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.StatisticStoreOrderTurnOverDTO;
import nl.getandgo.application.model.Order;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.repository.OrderRepository;
import nl.getandgo.application.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final StoreRepository storeRepository;
    private final OrderRepository orderRepository;

    /**
    * Obtain the order statistics of all stores under the Vendor's name for the past six months
     * Note: this converting process still need be improved later.
    * */
    public List<StatisticStoreOrderTurnOverDTO> getOrderOverTurnLastHalfYear(Long vendor_id){

       LocalDateTime star=LocalDateTime.now().plusMonths(-6);
       LocalDateTime end=LocalDateTime.now();

        List<Order> orders=new ArrayList<>();
        List <StatisticStoreOrderTurnOverDTO> list=new ArrayList<>();
        //1.get data form database
        //Step 1:Store List
        List<Store> stores=storeRepository.findStoresByVendor(vendor_id);
        List<StatisticStoreOrderTurnOverDTO> data=new ArrayList<>();
        //Step 2：Get Order List By Store
        for (Store s : stores){
            //Get Raw Order List By store
            orders.addAll(orderRepository.findOrderByStore_idAndCreatedAtBetween(s.getStore_id(),star,end));
            for (Order o: orders){
                //when list is empty
                 if (list.isEmpty()){list.add(new StatisticStoreOrderTurnOverDTO(o.getStore().getStore_name(),o.getCreatedAt().getMonthValue(),1));continue;}
                //when list not empty
                 for (int i=0;i<list.size();i++){
                     //when the store list name are not same
                     if(s.getStore_name()!=list.get(i).getStore_name()){
                         if(!checkNameOnTheList(list,s.getStore_name())){
                             list.add(new StatisticStoreOrderTurnOverDTO(o.getStore().getStore_name(),o.getCreatedAt().getMonthValue(),1));continue;
                         }
                     }
                     //if (month) == (month) , perform quantity + 1
                     if(s.getStore_name()==list.get(i).getStore_name()){
                         if (o.getCreatedAt().getMonthValue()==list.get(i).getMonth()&&o.getStore().getStore_name()==s.getStore_name()){list.get(i).setQuantity(list.get(i).getQuantity()+1); break;}
                         //if (month)!=(month), then creating new record
                         list.add(new StatisticStoreOrderTurnOverDTO(o.getStore().getStore_name(),o.getCreatedAt().getMonthValue(),1));break;
                     }
                 }
             }
             data.addAll(list);
             list.clear();
             orders.clear();
        }
        return data;
    }

    public String getOrderOverTurnLastHalfYearText(Long vendor_id){
        String result="[";
        List<StatisticStoreOrderTurnOverDTO> temp=getOrderOverTurnLastHalfYear(vendor_id);
        if (temp.isEmpty()){ return  "[]";}
        for (int i=0;i<temp.size();i++)
        {
          result=result+'{'+"\""+"store_name"+"\""+":"+"\""+temp.get(i).getStore_name()+"\""+",";
          result=result+"\""+"month"+"\""+":"+"\""+temp.get(i).getMonth()+"\""+",";
          result=result+"\""+"quantity"+"\""+":"+"\""+temp.get(i).getQuantity()+"\""+"}";
          if(i!=temp.size()-1){result+=",";}
        }
        result+="]";
        return result;
    }


    /**
     * Temporary method for covert data structure use
     * */
    private boolean checkNameOnTheList(List<StatisticStoreOrderTurnOverDTO> list,String name){
        if (list.isEmpty()){return false;}
        for (StatisticStoreOrderTurnOverDTO o: list) {
            if(o.getStore_name()==name){
                return true;
            }
        }
        return false;
    }



}
