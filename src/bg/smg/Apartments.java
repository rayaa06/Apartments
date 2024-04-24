package bg.smg;

public class Apartments {
    private String city;
    private int rooms;
    private double kwadratura;
    private double price;
    private String phone;

    public Apartments(String city, int rooms, double kwadratura, double price, String phone) {
        this.city = city;
        this.rooms = rooms;
        this.kwadratura = kwadratura;
        this.price = price;
        this.phone = phone;
    }
    public Apartments() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getKwadratura() {
        return kwadratura;
    }

    public void setKwadratura(double kwadratura) {
        this.kwadratura = kwadratura;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
