import java.util.List;

public class Main implements FilteringCondition{

    public static void main(String[] args) {

        HotelService hs = new HotelService();

        //Lambda -> 1
        List<Hotel> l1 = hs.filterHotels(
                (hotel -> hotel.getPricePerNight() <= 2000));
        System.out.println(l1);

        //Anonymous inner class -> 2
        List<Hotel> l2 = hs.filterHotels(new FilteringCondition() {
            @Override
            public boolean test(Hotel hotel) {
                return hotel.getPricePerNight() <= 2000;
            }
        });
        System.out.println(l2);

        List<Hotel> l3 = hs.filterHotels(new Main());
        System.out.println(l3);
    }

    //Implement interface and override method -> 3
    @Override
    public boolean test(Hotel hotel) {
        return hotel.getPricePerNight() <= 2000;
    }


}
