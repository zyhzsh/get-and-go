package nl.getandgo.application.repository;

import nl.getandgo.application.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query("SELECT o FROM Order o WHERE o.store.store_id=?1 and o.createdAt >= ?2 and o.createdAt<= ?3 order by o.createdAt asc ")
    List<Order> findOrderByStore_idAndCreatedAtBetween(Long store_id,LocalDateTime star,LocalDateTime end);
}
