package services;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by Natanael on 08/10/2016.
 */
public class SystemMetrics {

    private NumberFormat nf;
    private List<Path> roots;
    private FileStore store;
    private Mem mem;
    private Sigar sigar;

    public SystemMetrics()  {
        this.nf = NumberFormat.getNumberInstance();

        this.sigar = new Sigar();
        try {
            this.mem = sigar.getMem();
        } catch (SigarException e) {
            System.out.println("Error no Sigar Exception");
        }
    }

    public long getMemFreeSpace(){
        return this.mem.getFree();
    }

    public long getMemTotalSpace(){
        return this.mem.getTotal();
    }

    public long getMemUsedSpace(){
        return this.mem.getUsed();
    }

    public double getFreeMemPercent(){
        return this.mem.getFreePercent();
    }

    public double getUsedMemPercent(){
        return this.mem.getUsedPercent();
    }

    public long getDiskFreeSpace() {
        long usable = 0;
        //String usableReturn = "";
        for (Path root : FileSystems.getDefault().getRootDirectories()) {


            try {
                this.store = Files.getFileStore(root);
                usable+=this.store.getUsableSpace();
                //usableReturn = nf.format(usable/1000000000);
            } catch (IOException e) {
                System.out.println("error querying space: " + e.toString());
            }
        }
        return usable;
    }

    public long getDiskTotalSpace(){
        long total = 0;
        //String totalReturn = "";
        for (Path root : FileSystems.getDefault().getRootDirectories()) {


            try {
                this.store = Files.getFileStore(root);
                total+=this.store.getTotalSpace();
                //totalReturn = nf.format(total/1000000000);
            } catch (IOException e) {
                System.out.println("error querying space: " + e.toString());
            }
        }
        return total;
    }
}