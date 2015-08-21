
package Beans;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;







@ManagedBean()
public class YoneticiListe {
   private Date date;
   private Date date1;
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

    
    public List<SatinAlmaListe> onaylanan_Liste() throws Exception {

    if(DB.seviye.equals("0")){
       
    }else {
        try {
                DB.seviye = "";
                git.redirect(DB.siteUrl+"index.xhtml");
            } catch (Exception e) {
            } 
    }    
    
       
    List<SatinAlmaListe> Onay_liste = new ArrayList<>();
    
    
    
          try {
            ResultSet rs = db.baglan().executeQuery("SELECT * from satinalmaform AS satin LEFT JOIN  kategori as kat on  kat.kategori_id = satin.kategori_id WHERE satin.durum='2'  order by satin.durum asc");
       
            
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

                Onay_liste.add(obj);

            }

        } catch (Exception e) {

            System.err.println("Yönetici Bilgi Hatası : " + e);

        }
finally{
        
        db.closeConnection();
              System.out.println("DB KAPATILDI!");
        
          }
        return Onay_liste;
    }
    
    
    
    
    
      public List<SatinAlmaListe> iptal_Liste() throws Exception {

    if(DB.seviye.equals("0")){
       
    }else {
        try {
                DB.seviye = "";
                git.redirect(DB.siteUrl+"index.xhtml");
            } catch (Exception e) {
            } 
    }    
    
       
    List<SatinAlmaListe> iptal_liste = new ArrayList<>();
                 
                 
          try {
            ResultSet rs = db.baglan().executeQuery("SELECT * from satinalmaform AS satin LEFT JOIN  kategori as kat on  kat.kategori_id = satin.kategori_id WHERE satin.durum='5'  order by satin.durum asc");
       
            
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

                iptal_liste.add(obj);

            }

        } catch (Exception e) {

            System.err.println("Yönetici Bilgi Hatası : " + e);

        }
finally{
        
        db.closeConnection();
              System.out.println("DB KAPATILDI!");
        
          }
        return iptal_liste;
    }
    

    
    
    //0 ise okunmadı, 1 ise okudu, 2 ise okundu onaylandı, 3 ise okundu red alındı,5 ise iptal edildi.
      public void talepIptalEt(String id,String aciklama) throws SQLException {
        int geriDurum = db.baglan().executeUpdate("update satinalmaform set durum = '5' , aciklama = '"+aciklama+"' where id = '"+id+"'");
        
       
    }
    
        public void talepOnayla(String id, String aciklama) throws SQLException {
          
            try{
               
       int geriDurum = db.baglan().executeUpdate("update satinalmaform set durum = '2' , aciklama = '"+aciklama+"' where id = '"+id+"'");
             if (geriDurum > 0) {

                System.out.println("Yazma işlemi başarılı");
                 git.redirect(DB.siteUrl+"yonetici.xhtml");
            }

        } catch (Exception e) {

            System.err.println("yazma işlemi hatası" + e);
        }
            
   }
         
 
         
         
         public void infoOnay() {
      FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Talep Onay", "Satın Alma Talebi Onaylandı!"));
    }
     
         public void infoIptal() {
      FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage("Talep İptal", "Satın Alma Talebi İptal Edildi!"));
    }

         
  //DATE        
 public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
   public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }
   
   //LİNE CHART
  
    
    
}
