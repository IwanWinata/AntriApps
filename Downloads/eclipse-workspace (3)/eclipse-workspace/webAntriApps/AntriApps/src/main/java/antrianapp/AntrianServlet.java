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
                try {
                    int nomorAntrian = antrian.ambilNomorAntrian(request);
                    System.out.println("Nomor Antrian yang Diterima: " + nomorAntrian);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("{\"nomorAntrian\": " + nomorAntrian + "}");
                } catch (Exception e) {
                    
                    System.err.println("Error: " + e.getMessage());
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
                }
                return;

                case "panggil":
                    String password = request.getParameter("password");
                    if ("buaya".equals(password)) { 
                        antrian.panggilNomorAntrian();
                        response.setContentType("application/json");
                        response.setCharacterEncoding("UTF-8");
                        response.getWriter().write("{\"nomorAntrian\": " + antrian.getNomorAntrian() + "}");
                    } else {
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Kata sandi salah");
                    }
                    return;
                case "lihat":
                    request.setAttribute("nomorAntrian", antrian.getNomorAntrian());
                    request.setAttribute("daftarAntrian", antrian.getDaftarNomorAntrian());
                    break;
                default:
                    break;
            }
        }

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}