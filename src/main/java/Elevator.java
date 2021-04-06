import java.util.Collections;
import java.util.LinkedList;

public class Elevator {

    final LinkedList<Integer> peopleInElevator = new LinkedList<>();
    private final Building building;

    private boolean isMovingUp = true;
    private int currentFloor = 1;

    public Elevator(Building building) {
        this.building = building;
    }

    public void move(Printer printer) {

        while (true) {
            System.out.println("             ---   ***   ---");
            checkFloor(currentFloor);
            printer.printBuilding();
            if (isMovingUp) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkFloor(int numberOfFloor) {
        Floor floor = building.getFloor(numberOfFloor);
        checkIfPeopleInElevatorOutOnThisFlour(floor);
        checkMovementDirection(floor, numberOfFloor);
        // People getting in elevator by the FIFO order
        checkIfAnyOneInOnThisFloor(floor);
    }

    private void checkIfPeopleInElevatorOutOnThisFlour(Floor floor) {
        if (isMovingUp) {
            while (!peopleInElevator.isEmpty() && peopleInElevator.getFirst().equals(floor.numberOfFloor)) {
                peopleInElevator.removeFirst();
                floor.addHuman();
            }
        } else {
            while (!peopleInElevator.isEmpty() && peopleInElevator.getLast().equals(floor.numberOfFloor)) {
                peopleInElevator.removeLast();
                floor.addHuman();
            }
        }
    }

    private void checkIfAnyOneInOnThisFloor(Floor floor) {
        if (isMovingUp) {
            while (floor.isAnyOneUp() && !isFull()) {
                peopleInElevator.add(floor.takeHumanUp());
                // Maybe not a best way to do it!!!
                Collections.sort(peopleInElevator);
            }
        }
        if (!isMovingUp) {
            while (floor.isAnyOneDown() && !isFull()) {
                peopleInElevator.add(floor.takeHumanDown());
                // Maybe not a best way to do it!!!
                Collections.sort(peopleInElevator);
            }
        }
    }

    private void checkMovementDirection(Floor floor, int numberOfFloor) {
        //Check if on current floor majority of people going down and
        // set elevator's movement direction
        if (isEmpty()) {
            isMovingUp = !floor.isMajorityDown();
        }
        // Check if this is TOP floor, and if it is
        // change movement direction
        if (numberOfFloor == building.getFloors().length) {
            isMovingUp = false;
        }
        // Check if this is lowest ( 1st ) floor, and if it is
        // change movement direction
        if (numberOfFloor == 1) {
            isMovingUp = true;
        }
    }

    private boolean isFull() {
        return peopleInElevator.size() == 5;
    }

    private boolean isEmpty() {
        return peopleInElevator.size() == 0;
    }

    public boolean isMovingUp() {
        return isMovingUp;
    }


    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
