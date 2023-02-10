package mm.quarkus.cars;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;

import static javax.persistence.EnumType.STRING;

@Embeddable
public record Tire(@Enumerated(STRING) @Basic(optional = false) TireSpeedRating speedRating, 
                    @Basic(optional = false) int width) {
    
    public Tire() {
        this(null, 0);
    }
    
}

