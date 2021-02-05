package controller;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	private JSFUtil() {
	}

	public static JSFUtil build() {
		return new JSFUtil();
	}

	public void addInfoMessage(String summary) {
		FacesMessage fm = new FacesMessage(summary);
		fm.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, fm);

	}

	public void addErrorMessage(String summary) {
		FacesMessage fm = new FacesMessage(summary);
		fm.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

	public void setRequestObject(String objectKey, Object objectValue) {
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		requestMap.put(objectKey, objectValue);
	}

	public Object getRequestObject(String objectKey) {
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		return requestMap.get(objectKey);
	}

}
