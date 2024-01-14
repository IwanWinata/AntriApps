package antrianapp;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Antrian {
    private final Queue<Integer> nomorAntrian = new LinkedList<>();
    private int nomorYangDipanggil = 0;
    private int counter = 1;

    public void ambilNomorAntrian(HttpServletRequest request) {
        nomorAntrian.offer(counter);
        request.setAttribute("nomorAntrian", counter); // Set nomorAntrian attribute
        counter++;
    }

    public void panggilNomorAntrian(HttpServletRequest request) {
        if (!nomorAntrian.isEmpty()) {
        	nomorYangDipanggil = nomorAntrian.poll();
            request.setAttribute("nomorYangDipanggil", nomorYangDipanggil); // Set nomorYangDipanggil attribute
            System.out.println("Nomor antrian " + nomorYangDipanggil + " dipanggil.");
        } else {
            System.out.println("Semua antrian sudah dipanggil.");
        }
    }

    public void lihatAntrian() {
        System.out.println("Daftar Nomor Antrian: " + nomorAntrian);
    }

    public int getNomorAntrian() {
        if (!nomorAntrian.isEmpty()) {
            return nomorAntrian.peek();
        }
        return 0;
    }

    public List<Integer> getDaftarNomorAntrian() {
        return new ArrayList<>(nomorAntrian);
    }

    public List<Integer> getNomorYangDipanggil() {
        return nomorYangDipanggil;
    }
}
