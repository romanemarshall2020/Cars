package database.dealership.demo.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Objects;
@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sedan")
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;
    private double year;

//    protected Car() {
//    }
//

    public Car(String make, String model, double year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car that)) {
            return false;
        } else {

            return Objects.equals(this.make, that.make) && Objects.equals(this.model, that.model) && Objects.equals(this.year, that.year);
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year);
    }

}
