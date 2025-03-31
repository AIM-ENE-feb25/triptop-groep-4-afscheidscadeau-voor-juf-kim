public class FindNewBookingState implements State {
    @Override
    public void handle(Decider decider) {
        FindNewBooking findNewBooking = new FindNewBooking();
        findNewBooking.bookingReplacement();
        decider.setState(null);
    }
}