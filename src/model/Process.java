package model;

public class Process {

    private int processID;
    private int processSize;
    private StringBuilder processName;

    public Process(int processID, int processSize) {
        this.processID = processID;
        this.processSize = processSize;
        this.generateProcessName();
    }

    private void generateProcessName() {
        this.processName = new StringBuilder();
        for (int i = 0; i < 10; i++)
            processName.append((char)((System.nanoTime() % 57) + 65));
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public int getProcessSize() {
        return processSize;
    }

    public void setProcessSize(int processSize) {
        this.processSize = processSize;
    }

    @Override
    public String toString() {
        return "Process Name: " +processName.toString() +
                "\t\t P-ID: " + processID + "\t\t Size: " + processSize + "b";
    }
}
