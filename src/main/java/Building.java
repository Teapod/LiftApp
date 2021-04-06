public class Building {

    private final Floor[] floors;

    public Building() {
        int max = 20;
        int min = 5;
        int numberOfFloors = (int) ((Math.random() * (max - min)) + min);
        floors = new Floor[numberOfFloors];
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(i + 1, floors.length);
        }

    }

    public Floor[] getFloors() {
        return floors;
    }

    public Floor getFloor(int floor) { return floors[floor - 1];
    }
}
