package kr.mmgg.auction.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.mmgg.auction.login.entity.UserEntity;
import kr.mmgg.auction.login.repository.LoginRepository;

@Service
public class UserDetailService implements UserDetailsService{
	@Autowired
	public LoginRepository loginRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String discordEmaIl) throws UsernameNotFoundException {
		UserEntity userEntity = loginRepository.selectUserForDiscordEmail(discordEmaIl);
		return CustomUserPrincipal.create(userEntity);
	}
}