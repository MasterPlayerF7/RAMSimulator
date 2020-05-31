package control;

import model.Process;
import model.RAM;

import java.util.Random;

public class Controller {

    private static final int RAM_SLOTS = 100;

    private Random random;

    private RAM ram;

    public Controller() {
        this.ram = new RAM(RAM_SLOTS);
        this.random = new Random();
        this.init();
    }

    private void init() {
        model.Process process;
        while (ram.getRamSlots().size() >= 100) {
            if (random.nextInt(RAM_SLOTS) == 0 && (process = ram.execute()) != null)
                System.out.println(process);
            else if (random.nextInt(RAM_SLOTS) < 10 && ram.getProcesses().size() < 20)
                ram.addProcess(new Process(random.nextInt(RAM_SLOTS),
                        random.nextInt(100)));
        }
    }
}
