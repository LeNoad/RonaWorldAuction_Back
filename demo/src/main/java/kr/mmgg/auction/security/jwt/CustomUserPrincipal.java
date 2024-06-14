package kr.mmgg.auction.security.jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.mmgg.auction.login.entity.UserEntity;
import lombok.Getter;

@Getter
public class CustomUserPrincipal implements UserDetails{
	private String discordEmail;
	private String discordId;
	
	private Collection<? extends GrantedAuthority> authorities;
    private Map<String, Object> attributes;
    
	public CustomUserPrincipal(String discordEmail, String discordId,
			Collection<? extends GrantedAuthority> authorities) {
		this.discordEmail = discordEmail;
		this.discordId = discordId;
		this.authorities = authorities;
	}
	public static CustomUserPrincipal create(UserEntity userEntity) {
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(userEntity.getDiscordEmail()));
        return new CustomUserPrincipal(userEntity.getDiscordEmail(), Long.toString(userEntity.getDiscordId()), authorities);
    }
	@Override
	public String getUsername() {
		return discordEmail;
	}
	@Override
	public String getPassword() {
		return discordId;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
}
