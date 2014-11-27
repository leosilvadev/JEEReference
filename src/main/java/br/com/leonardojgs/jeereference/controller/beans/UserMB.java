package br.com.leonardojgs.jeereference.controller.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.leonardojgs.jeereference.model.business.UserBusiness;
import br.com.leonardojgs.jeereference.model.domains.User;

@Named
@ViewScoped
public class UserMB {

	@Inject
	private UserBusiness userBusiness;

	private List<User> users;

	public List<User> getUsers() {
		if (users == null) {
			users = userBusiness.findAll();
		}
		return users;
	}
	
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

}
