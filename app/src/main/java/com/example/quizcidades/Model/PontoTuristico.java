package com.example.quizcidades.Model;

import android.app.Activity;

public class PontoTuristico extends Activity {

    private int logo;
    private String Url;
    private String cidade;

    public PontoTuristico(int logo, String url, String cidade) {
        this.logo = logo;
        this.Url = url;
        this.cidade = cidade;
    }
    public PontoTuristico( String url, String cidade) {
        this.Url = url;
        this.cidade = cidade;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
