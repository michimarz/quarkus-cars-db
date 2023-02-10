package mm.quarkus.cars;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class Cars {

    @Inject
    CarRepository repository;

    public List<Car> listAllCars() {
        return repository.listAll();
    }

    @Transactional
    public Car createCar() {
        Car car = new Car();
        car.color = "yellow";
        car.tireType = new Tire(TireSpeedRating.Z, 205);

        repository.persist(car);
        return car;
    }
    
    public Set<TireColorCombination> findAllTireColorCombinations() {
        return repository.findTireColorCombinations();
    }
}
