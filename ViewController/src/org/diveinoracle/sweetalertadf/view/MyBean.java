package org.diveinoracle.sweetalertadf.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class MyBean {
    public MyBean() {
    }

    public void onClickShowFacesMessageBtn(ActionEvent actionEvent) {
        // Add event code here...
        FacesMessage msg=new FacesMessage("Hello World!");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public void onClickShowSweetAlertBtn(ActionEvent actionEvent) {
        // Add event code here...
        String jsCode = "Swal.fire(\n" + 
        "                      'Good job!',\n" + 
        "                      'You clicked the button!',\n" + 
        "                      'success'\n" + 
        "                    );";
        
        FacesContext fCtx = FacesContext.getCurrentInstance();
        ExtendedRenderKitService eKit = Service.getRenderKitService(fCtx, ExtendedRenderKitService.class);
        
        eKit.addScript(fCtx, jsCode);
    }
}
