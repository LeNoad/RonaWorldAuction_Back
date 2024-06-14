package kr.mmgg.auction.login.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.mmgg.auction.login.entity.UserEntity;

@Mapper
@Repository
public interface LoginRepository {
	public Integer verifyRegister(Long discordId);
	public void register(@Param("user") UserEntity userEntity);
	public UserEntity selectUser(Long discordId);
	public UserEntity selectUserForDiscordEmail(String discordEmail);
}
