package Beans;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean(name = "satinTalepFormu")
@SessionScoped

public class satinTalepFormu {

    ExternalContext git = FacesContext.getCurrentInstance().getExternalContext();
    DB db = new DB();

    private int kategori_id;
    private String tedarikci_adi = "";
    private String urun_adi = "";
    private float birimFiyat;
    private int adet;
    private int kdv;
    private Float toplamTutar;
    private Float genelToplam;
    private int adminID;
    private int durum;
    private String tarih;

    public float getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(float birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

    // kdvsiz toplam tutar hesapla
    public void kdvsizToplamTutar() {
        this.toplamTutar = (float) (this.birimFiyat * this.adet);
    }

    // kdvli toplam tutar hesapla
    public void genelToplamTutar() {

        this.genelToplam = this.toplamTutar * ((float) (this.kdv) / 100);
        String yuvala = String.format("%.2f", this.genelToplam);
        this.genelToplam = Float.valueOf(yuvala);

    }

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

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public int getKdv() {
        return kdv;
    }

    public void setKdv(int kdv) {
        this.kdv = kdv;
    }

    public Float getToplamTutar() {
        //String yaz = String.format("%.2f", this.genelToplam);
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

    public List<String> kategoriListeleText() {

        if (DB.seviye.equals("1")) {

        } else {
            try {
                DB.seviye = "";
                git.redirect(DB.siteUrl + "index.xhtml");
            } catch (Exception e) {
            }
        }

        List<String> results = new ArrayList<String>();
        try {
            ResultSet rs = db.baglan().executeQuery("SELECT *from kategori");
            while (rs.next()) {

                results.add(rs.getString("adi"));
            }
        } catch (Exception e) {

            System.err.println("SatınAlma Bilgi Hatası : " + e);
        }
        return results;
    }

    // kaydet fonksiyonu
    public void satinAlKaydet() {
        System.out.println("Çalıştı");
        try {
            
            int kayit = db.baglan().executeUpdate("insert into satinalmaform values(null, '" + id + "', '" + unvan + "', '" + urunAdi + "', '" + birimFiyat + "', '" + adet + "','" + kdv + "', '" + toplamTutar + "', '" + genelToplam + "', '" + DB.yazuserId + "','0', now())");
        if (kayit > 0) {
            System.out.println("Satin Alma Form Oluşturuldu");
            try {
                //git.getFlash().setKeepMessages(true);
                //git.getFlash().setRedirect(true);
                //git.redirect(DB.siteUrl + "yonetici.xhtml");

            } catch (Exception e) {

                System.out.println("yonetici Giris Hatas" + e);
            }

        }
            
        } catch (Exception e) {
            System.err.println("SQL Yazma Hatası : "+ e);
        }

    }
    
    
    
    
    // tedarikçi listesi
    private String unvan;

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }
    
    public List<String> complete(String query) {
        List<String> queries = new ArrayList<String>();
       
        try {

            ResultSet rs = null;
            String myQuery = "select unvan from tedarikciler where unvan like '%"+query+"%'";

            rs = db.baglan().executeQuery(myQuery);
            while (rs.next()) {
                queries.add(rs.getString("unvan"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return queries;
    }

    
    
    // urun Listesi
    private String urunAdi;

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

  
    public List<String> completeUrun(String query) {
        List<String> queries = new ArrayList<String>();
       
        try {

            ResultSet rs = null;
            String myQuery = "select urunAdi from urunler where urunAdi like '%"+query+"%'";

            rs = db.baglan().executeQuery(myQuery);
            while (rs.next()) {
                queries.add(rs.getString("urunAdi"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return queries;
    }

    
    
    // kategori listesi
   private static final long serialVersionUID = 1L;
    private String catname, subcatname, id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    public String getCatname() {
        return catname;
    }
 
    public void setCatname(String catname) {
        this.catname = catname;
    }
 
    public String getSubcatname() {
        return subcatname;
    }
 
    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }
    public List<SelectItem> getCategoryName() {
        List<SelectItem> cat = new ArrayList<SelectItem>();
        try {
            
            ResultSet rs = null;
            String myQuery = "select adi,kategori_id from kategori";
 
            rs = db.baglan().executeQuery(myQuery);
            while (rs.next()) {
                cat.add(new SelectItem(rs.getString("kategori_id"), rs.getString("adi")));
               
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
        return cat;
    }
    
}
