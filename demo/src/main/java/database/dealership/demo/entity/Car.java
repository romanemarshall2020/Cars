package database.dealership.demo.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Objects;
@Data
@Getter
@Setter
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
    private long vin;
    private String color;

    // the value of protected classes can not be changed, but can be used outside of their classes
    protected Car() {
    }
//

    // Basically determines the structure of the data you are querying
    public Car(String make, String model, double year, long vin, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.color = color;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car that)) {
            return false;
        } else {

            return Objects.equals(this.make, that.make) && Objects.equals(this.model, that.model) && Objects.equals(this.year, that.year) && Objects.equals(this.vin, that.vin) && Objects.equals(this.color, that.color);
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year, vin, color);
    }

}
