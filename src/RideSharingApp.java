import java.util.ArrayList;
import java.util.List;

public class RideSharingApp implements Mediator {
    private final List<Car> cars;
    private final List<Scooter> scooters;

    public RideSharingApp() {
        cars = new ArrayList<>();
        scooters = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addScooter(Scooter scooter) {
        scooters.add(scooter);
    }

    public List<Car> findClosestAvailableCars(int clientLocation) {
        List<Car> availableCars = new ArrayList<>();

        // find the closest 3 cars that are not already in another trip
        for (Car car : cars) {
            if (car.getDistanceToLocation() > 0 && car.getDistanceToLocation() <= 100 && !isCarInTrip(car)) {
                availableCars.add(car);

                if (availableCars.size() == 3) {
                    break;
                }
            }
        }

        return availableCars;
    }

    private boolean isCarInTrip(Car car) {
        return false;
    }

    public List<Scooter> findValidScooters(int clientLocation, int tripDistance) {
        List<Scooter> validScooters = new ArrayList<>();

        // find the valid scooters based on charge level and trip distance
        for (Scooter scooter : scooters) {
            if (scooter.getChargeLevel() >= tripDistance * 0.5 && scooter.getChargeLevel() >= tripDistance) {
                validScooters.add(scooter);
            }
        }

        return validScooters;
    }

    @Override
    public void notify(Component sender, String event) {
    }
}
