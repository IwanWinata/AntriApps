<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AntriApps</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px 0;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .form-button {
            display: block;
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-align: center;
            text-decoration: none;
        }
        h3 {
            margin-top: 20px;
            font-size: 24px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Antri Apps</h1>
    </header>

    <div class="container">
        <form action="/AntriApps/AntrianServlet" method="post">
            <input type="hidden" name="action" value="ambil">
            <button class="form-button" type="submit">Ambil Nomor Antrian</button>
        </form>

        <form action="/AntriApps/AntrianServlet" method="post">
            <input type="hidden" name="action" value="panggil">
            <button class="form-button" type="submit">Panggil Nomor Antrian</button>
        </form>

        <form action="/AntriApps/AntrianServlet" method="post">
            <input type="hidden" name="action" value="lihat">
            <button class="form-button" type="submit">Lihat Antrian</button>
        </form>
	<h3>Nomor Antrian: ${nomorYangDipanggil}</h3>
        <h3>Nomor Antrian: ${nomorAntrian}</h3>
        <h3>Daftar Antrian: ${daftarAntrian}</h3>
    </div>
</body>
</html>
