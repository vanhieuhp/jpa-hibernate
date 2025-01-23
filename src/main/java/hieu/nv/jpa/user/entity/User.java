package hieu.nv.jpa.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
@NamedEntityGraphs({
        @NamedEntityGraph(name = UserJoinOptions.USER_ROLE, attributeNodes = {@NamedAttributeNode("roles")}),
        @NamedEntityGraph(name = UserJoinOptions.USER_GROUP, attributeNodes = {@NamedAttributeNode("h_groups")}),
        @NamedEntityGraph(name = UserJoinOptions.USER_ROLE_GROUP, attributeNodes = {
                @NamedAttributeNode("roles"),
                @NamedAttributeNode("h_groups")
        }),
        @NamedEntityGraph(name = UserJoinOptions.USER_LANGUAGE, attributeNodes = {@NamedAttributeNode("languages")}),
        @NamedEntityGraph(name = UserJoinOptions.USER_ROLE_LANGUAGE, attributeNodes = {
                @NamedAttributeNode("languages"),
                @NamedAttributeNode("roles")
        })
})
public class User {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "username")
    private String username;

    @Transient
    @Column(name = "email")
    private String email;

    @Transient
    @Column(name = "first_name")
    private String firstName;

    @Transient
    @Column(name = "last_name")
    private String lastName;

    @Transient
    @Column(name = "phone_number")
    private String phoneNumber;

    @Transient
    private String fullName;

    @Transient
    @Formula("concat(first_name, ' ', last_name)")
    private String displayName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    @JsonManagedReference
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_groups",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    @ToString.Exclude
    @JsonManagedReference
    private Set<Group> h_groups;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Language> languages;

//    @Transient
    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Transient
    @Column(name = "short_type")
//    @Enumerated(EnumType.STRING)
    private UserShortType shortType;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
