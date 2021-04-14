package nl.getandgo.application.user;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@NoArgsConstructor
@Entity
@Table(name = "managers")
public class ProductManagerUser extends User{

}
