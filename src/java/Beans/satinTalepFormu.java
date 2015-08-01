
package Beans;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;



@ManagedBean(name = "satinTalepFormu")
public class satinTalepFormu {
    
    ExternalContext git = FacesContext.getCurrentInstance().getExternalContext();
    DB db = new DB(); 
    
     
    
 
    
    public List<String> kategoriListeleText() {
        
        if(DB.seviye.equals("1")){
       
        }else {
            try {
                    DB.seviye = "";
                    git.redirect(DB.siteUrl+"index.xhtml");
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
    
    

    
    
    
}
