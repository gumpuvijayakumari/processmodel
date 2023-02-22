package COM.STUDENTREGISTRATION.PROCESSMODEL.CONTROLLER;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import COM.STUDENTREGISTRATION.PROCESSMODEL.MODEL.User;
import COM.STUDENTREGISTRATION.PROCESSMODEL.REPOSITORY.UserRepository;

@Controller
public class StudentController {
	
	@Autowired
	private UserRepository userrepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String  processRegistration(User user) {
		userrepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList() {
		return "users";
	}
	

}
