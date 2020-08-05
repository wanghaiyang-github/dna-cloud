package com.bazl.dna.lims.core.shiro;

import com.bazl.dna.lims.core.common.Constants;
import com.bazl.dna.lims.core.model.po.LoaPermission;
import com.bazl.dna.lims.core.model.po.LoaRole;
import com.bazl.dna.lims.core.model.po.LoaUserInfo;
import com.bazl.dna.lims.core.service.LoaPermissionService;
import com.bazl.dna.lims.core.service.LoaRoleService;
import com.bazl.dna.lims.core.service.LoaUserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Sun on 2018/12/20.
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private LoaUserInfoService userInfoService;
    @Autowired
    private LoaRoleService roleService;
    @Autowired
    private LoaPermissionService permissionService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token

        LoaUserInfo user = new LoaUserInfo();
        String[] userAreaStr=utoken.getUsername().split("-");
        user = userInfoService.selectByUserNameAndAreaCode(userAreaStr[0], userAreaStr[1]);

        if (user == null) {
            throw new UnknownAccountException("账号不存在！");
        }
        if (user.getActiveFlag() != null && Constants.user_active_flase.equals(user.getActiveFlag())) {
            throw new LockedAccountException("帐号已被锁定，禁止登录！");
        }
        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(user, user.getLoginPassword(),this.getClass().getName());
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        LoaUserInfo user = (LoaUserInfo) SecurityUtils.getSubject().getPrincipal();
        String userId = user.getUserId();

        // 赋予角色
        List<LoaRole> roleList = roleService.listRolesByUserId(userId);
        for (LoaRole role : roleList) {
            info.addRole(role.getRoleName());
        }

        // 赋予权限
        List<LoaPermission> permissionList = permissionService.selectBySubSystemAndUserId(Constants.SUBSYSTEM_LIMS, userId);
//        for (LoaRole role : roleList) {
//            if(role != null && !StringUtils.isEmpty(role.getRoleId())){}
//            List<LoaPermission> permissionList = permissionService.listByRoleId(role.getRoleId());
            if (!CollectionUtils.isEmpty(permissionList)) {
                for (LoaPermission permission : permissionList) {
                    if (!StringUtils.isEmpty(permission.getPermissionName())) {
                        info.addStringPermission(permission.getPermissionName());
                    }
                }
            }
//        }
        return info;
    }
}
