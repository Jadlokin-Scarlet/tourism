package com.tourism.security;

//import com.tourism.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
public class MyUserDetailsService{
//
//	@Autowired
//	private UserService userService;
//
//	/**
//	 * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
//	 */
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userService.getUserByName(username);
//		if (null == user) {
//			throw new UsernameNotFoundException(username);
//		}
//		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		Role role = user.getRole();
//		List<SimpleGrantedAuthority> authorities = roleMapper.getAuthoritieByRoleId();
////			authorities.add(new SimpleGrantedAuthority(permission.getCode()));
//
//		return new User(user.getUsername(), user.getPassword(), authorities);
//	}
}