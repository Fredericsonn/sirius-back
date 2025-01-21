package upec.episen.eco.models.machine;

import jakarta.persistence.*;

@Entity
public class Matter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String value;
    @Column
    private double volume;

    @ManyToOne
    private Component component;

    public Matter(String value, double volume) {
        this.value = value;
        this.volume = volume;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Matter{" +
                "value=" + value +
                ", volume=" + volume +
                '}';
    }
}