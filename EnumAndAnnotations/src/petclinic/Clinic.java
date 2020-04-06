package petclinic;


import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Clinic implements Iterable<Pet> {
    private String name;
    //number of rooms in specific clinic
    private int clinicSize;
    //with this we won't need room class; because we need only number and pet
    private Map<Integer, Pet> petInRooms;


    public Clinic(String name, int clinicSize) {
        this.name = name;
        //validates for odd number of rooms in the clinic;
        this.setClinicSize(clinicSize);

        this.petInRooms = new LinkedHashMap<>();
        for (int roomNum = 1; roomNum <= clinicSize; roomNum++) {
            petInRooms.put(roomNum, null);
        }
    }


    public String getName() {
        return this.name;
    }


    public void setClinicSize(int clinicSize) {
        if (clinicSize % 2 == 0) {
            throw new UnsupportedOperationException("Invalid Operation!");
        }
        this.clinicSize = clinicSize;
    }

    //add pet into the clinic's room here in the Clinic class;

    public boolean addPetInClinic(Pet pet) {
        int centerRoom = clinicSize/2 + 1;

        for (int i = 0; i < centerRoom; i++) {
            if (petInRooms.get(centerRoom - i) == null) {
                petInRooms.put(centerRoom - i, pet);
                return true;

            }
            else if (petInRooms.get(centerRoom + i) == null) {
                petInRooms.put(centerRoom + i, pet);
                return true;
            }
        }
        return false;
    }
    //when release method is
    // called, we start
    // from the centre room (3) and continue
    // right (4, 5… and so on) until we find a
    // pet or reach the last room
    // . If we reach the
    // last room, we start
    // from the first (1)
    // and again move right
    // until we reach the centre room (3).

    public boolean releasePetFromClinic() {
        int centerRoom = clinicSize/2 + 1;
        for (int i = centerRoom; i <= clinicSize; i++) {

            if (petInRooms.get(i) != null) {
                petInRooms.put(i, null);
                return true;
            }
        }
        for (int i = centerRoom; i >= 1; i--) {
            if (petInRooms.get(i) != null) {
                petInRooms.put(i, null);
                return true;
            }

        }
        return false;
    }

    public boolean hasEmptyRooms() {
        final boolean[] emptyRooms = {false};
        //lambda func(foreach)
        this.petInRooms.forEach((key, value) -> {
            if (value == null) {
                emptyRooms[0] = true;
            }
        });
        return emptyRooms[0];
    }

    public void printSpecificRoom(int room) {
        this.petInRooms.entrySet().stream()
                .filter(e -> e.getKey() == room)
                .forEach(element ->
                {
                    if (element.getValue() != null) {
                        System.out.println(element.getValue().toString());
                    } else {
                        System.out.println("Room empty");
                    }
                });
    }

    public void printAllRooms() {
        //FOR EACH ROOM: NO FILTERING
        this.petInRooms.forEach((key, value) ->
        {
            if (value != null) {
                System.out.println(value.toString());
            } else {
                System.out.println("Room empty");
            }
        });

    }

    @Override
    public Iterator<Pet> iterator() {
        if (this.petInRooms.values().size() == 0) {
            return Collections.<Pet>emptyIterator();
        }
        return this.petInRooms.values().iterator();
    }


    @Override
    public void forEach(Consumer<? super Pet> action) {
        for (Pet pet : this.petInRooms.values()) {
            action.accept(pet);
        }
    }
}
