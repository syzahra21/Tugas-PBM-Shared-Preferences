package com.example.tugassharedpreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tugaspbm.R

class MainActivity : AppCompatActivity() {
    // Inisialisasi key dan shared preference
    private val PREF_NAME = "MahasiswaPrefs"
    private val KEY_NAMA = "nama"
    private val KEY_JURUSAN = "jurusan"
    private val KEY_NPM = "npm"
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen UI
        val namaEt = findViewById<EditText>(R.id.namaMHS)
        val jurusanEt = findViewById<EditText>(R.id.jurusanMHS)
        val npmEt = findViewById<EditText>(R.id.npmMHS)
        val simpanBtn = findViewById<Button>(R.id.simpanButton)

        // Inisialisasi shared preference
        sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        // Mengambil data dari shared preference
        val namaSaved = sharedPref.getString(KEY_NAMA, "")
        val jurusanSaved = sharedPref.getString(KEY_JURUSAN, "")
        val npmSaved = sharedPref.getString(KEY_NPM, "")

        // Mengisi data ke EditText
        namaEt.setText(namaSaved)
        jurusanEt.setText(jurusanSaved)
        npmEt.setText(npmSaved)

        // Menyimpan data ke shared preference
        simpanBtn.setOnClickListener {
            val nama = namaEt.text.toString()
            val jurusan = jurusanEt.text.toString()
            val npm = npmEt.text.toString()

            with (sharedPref.edit()) {
                putString(KEY_NAMA, nama)
                putString(KEY_JURUSAN, jurusan)
                putString(KEY_NPM, npm)
                apply()
            }
            val data = "Nama: $namaSaved\nJurusan: $jurusanSaved\nNPM: $npmSaved"

            Toast.makeText(this, data, Toast.LENGTH_LONG).show()
        }
    }
}