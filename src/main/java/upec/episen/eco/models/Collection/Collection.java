package upec.episen.eco.models.Collection;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import upec.episen.eco.models.machine.Machine;

@Entity
@Table(name = "collection")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "collection_id")
    private List<Machine> collectionList;

    public Collection(String n, List<Machine> c){
        this.collectionList=c;
        this.name=n;

    }
    public Collection(){};

    public void SetCollectionList(List<Machine> c){
        this.collectionList=c;
    }

    public List<Machine> getCollectionList(){
        return this.collectionList;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void insertMachine(Machine m){
        this.collectionList.add(m);
    }




    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", machineList=" + collectionList +
                '}';
    }

    
}
