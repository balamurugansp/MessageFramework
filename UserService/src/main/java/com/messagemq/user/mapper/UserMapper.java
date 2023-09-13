package com.messagemq.user.mapper;

import org.springframework.beans.BeanUtils;

import com.messagemq.userservice.dto.UserEntity;
import com.messagemq.userservice.model.UserModel;

public class UserMapper extends BaseMapper<UserEntity, UserModel> {

	@Override
	public UserEntity convertToEntity(UserModel dto, Object... args) {
		UserEntity userEntity = new UserEntity();
		if (dto != null) {
			BeanUtils.copyProperties(dto, userEntity);
		}
		return userEntity;
	}

	@Override

	public UserModel convertToDto(UserEntity entity, Object... args) {
		UserModel user = new UserModel();
		if (entity != null) {
			BeanUtils.copyProperties(entity, user);
		}
		return user;
	}
}

