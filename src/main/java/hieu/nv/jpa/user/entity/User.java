package hieu.nv.jpa.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hieu.nv.jpa.group.entity.Group;
import hieu.nv.jpa.role.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "user[roles]", attributeNodes = {@NamedAttributeNode("roles")}),
        @NamedEntityGraph(name = "user[h_groups]", attributeNodes = {@NamedAttributeNode("h_groups")}),
        @NamedEntityGraph(name = "user[roles][h_groups]", attributeNodes = {
                @NamedAttributeNode("roles"),
                @NamedAttributeNode("h_groups")
        })
})
public class User {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Transient
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    @JsonManagedReference
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_groups",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    @ToString.Exclude
    @JsonManagedReference
    private Set<Group> h_groups;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "short_type")
//    @Enumerated(EnumType.STRING)
    private UserShortType shortType;

    public enum UserType {
        ADMIN,
        USER,
        GUEST
    }

    public enum UserShortType {
        ADMIN("A"),
        USER("U"),
        GUEST("G");
        private final String code;

        UserShortType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static UserShortType fromCode(String code) {
            for (UserShortType userType : UserShortType.values()) {
                if (userType.getCode().equals(code)) {
                    return userType;
                }
            }
            throw new IllegalArgumentException("Unknown code: " + code);
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
