package error;

public class Trying {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int maxAttempts = 3;
        for (int i = 0; i < maxAttempts; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                i = maxAttempts;
            } catch (RobotConnectionException e) {
                if (i == maxAttempts - 1) {
                    throw e;
                }
            }
        }
    }

}
