package hieu.nv.jpa.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hieu.nv.jpa.group.entity.Group;
import hieu.nv.jpa.role.entity.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;
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
