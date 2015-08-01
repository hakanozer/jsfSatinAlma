
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean
public class YoneticiListe {
    
    ExternalContext git = FacesContext.getCurrentInstance().getExternalContext();
    public YoneticiListe(){
    if(DB.seviye.equals("0")){
       
    }else {
        try {
                DB.seviye = "";
                git.redirect(DB.siteUrl+"index.xhtml");
            } catch (Exception e) {
            } 
    } 
    }
    
    
}
