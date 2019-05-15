package dk.via.hotel;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms.clone();
    }


    public String getName() {
        return name;
    }

    public int getNumberOfRooms() {
        return rooms.length;
    }

    private Stream<Room> availableRooms() {
        return Stream.of(rooms)
                .filter(room -> !room.isOccupied());
    }

    public int getNumberOfAvailableRooms() {
        return (int) availableRooms().count();
    }

    public Room getFirstAvailableRoom() {
        return availableRooms()
                .findFirst()
                .orElse(null);
    }

    public Room getFirstAvailableRoom(double maxPrice) {
        return availableRooms()
                .filter(room -> room.getPrice() <= maxPrice)
                .findFirst()
                .orElse(null);
    }

    public List<Room> getAllAvailableRooms() {
        return availableRooms().collect(toList());
    }

    public boolean hasGuest(Guest guest) {
        return Stream.of(rooms)
                .filter(Room::isOccupied)
                .anyMatch(room -> room.getGuest().equals(guest));
    }

    public Room getRoom(Guest guest) {
        return Stream.of(rooms)
                .filter(Room::isOccupied)
                .filter(room -> room.getGuest().equals(guest))
                .findFirst()
                .orElse(null);
    }
}
