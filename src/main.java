import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        runType.initialize();
    }
    public static void reRun() throws IOException {
        shipNamesCalculator shipNames = new shipNamesCalculator(runType.getName1(), runType.getName2(), runType.getComputeType());
        shipNames.run();
    }


}
