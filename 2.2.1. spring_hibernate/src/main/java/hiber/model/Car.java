package hiber.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User addUser(User user) {
        this.user = user;
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(series, car.series);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, series);
    }


    @Override
    public String toString() {
        return "id= " + id +
                ", model= " + model +
                ", series= " + series;
    }


}
