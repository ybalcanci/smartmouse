import java.awt.*;

public class MouseController {
    private static MouseController instance;

    static {
        try {
            instance = new MouseController();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private Robot robot = new Robot();
    private MouseController() throws AWTException {}

    public static MouseController getInstance() {
        return instance;
    }

    public void moveMouse(int increaseX, int increaseY){
        Point mousePosition;
        mousePosition = MouseInfo.getPointerInfo().getLocation(); // current position of cursor
        robot.mouseMove(mousePosition.x + increaseX, mousePosition.y + increaseY); // move the cursor
    }
}
