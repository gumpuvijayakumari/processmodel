package COM.STUDENTREGISTRATION.PROCESSMODEL.VIEWDETAILS;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import COM.STUDENTREGISTRATION.PROCESSMODEL.MODEL.User;

public class CustomUserDetails implements UserDetails {
	private User user;
	
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public String getPassword() {
		return user.getPassword();
	}

	public String getUsername() {
		return user.getEmail();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
