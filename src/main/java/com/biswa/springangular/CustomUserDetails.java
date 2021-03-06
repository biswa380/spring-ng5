package com.biswa.springangular;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public CustomUserDetails(com.biswa.springangular.domains.UserDetails byUsername) {
		this.username=byUsername.getUsername();
		this.password=byUsername.getPassword();
		
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		(byUsername.getRoles()).forEach(role->{
			(role.getRoleFeaturePermissionSchemes()).forEach(featureScheme -> {
				auths.add(new SimpleGrantedAuthority(featureScheme.getFeaturePermissionMapping().getFeature().getFeatureName()+"-"
						+featureScheme.getFeaturePermissionMapping().getPermission().getPermissionName()));
			});
		});
		this.authorities=auths;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
