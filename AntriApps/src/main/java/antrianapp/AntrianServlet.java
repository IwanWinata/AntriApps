package antrianapp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AntrianServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Antrian antrian;

    public AntrianServlet() {
        super();
        antrian = new Antrian();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "ambil":
                    antrian.ambilNomorAntrian(request);
                    break;
                case "panggil":
                    antrian.panggilNomorAntrian(request);
                    break;
                case "lihat":
                    request.setAttribute("nomorAntrian", antrian.getNomorAntrian());
                    request.setAttribute("daftarAntrian", antrian.getDaftarNomorAntrian());
                    break;
                default:
                    break;
            }
        }

        // Dispatch ke halaman index.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
