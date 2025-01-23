package hieu.nv.jpa.user.entity;

import lombok.Getter;

@Getter
public class UserJoinOptions {

	public static final String USER_ROLE = "users[roles]";
	public static final String USER_GROUP = "users[groups]";
	public static final String USER_LANGUAGE = "users[languages]";
	public static final String USER_ROLE_GROUP = "users[roles,groups]";
	public static final String USER_ROLE_LANGUAGE = "users[roles,languages]";
	public static final String USER_ROLE_LANGUAGE_GROUP = "users[roles,languages,groups]";
	public static final String USER_LANGUAGE_GROUP = "users[languages,groups]";

}
