package controller.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import model.servico.exception.NegocioException;

public class JSFUtil {

	public static void addNegocioMessage(NegocioException negocioEx) {
		FacesMessage fm = new FacesMessage(negocioEx.getMessage());
		fm.setSeverity(FacesMessage.SEVERITY_WARN);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

	public static void addErrorMessage(String errorMsg) {
		FacesMessage fm = new FacesMessage(errorMsg);
		fm.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

	public static void addInfoMessage(String infoMsg) { 
		FacesMessage fm = new FacesMessage( infoMsg ); 
		fm.setSeverity( FacesMessage.SEVERITY_INFO );
	}

}
