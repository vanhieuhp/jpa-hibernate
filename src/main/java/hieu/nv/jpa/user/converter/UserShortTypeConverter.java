package hieu.nv.jpa.user.converter;

import hieu.nv.jpa.user.entity.UserShortType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserShortTypeConverter implements AttributeConverter<UserShortType, Character> {

    @Override
    public Character convertToDatabaseColumn(UserShortType attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getCode().charAt(0);
    }

    @Override
    public UserShortType convertToEntityAttribute(Character dbData) {
        if (dbData == null) {
            return null;
        }
        return UserShortType.fromCode(dbData.toString());
    }
}
