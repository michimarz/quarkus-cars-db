package mm.quarkus.cars;

import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {
    public Set<TireColorCombination> findTireColorCombinations() {
        return getEntityManager().createQuery("""
                SELECT new mm.quarkus.cars.TireColorCombination(
                    c.tireType, c.color)
                FROM Car c
                """, TireColorCombination.class).getResultStream()
                .collect(Collectors.toSet());
    }
}