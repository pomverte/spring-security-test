package org.hvle.userdetails;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MultiUserDetailsService implements UserDetailsService {

	@Resource(name = "userDetailsServiceList")
	private List<UserDetailsService> userDetailsServiceList;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		for (UserDetailsService usd : this.userDetailsServiceList) {
			UserDetails user = usd.loadUserByUsername(username);
			if (user != null) {
				return user;
			}
		}
		throw new UsernameNotFoundException(String.format(
				"username [%s] not found", username));
	}

	public List<UserDetailsService> getUserDetailsServiceList() {
		return userDetailsServiceList;
	}

	public void setUserDetailsServiceList(
			List<UserDetailsService> userDetailsServiceList) {
		this.userDetailsServiceList = userDetailsServiceList;
	}

}
