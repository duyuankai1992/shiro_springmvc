package com.yztc.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class TestShiro {

    @Test
    public void test1(){
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =
                new UsernamePasswordToken("admin","jack");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(true,subject.isAuthenticated());
        subject.logout();

    }

    @Test
    public void test2(){
       Factory<SecurityManager> factory =
               new IniSecurityManagerFactory("classpath:shiro-realm.ini");
       SecurityManager manager = factory.getInstance();
       SecurityUtils.setSecurityManager(manager);
       Subject subject = SecurityUtils.getSubject();
       UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();

    }


    @Test
    public void test3(){
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("1234","123");
        try {
            subject.login(token);
        } catch ( UnknownAccountException uae ) {
            //username wasn't in the system, show them an error message?
            uae.printStackTrace();

        } catch ( IncorrectCredentialsException ice ) {
            //password didn't match, try again?
            ice.printStackTrace();
        } catch ( LockedAccountException lae ) {
            //account for that username is locked - can't login.  Show them a message?
            lae.printStackTrace();
        }
        catch ( AuthenticationException ae ) {
        //unexpected condition - error?
            ae.printStackTrace();
    }

        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();

    }


}
