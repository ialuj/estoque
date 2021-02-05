package controller;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class LanguageController implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5937499999188170501L;

	private static final String PORTUGUESE_CODE = "pt";
	private String languageCode;

	@PostConstruct
	private void init() {
		setupLanguageCode();
		updateViewRoot();
	}

	private void setupLanguageCode() {
		languageCode = PORTUGUESE_CODE;
	}

	private void updateViewRoot() {
		Locale localeAtual = new Locale(languageCode);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(localeAtual);
	} // listener...

	public void onChangeLanguage(ValueChangeEvent e) {
		languageCode = e.getNewValue().toString();
		updateViewRoot();
	}

	// acessores...
	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

}
