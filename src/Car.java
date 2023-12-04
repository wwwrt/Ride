public class Car extends Component {
    private final int location;
    private final int distanceToLocation;

    public Car(Mediator mediator, int location, int distanceToLocation) {
        super(mediator);
        this.location = location;
        this.distanceToLocation = distanceToLocation;
    }

    public int getLocation() {
        return location;
    }

    public int getDistanceToLocation() {
        return distanceToLocation;
    }

    @Override
    public void sendNotification(String event) {
        mediator.notify(this, event);
    }
}
