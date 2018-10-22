package com.example.windows10.wisatabawean.model;

public class Galeri {
    private String title, jenis;
    private Integer imageF;

    public Galeri() {
    }

    public Galeri(String title, String jenis, int imageF) {
        this.title = title;
        this.jenis = jenis;
        this.imageF = imageF;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getJenis() {

        return jenis;
    }

    public void setJenis(String jenis) {

        this.jenis = jenis;
    }

    public Integer getImageF() {

        return imageF;
    }

    public void setImageF(Integer imageF) {

        this.imageF = imageF;
    }
}
