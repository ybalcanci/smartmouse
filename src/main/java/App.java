import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;

public class App extends NanoHTTPD {

    public App() throws IOException {
        super(8080);
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
    }

    public static void main(String[] args) {
        try {
            new App();
        } catch (IOException ioe) {
            System.err.println("Couldn't start server:\n" + ioe);
        }
    }

    @Override
    public Response serve(IHTTPSession session) {
        session.getParameters();
        int x =  Integer.parseInt(session.getParameters().get("x").get(0));
        int y =  Integer.parseInt(session.getParameters().get("y").get(0));
        int leftClick =  Integer.parseInt(session.getParameters().get("leftClick").get(0));
        int rightClick =  Integer.parseInt(session.getParameters().get("rightClick").get(0));
        MouseController.getInstance().moveMouse(x, y);
        
        System.out.println(x);
        return newFixedLengthResponse("ok");
    }

}
