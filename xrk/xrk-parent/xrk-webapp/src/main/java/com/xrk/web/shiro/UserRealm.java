package com.xrk.web.shiro;

/**
 * Created by Tong on 2016/9/20.
 */

import com.xrk.entity.User;
import com.xrk.service.resources.ResourcesService;
import com.xrk.service.role.RoleService;
import com.xrk.service.user.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourcesService resourcesService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        Set<String> roles = roleService.findRoles(username);
        authorizationInfo.setRoles(roles);

        Set<String> permissions = resourcesService.getResources(username);
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

//        UsernamePasswordToken login_token = (UsernamePasswordToken) token;  
//  
//        //校验码判断逻辑  
//        //取得用户输入的校验码  
//        String userInputValidCode = login_token.getValidCode();  
//  
//        //取得真实的正确校验码  
//        String realRightValidCode = (String) SecurityUtils.getSubject().getSession().getAttribute("rand");  
//  
//        if (null == userInputValidCode || !userInputValidCode.equalsIgnoreCase(realRightValidCode)) {  
//            throw new ValidCodeException("验证码输入不正确");  
//        }  

        //以上校验码验证通过以后,查数据库  
        String username = (String) token.getPrincipal();
        User user = userService.queryUserName(username);

        if (user == null) {
            throw new UnknownAccountException();//没找到帐号  
        }

        if (Boolean.FALSE.equals(user.getEnable())) {
            throw new LockedAccountException(); //帐号锁定  
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现  
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(), //用户名
                user.getUserPassword(), //密码
                getName()  //realm name  
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

} 
