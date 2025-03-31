import java.util.Random;

public class BookingState implements State {
    @Override
    public void handle(Decider decider) {
        Booking booking = new Booking();
        Random random = new Random();
        if (random.nextBoolean()) {
            booking.book();
            decider.setState(null);
        } else {
            System.out.println("No room available");
            decider.setState(new FindNewBookingState());
        }
    }
}