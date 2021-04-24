package nl.getandgo.application.repository;

import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.ProductManagerUser;
import nl.getandgo.application.model.User;
import nl.getandgo.application.model.VendorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT v FROM VendorUser v WHERE v.user_id=?1 AND v.usertype='VENDORUSER'")
    Optional<VendorUser> findVendorById(Long id);

    @Query("SELECT c FROM CustomerUser c WHERE c.user_id=?1 AND c.usertype='CUSTOMERUSER'")
    Optional<CustomerUser> findCustomerById(Long id);

    @Query("SELECT m FROM ProductManagerUser m WHERE m.user_id=?1 AND m.usertype='ProductManagerUser'")
    Optional<ProductManagerUser> findManagerById(Long id);

    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findUserByEmail(String email);

}
