//package com.example.ems.Security.User;
//
//import java.io.Serializable;
//import java.util.Collection;
//
//public interface UserDetails extends Serializable {
//Collection<? extends GrantedAuthority> getAuthorities();
//    String getPassword();
//
//    String getUsername();
//
//    default boolean isAccountNonExpired() {
//        return true;
//    }
//
//    default boolean isAccountNonLocked() {
//        return true;
//    }
//
//    default boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    default boolean isEnabled() {
//        return true;
//    }
//}
