package com.yztc.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm{
    public String getName() {
        return "MyRealm2";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password =  new String((char[]) token.getCredentials());
        if(!"admin".equals(username)){
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
