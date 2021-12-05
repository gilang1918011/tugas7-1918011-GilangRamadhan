package com.example.ws6_sqlite;

public class Pemain {
    private String _id, _nama, _accesoris;

    public Pemain (String id, String nama, String accesoris) {
        this._id = id;
        this._nama = nama;
        this._accesoris = accesoris;
    }
    public Pemain() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_accesoris() {
        return _accesoris;
    }

    public void set_kelas(String _accesoris) {
        this._accesoris = _accesoris;
    }
       public void set_accesoris(String string) {
    }
}