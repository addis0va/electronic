public class Laptop extends Device{
    private String drives;
    private int ram;

    public Laptop(String type, double price, double weight, String processor, int ram) {
        super(type, price, weight);
        this.drives = drives;
        this.ram = ram;
    }

    public String getDrives() {
        return drives;
    }

    public int getRam() {
        return ram;
    }
}
