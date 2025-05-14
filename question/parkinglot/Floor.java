package question.parkinglot;

import java.util.*;

public class Floor {
    private final int number;
    private final List<Slot> slots = new ArrayList<>();

    public Floor(int number) {
        this.number = number;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public int getNumber() {
        return number;
    }
}