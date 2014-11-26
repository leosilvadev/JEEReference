package br.com.leonardojgs.jeereference.controller.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.leonardojgs.jeereference.model.domains.User;
import br.com.leonardojgs.jeereference.model.services.UserService;

@Named
@RequestScoped
public class UserMB {

	@Inject
	private UserService userService;

	private List<User> users;

	public List<User> getUsers() {
		if (users == null) {
			users = userService.findAll();
		}
		return users;
	}

}
