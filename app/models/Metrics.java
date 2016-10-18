package models;

/**
 * Created by Natanael on 17/10/2016.
 */
public class Metrics {
    private long freeDiskSpace;
    private long totalDiskSpace;
    private long freeMemory;
    private long usedMemory;
    private double freeMemoryPercentage;
    private double usedMemoryPercentage;

    public Metrics(long freeDiskSpace, long totalDiskSpace, long freeMemory, long usedMemory, double freeMemoryPercentage, double usedMemoryPercentage) {
        this.freeDiskSpace = freeDiskSpace;
        this.totalDiskSpace = totalDiskSpace;
        this.freeMemory = freeMemory;
        this.usedMemory = usedMemory;
        this.freeMemoryPercentage = freeMemoryPercentage;
        this.usedMemoryPercentage = usedMemoryPercentage;
    }

    public long getFreeDiskSpace() {
        return freeDiskSpace;
    }

    public void setFreeDiskSpace(long freeDiskSpace) {
        this.freeDiskSpace = freeDiskSpace;
    }

    public long getTotalDiskSpace() {
        return totalDiskSpace;
    }

    public void setTotalDiskSpace(long totalDiskSpace) {
        this.totalDiskSpace = totalDiskSpace;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public double getFreeMemoryPercentage() {
        return freeMemoryPercentage;
    }

    public void setFreeMemoryPercentage(double freeMemoryPercentage) {
        this.freeMemoryPercentage = freeMemoryPercentage;
    }

    public double getUsedMemoryPercentage() {
        return usedMemoryPercentage;
    }

    public void setUsedMemoryPercentage(double usedMemoryPercentage) {
        this.usedMemoryPercentage = usedMemoryPercentage;
    }
}
