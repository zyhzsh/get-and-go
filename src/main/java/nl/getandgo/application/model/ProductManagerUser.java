package nl.getandgo.application.model;

import lombok.NoArgsConstructor;
import lombok.ToString;
import nl.getandgo.application.model.User;

import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@NoArgsConstructor
@Entity(name = "ProductManagerUser")
@Table(name = "managers")
public class ProductManagerUser extends User {

}
