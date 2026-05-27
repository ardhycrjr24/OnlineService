# Online Service App – Modul 10 RESTful API

Aplikasi Android berbasis Kotlin yang dibuat pada praktikum Pemrograman Mobile II Modul 10 dengan implementasi RESTful API menggunakan Retrofit.

---

# Fitur Aplikasi

* Splash Screen
* Login User
* Register User
* Navigation Drawer
* Fragment Navigation
* Session Login
* Profile User
* Edit Profile
* Delete User
* Logout User
* RESTful API Integration
* Glide Image Loader
* Retrofit Networking

---

# Teknologi Yang Digunakan

* Kotlin
* Android Studio
* Retrofit2
* Gson Converter
* Glide
* Navigation Component
* SharedPreferences
* Material Design
* Lottie Animation

---

# Struktur Halaman

* Splash Screen
* Login Activity
* Register Activity
* Main Activity
* Home Fragment
* Service Fragment
* Profile Fragment
* Edit Profile Activity

---

# REST API

Aplikasi menggunakan REST API:

```text id="w1"
https://dummyjson.com/
```

Endpoint yang digunakan:

| Method | Endpoint    | Fungsi         |
| ------ | ----------- | -------------- |
| POST   | /auth/login | Login user     |
| PUT    | /users/{id} | Update profile |
| DELETE | /users/{id} | Hapus akun     |

---

# Dependency Utama

```kotlin id="w2"
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.github.bumptech.glide:glide:4.14.2")
implementation("com.airbnb.android:lottie:5.2.0")
```

---

# Screenshot Aplikasi

## Splash Screen

Tambahkan screenshot splash screen di sini.

---

## Login

Tambahkan screenshot login di sini.

---

## Navigation Drawer

Tambahkan screenshot navigation drawer di sini.

---

## Profile User

Tambahkan screenshot profile user di sini.

---

## Edit Profile

Tambahkan screenshot edit profile di sini.

---

# Cara Menjalankan Project

1. Clone repository

```bash id="w3"
git clone https://github.com/ardhycrjr24/OnlineService.git
```

2. Buka project menggunakan Android Studio

3. Sync Gradle

4. Jalankan emulator Android

5. Run aplikasi

---

# Struktur Branch

| Branch   | Keterangan               |
| -------- | ------------------------ |
| main     | Project utama            |
| modul-10 | Hasil praktikum modul 10 |
| modul-11 | Pengembangan modul 11    |

---

# Author

**Ardiansyah**
D4 Rekayasa Perangkat Lunak
Politeknik Negeri Bengkalis

GitHub:

```text id="w4"
https://github.com/ardhycrjr24
```
