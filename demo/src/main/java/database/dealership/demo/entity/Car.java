package database.dealership.demo.entity;
import lombok.*;
import javax.persistence.*;
import java.util.Objects;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sedan")
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
//
//    public Car(String make, String model, double year) {
//        this.make = make;
//        this.model = model;
//        this.year = year;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long newId) {
//        this.id = newId;
//    }
//
//    public String getMake() {
//        return make;
//    }
//
//    public void setMake(String newMake) {
//        this.make = newMake;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String newModel) {
//        this.model = newModel;
//    }
//
//    public double getYear() {
//        return year;
//    }
//
//    public void setYear(double newYear) {
//        this.year = newYear;
//    }

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
        return Objects.hash(make, model);
    }

}
