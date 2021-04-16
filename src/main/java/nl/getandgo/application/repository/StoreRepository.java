package nl.getandgo.application.repository;
import nl.getandgo.application.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StoreRepository extends JpaRepository<Store,Long> {

}
