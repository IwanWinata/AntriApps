package antrianapp;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Antrian {
    private final Queue<Integer> nomorAntrian = new LinkedList<>();
    private int counter = 1;

    public int ambilNomorAntrian(HttpServletRequest request) {
        nomorAntrian.offer(counter);
        request.setAttribute("nomorAntrian", counter);
        return counter++;
    }

    public void panggilNomorAntrian() {
        if (!nomorAntrian.isEmpty()) {
            int nomor = nomorAntrian.poll();
            System.out.println("Nomor antrian " + nomor + " dipanggil.");
        } else {
            System.out.println("Semua antrian sudah dipanggil.");
        }
    }

    public void lihatAntrian() {
        System.out.println("Daftar Nomor Antrian: " + nomorAntrian);
    }

    public int getNomorAntrian() {
        return nomorAntrian.peek();
    }

    public List<Integer> getDaftarNomorAntrian() {
        return new ArrayList<>(nomorAntrian);
    }

    public static int processAntrian(AntrianProcessor processor, HttpServletRequest request) {
        return processor.processNomorAntrian(request);
    }

    public static void main(String[] args) {
        Antrian antrian = new Antrian();
        int nomor = antrian.ambilNomorAntrian(null);
        System.out.println("Nomor Antrian: " + nomor);

        // Method Overriding Example
        AntrianSubclass antrianSubclass = new AntrianSubclass();
        int nomorSubclass = antrianSubclass.ambilNomorAntrian(null);
        System.out.println("Nomor Antrian (Subclass): " + nomorSubclass);

        // Method Reference Example
        AntrianProcessor processor = antrian::ambilNomorAntrian;
        int nomorReference = Antrian.processAntrian(processor, null);
        System.out.println("Nomor Antrian (Method Reference): " + nomorReference);
    }
}

class AntrianSubclass extends Antrian {
    @Override
    public int ambilNomorAntrian(HttpServletRequest request) {
        // Custom implementation in the subclass
        // You can add your specific logic here
        System.out.println("Subclass method is called.");
        return super.ambilNomorAntrian(request); // Optionally call the superclass implementation
    }
}

@FunctionalInterface
interface AntrianProcessor {
    int processNomorAntrian(HttpServletRequest request);
}
