//package nl.getandgo.application.store;
//import nl.getandgo.application.location.City;
//import org.springframework.stereotype.Service;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//public class StoreService {
//    public List<Store> storeList;
//    public StoreService(){
//       storeList=new ArrayList<>();
//        storeList.add(new Store(10051L,"Food King","ss", City.Eindohoven,"zzzz","xxxxxx","ssss"));
//        storeList.add(new Store(200054L,"sdDSf","asdaxvbjsd", City.Breda,"sdfstmkoiypdf","asdasd","asdasd"));
//        storeList.add(new Store(51184L,"sdFSDf","asdaxvbjsd", City.Tilburg,"sdfstmkoiypdf","asdasd","asdasd"));
//        storeList.add(new Store(5615L,"sFFSdf","asdaxvbjsd", City.Utrecht,"sdfstmkoiypdf","asdasd","asdasd"));
//    }
//    public List<Store> getStoreList(){return storeList;}
//    public Store getStoreById(String id){
//        for (Store s:storeList) {
//            if(s.getStore_id().toString().equals(id)){
//                return s;
//            }
//        }
//        return null;
//    }
//    public List<Store> getStoresByOwnerId(String id){
//        List<Store> temp=new ArrayList<>();
//        for (Store s:storeList) {
//            if(s.getStore_id().toString().equals(id)){
//                temp.add(s);
//            }
//        }
//        return temp;
//    }
//
//    public void addNewStore(Store data) {
//        storeList.add(new Store(data.getVendor_id(),data.getStore_name(),data.getDescription(),data.getCity(),data.getAddress(),data.getImg(),data.getOfficial_website()));
//        System.out.println("Add Store: "+data);
//    }
//}
