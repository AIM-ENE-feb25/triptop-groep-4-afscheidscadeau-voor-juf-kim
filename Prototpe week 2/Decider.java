public class Decider {
    private State state;

    public void start() {
        setState(new BookingState());
        while (state != null) {
            state.handle(this);
        }
    }

    public void setState(State state) {
        this.state = state;
    }
}