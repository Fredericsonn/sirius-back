package upec.episen.eco.models.User;

import java.util.Set;

import jakarta.persistence.*;
import upec.episen.eco.models.machine.Machine;

@Entity
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Machine> machines;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Collection() {
    }

    public Collection(String name, Set<Machine> machines, User user) {
        this.name = name;
        this.machines = machines;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Machine> getMachines() {
        return machines;
    }

    public void setMachines(Set<Machine> machines) {
        this.machines = machines;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Collection [id=" + id + ", name=" + name + ", machines=" + machines + ", user=" + user + "]";
    }
}
