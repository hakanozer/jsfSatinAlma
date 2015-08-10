
package Beans;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean()
public class YoneticiListe {
  
       // çıkış yap
    ExternalContext git = FacesContext.getCurrentInstance().getExternalContext();
    DB db = new DB(); 
    //Satın alma Form Listeleme
    public List<SatinAlmaListe> listele() throws Exception {

    if(DB.seviye.equals("0")){
       
    }else {
        try {
                DB.seviye = "";
                git.redirect(DB.siteUrl+"index.xhtml");
            } catch (Exception e) {
            } 
    }    
    
       
    List<SatinAlmaListe> liste = new ArrayList<>();
                
          try {
            ResultSet rs = db.baglan().executeQuery("SELECT * from satinalmaform AS satin LEFT JOIN  kategori as kat on  kat.kategori_id = satin.kategori_id WHERE satin.durum='0'  order by satin.durum asc");
       
            
            while (rs.next()) {
                SatinAlmaListe obj = new SatinAlmaListe();
                
                System.out.println("BASARILI !!!!!");
                obj.setSatinAlmaId(rs.getString("satin.id"));
                obj.setKategori_id(rs.getInt("kat.kategori_id"));
                obj.setKategori_adi(rs.getString("kat.adi"));
                obj.setTedarikci_adi(rs.getString("satin.tedarikci_adi"));
                obj.setUrun_adi(rs.getString("urun_adi"));
                obj.setBirimFiyat(rs.getFloat("birimFiyat"));
                obj.setAdet(rs.getInt("adet"));
                obj.setKdv(rs.getInt("kdv"));
                obj.setToplamTutar(rs.getFloat("toplamTutar"));
                obj.setGenelToplam(rs.getFloat("genelToplam"));
                obj.setAdminID(rs.getInt("adminID"));
                obj.setDurum(rs.getInt("durum"));
                obj.setTarih(rs.getString("tarih"));
                obj.setInsertUserName(rs.getString("insert_User"));
                obj.setInsert_UserSurName(rs.getString("insert_UserSurname"));

                liste.add(obj);

            }

        } catch (Exception e) {

            System.err.println("Yönetici Bilgi Hatası : " + e);

        }
finally{
        
        db.closeConnection();
              System.out.println("DB KAPATILDI!");
        
          }
        return liste;
    }
    
    //0 ise okunmadı, 1 ise okudu, 2 ise okundu onaylandı, 3 ise okundu red alındı,5 ise iptal edildi.
      public void talepIptalEt(String id) throws SQLException {
        int geriDurum = db.baglan().executeUpdate("update satinalmaform set durum = '3' where id = '"+id+"'");
        
       
    }
      
         public void talepOnayla(String id) throws SQLException {
        int geriDurum = db.baglan().executeUpdate("update satinalmaform set durum = '2' where id = '"+id+"'");
        
       
    }
         
         
         
         public void infoOnay() {
      FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Talep Onay", "Satın Alma Talebi Onaylandı!"));
    }
     
         public void infoIptal() {
      FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Talep İptal", "Satın Alma Talebi İptal Edildi!"));
    }
    
}
