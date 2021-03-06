package com.tts.ecommerce.model;

import java.util.Collection;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class User implements UserDetails {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty
  String username;
  @NotEmpty
  String password;

  @ElementCollection
  Map<Product, Integer> cart;

  public User(@NotEmpty String username, @NotEmpty String password, Map<Product, Integer> cart) {
      this.username = username;
      this.password = password;
      this.cart = cart;
  }

  public Long getId() {
      return id;
  }

  public void setUsername(String username) {
      this.username = username;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public Map<Product, Integer> getCart() {
      return cart;
  }

  public void setCart(Map<Product, Integer> cart) {
      this.cart = cart;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
      return null;
  }

  @Override
  public String getPassword() {
      return this.password;
  }

  @Override
  public String getUsername() {
      return this.username;
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

  public User() {

  }
}
