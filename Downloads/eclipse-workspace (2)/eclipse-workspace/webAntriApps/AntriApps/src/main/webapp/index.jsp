<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AntriApps</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
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
        .small-popup {
            max-width: 80%;
            width: 50%;
            margin-left: 0%;
        }
    </style>
</head>
<body>

<header>
    <h1>Antri Apps</h1>
</header>

<div class="container">
    <form id="ambilNomorForm" action="/AntriApps/AntrianServlet" method="post">
        <input type="hidden" name="action" value="ambil">
        <button type="button" onclick="ambilNomor()">Ambil Nomor Antrian</button>
    </form>

    <form id="panggilNomorForm" action="/AntriApps/AntrianServlet" method="post">
        <input type="hidden" name="action" value="panggil">
        <button type="button" onclick="panggilNomor()">Panggil Nomor Antrian</button>
    </form>

    <form action="/AntriApps/AntrianServlet" method="post">
        <input type="hidden" name="action" value="lihat">
        <button class="form-button" type="submit">Lihat Antrian</button>
    </form>

    <h3>Nomor Antrian: ${nomorAntrian}</h3>
    <h3>Daftar Antrian: ${daftarAntrian}</h3>
</div>

<script>
    function ambilNomor() {
        console.log('Fungsi ambilNomor() dijalankan.');
        fetch('/AntriApps/AntrianServlet', {
            method: 'POST',
            body: new URLSearchParams({
                'action': 'ambil'
            }),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        })
        .then(response => response.json())
        .then(data => {
            console.log('Data yang Diterima:', data);
            if (data && data.nomorAntrian !== undefined) {
                
            	Swal.fire({
            		title: 'Antrian Ke ' + data.nomorAntrian + ' Nih',
            	    html: `
            	        <div style="font-size: 1.5em; text-align: center; margin-top: 10px;">Terima kasih telah mengambil nomor antrian!</div>
            	    `, 
            	    showConfirmButton: true,
            	    backdrop: true,
            	    allowOutsideClick: false,
            	    customClass: {
            	        popup: 'small-popup'
            	    }
            	});
            } else {
                console.error('Nomor antrian tidak valid.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }

    function panggilNomor() {
        var password = prompt("Masukkan kata sandi:");

        if (password !== null) {
            fetch('/AntriApps/AntrianServlet', {
                method: 'POST',
                body: new URLSearchParams({
                    'action': 'panggil',
                    'password': password
                }),
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                }
            })
            .then(response => response.json())
            .then(data => {
                
                alert('Nomor Antrian ' + data.nomorAntrian + ' dipanggil.');
            })
            .catch(error => {
                console.error('Error:', error);
            });
        }
    }
</script>

</body>
</html>
