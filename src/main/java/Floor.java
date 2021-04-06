import java.util.LinkedList;
import java.util.Queue;

public class Floor {
    final Queue<Integer> upGoingPeople = new LinkedList<>();
    final Queue<Integer> downGoingPeople = new LinkedList<>();
    final Integer numberOfFloor;
    private final int topFloorNumber;

    public Floor(int numberOfFloor, int topFloorNumber) {
        this.numberOfFloor = numberOfFloor;
        this.topFloorNumber = topFloorNumber;
        generatePeopleOnFloor();

    }

    private void humanRandom() {
        int humanGoingToWhichFloor;
        do {
            humanGoingToWhichFloor = (int) ((Math.random() * (topFloorNumber - 1)) + 1);
        } while (humanGoingToWhichFloor == numberOfFloor);

        if (humanGoingToWhichFloor > numberOfFloor) {
            upGoingPeople.add(humanGoingToWhichFloor);
        } else {
            downGoingPeople.add(humanGoingToWhichFloor);
        }
    }

    private void generatePeopleOnFloor() {
        int max = 10;
        int min = 0;
        int numberOfHumans = (int) ((Math.random() * (max - min)) + min);

        for (int i = 0; i < numberOfHumans; i++) {
            humanRandom();
        }
    }

    public void addHuman() {
        humanRandom();
    }

    public boolean isAnyOneUp() {
        return upGoingPeople.size() > 0;
    }

    public boolean isAnyOneDown() {
        return downGoingPeople.size() > 0;
    }

    public Integer takeHumanUp() {
        return upGoingPeople.poll();
    }

    public Integer takeHumanDown() {
        return downGoingPeople.poll();
    }

    public boolean isMajorityDown() {
        return downGoingPeople.size() > upGoingPeople.size();
    }

}
