package nl.getandgo.application.repository;

import nl.getandgo.application.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {

    @Query("SELECT s FROM Store s WHERE s.vendor.user_id=?1")
    List<Store> findStoresByVendor(Long vendor_id);

    @Query("FROM Store as st ORDER BY st.store_id desc ")
    List<Store> findAllSORTED();

    @Query("DELETE FROM Store s WHERE s.store_id=?1")
    @Modifying
    void deleteStore(Long id);
}
