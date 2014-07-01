package org.hvle.userdetails;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MultiUserDetailsService implements UserDetailsService {

	// Resource = Qualifier + Autowired
	@Resource(name = "userDetailsServiceList")
	private List<UserDetailsService> userDetailsServiceList;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		for (UserDetailsService usd : this.userDetailsServiceList) {
			try {
				return usd.loadUserByUsername(username);
			} catch (UsernameNotFoundException e) {
				// user not found in the current userDetailService
			}
		}
		throw new UsernameNotFoundException(String.format(
				"username [%s] not found", username));
	}

}
