package database.dealership.demo.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Objects;
//import java.time.LocalDate;

@Data
@Getter
@Setter
@Entity
@Table(name = "buyer")
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String dob;
    private int acctNum;

    protected Customer() {
    }


    public Customer(String firstName, String lastName, String address, String dob, int acctNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dob = dob;
        this.acctNum = acctNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Customer that)) {
            return false;
        } else {

            return Objects.equals(this.firstName, that.firstName) && Objects.equals(this.lastName, that.lastName) && Objects.equals(this.address, that.address) && Objects.equals(this.dob, that.dob) && Objects.equals(this.acctNum, that.acctNum);
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, address, dob, acctNum);
    }
}
