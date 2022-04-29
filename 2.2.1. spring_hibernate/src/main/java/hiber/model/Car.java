package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "car")
public class Car implements Serializable {

    @OneToOne (mappedBy = "car")
    private User user;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car () {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return user.getFirstName() + " владеет машиной: " + model + "\nSerial равен: " + series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
