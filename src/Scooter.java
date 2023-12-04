public class Scooter extends Component {
    private final int chargeLevel;

    public Scooter(Mediator mediator, int chargeLevel) {
        super(mediator);
        this.chargeLevel = chargeLevel;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    @Override
    public void sendNotification(String event) {
        mediator.notify(this, event);
    }
}
