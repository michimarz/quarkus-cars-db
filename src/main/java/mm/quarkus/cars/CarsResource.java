package mm.quarkus.cars;

import java.net.URI;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cars")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class CarsResource {
    
    @Inject
    CarRepository repository;

    @Inject
    Cars cars;

    @GET
    public List<Car> cars() {
        return cars.listAllCars();
    }

    @POST
    public Response create() {
        Car car = cars.createCar();
        return Response.created(URI.create("/cars/" + car.id)).build();
    }

    @GET
    @Path("tires-colors")
    public Set<TireColorCombination> findAllTireColorCombinations() {
        return cars.findAllTireColorCombinations();
    }
}
