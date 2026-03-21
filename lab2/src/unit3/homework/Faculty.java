package unit3.homework;

public class Faculty {
    private long id;
    private String name;
    private int availableSpots;

    public Faculty() {
    }

    public Faculty(long id, String name, int availableSpots) {
        this.id = id;
        this.name = name;
        this.availableSpots = availableSpots;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAvailableSpots() { return availableSpots; }
    public void setAvailableSpots(int availableSpots) { this.availableSpots = availableSpots; }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availableSpots=" + availableSpots +
                '}';
    }
}