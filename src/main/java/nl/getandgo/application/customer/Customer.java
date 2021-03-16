package nl.getandgo.application.customer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Customer {

    @Id
    @JsonProperty("customer_id")
    @Getter
    private Long id;
    @NotBlank
    @Getter
    private String name;
    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Getter
    @NotBlank
    private String password;
    @Email
    @Getter
    private String email;

}
