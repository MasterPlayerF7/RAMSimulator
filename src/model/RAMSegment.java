package model;

public class RAMSegment {

    private int blockStart;
    private int blockEnd;
    private int byteSize;
    private Process process;

    public RAMSegment(int blockStart, int blockEnd, int byteSize) {
        this.blockStart = blockStart;
        this.blockEnd = blockEnd;
        this.byteSize = byteSize;
    }

    public RAMSegment(int blockStart, int blockEnd, int byteSize, Process process) {
        this(blockStart, blockEnd, byteSize);
        this.process = process;
    }

    public int getBlockStart() {
        return blockStart;
    }

    public void setBlockStart(int blockStart) {
        this.blockStart = blockStart;
    }

    public int getBlockEnd() {
        return blockEnd;
    }

    public void setBlockEnd(int blockEnd) {
        this.blockEnd = blockEnd;
    }

    public int getByteSize() {
        return byteSize;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
