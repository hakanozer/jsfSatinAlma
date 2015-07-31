
package Beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "satinAlma")
public class satinAlma {
    
    private int kategori_id;
    private String tedarikci_adi="";
    private String urun_adi="";
    private Float birimFiyat;
    private Float adet;
    private Float kdv;
    private Float toplamTutar;
    private Float genelToplam;
    private int adminID;
    private int durum;
    private String tarih;

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getTedarikci_adi() {
        return tedarikci_adi;
    }

    public void setTedarikci_adi(String tedarikci_adi) {
        this.tedarikci_adi = tedarikci_adi;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public Float getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(Float birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

    public Float getAdet() {
        return adet;
    }

    public void setAdet(Float adet) {
        this.adet = adet;
    }

    public Float getKdv() {
        return kdv;
    }

    public void setKdv(Float kdv) {
        this.kdv = kdv;
    }

    public Float getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(Float toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public Float getGenelToplam() {
        return genelToplam;
    }

    public void setGenelToplam(Float genelToplam) {
        this.genelToplam = genelToplam;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public int getDurum() {
        return durum;
    }

    public void setDurum(int durum) {
        this.durum = durum;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
    
    
    
    
}
