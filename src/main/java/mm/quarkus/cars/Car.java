package mm.quarkus.cars;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
    
    @Id
    @GeneratedValue
    public long id;

    public String color;

    @Embedded
    public Tire tireType;

    
}
