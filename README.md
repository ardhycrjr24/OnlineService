# Online Service App — Modul 11

## Akses RESTful API Online Service App Lanjutan

Modul 11 berfokus pada pengembangan fitur CRUD lanjutan menggunakan Retrofit pada aplikasi Android Online Service. Pada modul ini aplikasi sudah mampu menampilkan data jasa dari REST API, menambahkan jasa baru beserta upload gambar, mengubah data jasa, menghapus jasa, serta menampilkan detail jasa menggunakan RecyclerView dan Fragment. 

---

## Fitur yang Diimplementasikan

### 1. Menampilkan Data Jasa pada Fragment Home

* Mengambil data jasa dari RESTful API menggunakan Retrofit
* Menampilkan data menggunakan RecyclerView
* Menggunakan adapter untuk binding data
* Menampilkan gambar jasa menggunakan Glide

### 2. Detail Jasa

* Menampilkan detail lengkap jasa
* Mengirim data antar activity menggunakan Intent Extra
* Menampilkan gambar, rating, kontak, dan deskripsi jasa

### 3. Menampilkan Data Jasa Pengguna

* Menampilkan daftar jasa milik user login
* Menggunakan endpoint khusus berdasarkan ID user
* Menampilkan data dinamis pada Fragment Service

### 4. Menambah Jasa Baru

* Upload gambar menggunakan Multipart Retrofit
* Menggunakan ImagePicker
* Menggunakan EasyPermissions
* Validasi input form
* Menyimpan data jasa ke server

### 5. Mengubah Data Jasa

* Mengedit data jasa tanpa mengganti gambar
* Mengedit data jasa beserta gambar baru
* Menggunakan method PUT Retrofit

### 6. Menghapus Data Jasa

* Menghapus jasa menggunakan endpoint DELETE
* Menampilkan AlertDialog konfirmasi
* Refresh data otomatis setelah delete berhasil

---

## Teknologi dan Library

* Kotlin
* Retrofit
* Gson Converter
* Glide
* RecyclerView
* ViewBinding
* ImagePicker
* EasyPermissions
* RESTful API
* Multipart Request

---

## Struktur Fitur Modul 11

| Fitur              | Keterangan                  |
| ------------------ | --------------------------- |
| HomeFragment       | Menampilkan seluruh jasa    |
| DetailJasaActivity | Menampilkan detail jasa     |
| ServiceFragment    | Menampilkan jasa milik user |
| AddJasaActivity    | Menambahkan jasa baru       |
| EditJasaActivity   | Mengubah dan menghapus jasa |
| JasaAdapter        | Adapter RecyclerView        |
| JasaService        | Endpoint REST API           |
| Retrofit Multipart | Upload gambar jasa          |

---

## Endpoint API yang Digunakan

| Method | Endpoint             | Fungsi                 |
| ------ | -------------------- | ---------------------- |
| GET    | `/services`          | Menampilkan semua jasa |
| GET    | `/userServices/{id}` | Menampilkan jasa user  |
| POST   | `/services`          | Menambah jasa          |
| PUT    | `/services/{id}`     | Mengubah jasa          |
| DELETE | `/services/{id}`     | Menghapus jasa         |

---

## Hasil Implementasi

Pada modul ini aplikasi berhasil:

* Menampilkan data jasa dari server
* Menampilkan detail jasa
* Menambahkan jasa baru dengan upload gambar
* Mengubah data jasa
* Menghapus data jasa
* Menggunakan Retrofit CRUD secara lengkap
* Menggunakan RecyclerView dan Fragment secara dinamis

---

## Dokumentasi Praktikum

Praktikum mengacu pada modul:
**“Akses RESTful API Online Service App Lanjutan”** 

---

## Author
ARDIANSYAH
@ardhycrjr24
