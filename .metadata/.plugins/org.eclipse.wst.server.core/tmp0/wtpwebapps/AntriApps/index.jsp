<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form AntriApps</title>
</head>
<body>
    <h1>Antri Apps</h1>

    <form action="/AntriApps/AntrianServlet" method="post">
        <input type="hidden" name="action" value="ambil">
        <button type="submit">Ambil Nomor Antrian</button>
    </form>

    <br>

    <form action="/AntriApps/AntrianServlet" method="post">
        <input type="hidden" name="action" value="panggil">
        <button type="submit">Panggil Nomor Antrian</button>
    </form>

    <br>

    <form action="/AntriApps/AntrianServlet" method="post">
        <input type="hidden" name="action" value="lihat">
        <button type="submit">Lihat Antrian</button>
    </form>

    <br>

    <h3>Nomor Antrian: ${nomorAntrian}</h3>
    <h3>Daftar Antrian: ${daftarAntrian}</h3>

</body>
</html>
