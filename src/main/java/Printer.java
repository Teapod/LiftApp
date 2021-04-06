import java.util.LinkedList;

public class Printer {
    private final Building building;
    private final Elevator elevator;

    public Printer(Building building, Elevator elevator) {
        this.building = building;
        this.elevator = elevator;
    }

    public void printBuilding() {
        for (int i = building.getFloors().length; i > 0; i--) {
            System.out.print("floor ");
            if (i < 10) {
                System.out.print(i + "  |");
            } else {
                System.out.print(i + " |");
            }
            printElevator(i);
            System.out.print("| ");
            System.out.print(building.getFloor(i).upGoingPeople);
            System.out.print(" ^ ||  V ");
            System.out.print(building.getFloor(i).downGoingPeople);
            System.out.println();
        }
    }

    private void printElevatorDirection() {
        if (elevator.isMovingUp()) {
            System.out.print(" ^ ");
        } else {
            System.out.print(" V ");
        }
    }

    private void printElevator(int currentFloorToPrint) {
        if (elevator.getCurrentFloor() == currentFloorToPrint) {
            LinkedList<Integer> listToPrint = new LinkedList<>(elevator.peopleInElevator);
            printElevatorDirection();
            for (int i = 0; i < 5; i++) {
                if (listToPrint.peekFirst() != null) {
                    if (listToPrint.peekFirst() < 10) {
                        System.out.print(0);
                    }
                    System.out.print(listToPrint.poll());
                    System.out.print(",");

                } else System.out.print("   ");
            }
            printElevatorDirection();
        } else System.out.print("                     ");
    }
}
