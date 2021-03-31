package nl.getandgo.application.store;
import nl.getandgo.application.location.City;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class StoreService {
    public List<Store> storeList;
    public StoreService(){
       storeList=new ArrayList<>();
        storeList.add(new Store(1L,10051L,"Food King","ss", City.Eindohoven,"zzzz","xxxxxx","ssss"));
        storeList.add(new Store(2L,200054L,"sdDSf","asdaxvbjsd", City.Breda,"sdfstmkoiypdf","asdasd","asdasd"));
        storeList.add(new Store(3L,51184L,"sdFSDf","asdaxvbjsd", City.Tilburg,"sdfstmkoiypdf","asdasd","asdasd"));
        storeList.add(new Store(4L,5615L,"sFFSdf","asdaxvbjsd", City.Utrecht,"sdfstmkoiypdf","asdasd","asdasd"));
    }
    public List<Store> getStoreList(){return storeList;}
    public Store getStoreById(String id){
        for (Store s:storeList) {
            if(s.getStore_id().toString().equals(id)){
                return s;
            }
        }
        return null;
    }
    public List<Store> getStoresByOwnerId(String id){
        List<Store> temp=new ArrayList<>();
        for (Store s:storeList) {
            if(s.getStore_id().toString().equals(id)){
                temp.add(s);
            }
        }
        return temp;
    }
}
