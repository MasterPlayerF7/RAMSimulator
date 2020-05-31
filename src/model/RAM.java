package model;

import java.util.*;

public class RAM {

    private Random random;

    private ArrayList<RAMSegment> ramSegments;
    private TreeSet<Process> processes;

    private int ramSlots;

    public RAM(int ramSlots) {
        this.ramSlots = ramSlots;
        this.random = new Random();
        this.ramSegments = new ArrayList<>();
        this.processes = new TreeSet<>(Comparator.comparingInt(Process::getProcessID));
        this.createRAM();
    }

    public void addProcess(Process process) {
        boolean added = false;
        int bestFitIndex = Math.abs(ramSegments.get(0).getByteSize() - process.getProcessSize());
        for (int i = 0; i < ramSlots && !added; i++)
            if (ramSegments.get(i).getProcess() == null &&
                    Math.abs(ramSegments.get(i).getByteSize() - process.getProcessSize()) < bestFitIndex) {
                ramSegments.get(i).setProcess(process);
                added = true;
            }
        if (!added) processes.add(process);
    }

    private void createRAM() {
        for (int i = 0; i < ramSlots; i++)
            ramSegments.add(new RAMSegment(i,i+1,
                    (int) (System.nanoTime() % 500), new Process(i, 20)));
    }

    public Process execute() {
        RAMSegment segment = (RAMSegment) ramSegments.toArray()[random.nextInt(ramSlots)];
        Process process = segment.getProcess();
        segment.setProcess(null);
        return process;
    }

    public TreeSet<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(TreeSet<Process> processes) {
        this.processes = processes;
    }

    public ArrayList<RAMSegment> getRamSlots() {
        return ramSegments;
    }
}
