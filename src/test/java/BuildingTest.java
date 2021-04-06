import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BuildingTest {

    @Test
    void getFloors() {
        int min = 5;
        int max = 20;
        Building building = new Building();
        assertTrue(building.getFloors().length > min && building.getFloors().length < max);
    }

    @Test
    void getFloor() {
        Building building = new Building();
        assertNotNull(building.getFloor(3));
    }
}