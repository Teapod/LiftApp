public class LiftApp {
    public static void main(String[] args) {

        Building building = new Building();
        Elevator elevator = new Elevator(building);
        Printer printer = new Printer(building, elevator);
        printer.printBuilding();
        elevator.move(printer);

    }
}
