package ajc.sopra.demoBoot.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "compte")
//pour spring un utilisateur c'est une instance de UserDetails
//on implemente l'interface pour que notre Compte soit une instance de UserDetails
public class Compte implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Column(name = "login", length = 200, nullable = false, unique = true)
	private String login;
	@NotBlank
	@Column(name = "mdp", length = 255, nullable = false)
	private String mdp;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;

	public Compte() {

	}

	public Compte(@NotBlank String login, @NotBlank String mdp, Role role) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// spring 1 role =>GrantedAuthority
		// transforme mon role(Enum) =>Collection<GrantedAuthority>
		// SimpleGrantedAuthority permet la creation d'un GrantedAuthority avec un
		// String
		return Arrays.asList(new SimpleGrantedAuthority(role.toString()));
	}

	@Override
	public String getPassword() {
		return mdp;
	}

	@Override
	public String getUsername() {
		return login;
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

}
