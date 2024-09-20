package hieu.nv.jpa.user.converter;

import hieu.nv.jpa.user.entity.User;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserShortTypeConverter implements AttributeConverter<User.UserShortType, Character> {

	@Override
	public Character convertToDatabaseColumn(User.UserShortType attribute) {
		if (attribute == null) {
			return null;
		}
		return attribute.getCode().charAt(0);
	}

	@Override
	public User.UserShortType convertToEntityAttribute(Character dbData) {
		if (dbData == null) {
			return null;
		}
		return User.UserShortType.fromCode(dbData.toString());
	}
}
