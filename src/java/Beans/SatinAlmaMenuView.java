package Beans;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
public class SatinAlmaMenuView {

   
    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // çıkış yap
    public void cikis(ActionEvent actionEvent) {
        System.out.println("Çıkış Yap");
        try {
            ExternalContext git = FacesContext.getCurrentInstance().getExternalContext();
            git.redirect("faces/index.xhtml?faces-redirect=true");
        } catch (Exception e) {
        }

    }
    
    
    
    //Satın alma Form Listeleme
    public List<satinAlma> listele() {

    List<satinAlma> liste = new ArrayList<>();
                DB db = new DB();
            System.out.println("sssssssssss !!!!!");    
                
        try {
            ResultSet rs = db.baglan().executeQuery("Select * from satinalmaform");
                 
            
            System.out.println("TESSSSSS !!!!!");
            
            while (rs.next()) {
                satinAlma obj = new satinAlma();
                
                System.out.println("BASARILI !!!!!");
                
                 obj.setTedarikci_adi(rs.getString("tedarikci_adi"));
                obj.setUrun_adi(rs.getString("urun_adi"));
                obj.setBirimFiyat(rs.getFloat("birimFiyat"));
                obj.setAdet(rs.getFloat("adet"));
                obj.setKdv(rs.getFloat("kdv"));
                obj.setToplamTutar(rs.getFloat("toplamTutar"));
                obj.setGenelToplam(rs.getFloat("genelToplam"));
                obj.setAdminID(rs.getInt("adminID"));
                obj.setDurum(rs.getInt("durum"));
                obj.setTarih(rs.getString("tarih"));

                liste.add(obj);

                               
                
            }

        } catch (Exception e) {

            System.err.println("SatınAlma Bilgi Hatası : " + e);

        }

        return liste;
    }
    
    
   public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
}
