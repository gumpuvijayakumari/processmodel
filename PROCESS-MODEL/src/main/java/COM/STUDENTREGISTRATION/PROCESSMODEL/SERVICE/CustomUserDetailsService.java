package COM.STUDENTREGISTRATION.PROCESSMODEL.SERVICE;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import COM.STUDENTREGISTRATION.PROCESSMODEL.MODEL.User;
import COM.STUDENTREGISTRATION.PROCESSMODEL.REPOSITORY.UserRepository;
import COM.STUDENTREGISTRATION.PROCESSMODEL.VIEWDETAILS.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
    
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

}
