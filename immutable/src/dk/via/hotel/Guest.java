package dk.via.hotel;

public class Guest {
    private String name;

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Guest.class) {
            return false;
        }
        Guest other = (Guest) obj;
        return name.equals(other.name);
    }
}
