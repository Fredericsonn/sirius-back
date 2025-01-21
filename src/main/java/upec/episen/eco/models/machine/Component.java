package upec.episen.eco.models.machine;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@Entity
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "component", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Matter> matters;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    public Component() {}


    public Component(String name, Set<Matter> matters) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Component name cannot be null or empty");
        }
        if (matters == null) {
            throw new IllegalArgumentException("Matters list cannot be null");
        }
        this.name = name;
        this.matters =matters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Component name cannot be null or empty");
        }
        this.name = name;
    }


        public void setMatters(Set<Matter> matters) {
        if (matters == null) {
            throw new IllegalArgumentException("Matters list cannot be null");
        }
        this.matters = matters;
    }


    public void addMatter(Matter matter) {
        if (matter == null) {
            throw new IllegalArgumentException("Matter cannot be null");
        }
        matters.add(matter);
    }


    public boolean removeMatter(Matter matter) {
        return matters.remove(matter);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matters=" + matters +
                '}';
    }
}