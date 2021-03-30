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
        storeList.add(new Store("asdasd","asdasdfsd", City.Eindohoven,"sdfhdhfgdhsdf","asdasd","asdasd"));
        storeList.add(new Store("asdddasd","asdasdfsd", City.Utrecht,"sdfbsdf","asdarsfsd","asdasd"));
        storeList.add(new Store("sdf","asdbvcxasd", City.Tilburg,"sdfbgfbksdf","asdasd","asdassdfsfd"));
        storeList.add(new Store("fd","asdsdfjghfjasd", City.Delft,"sdfikiksdf","asdasdfsd","asdasd"));
        storeList.add(new Store("sdf","asdaxvbjsd", City.Breda,"sdfstmkoiypdf","asdasd","asdasd"));
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
