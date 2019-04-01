//package com.demo.common;
//
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class CustomRealm extends AuthorizingRealm {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private PermissionService permissionService;
//
//    /**
//     * 认证
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        // 获取用户名
//        String userName = (String) token.getPrincipal();
//        // 通过用户名获取用户对象
//        User user = this.userService.findUserByUserName(userName);
//
//        if (user == null) {
//            return null;
//        }
//
//        // 通过 userId 获取该用户拥有的所有权限，返回值根据自己需求编写，并非固定值。
//        Map<String,List<Permission>> permissionMap = this.permissionService.getPermissionMapByUserId(user.getId());
//
//        // （目录+菜单，分层级，用于前端 jsp 遍历）
//        user.setMenuList(permissionMap.get("menuList"));
//        // （目录+菜单+按钮，用于后端权限判断）
//        user.setPermissionList(permissionMap.get("permissionList"));
//
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
//
//        return info;
//    }
//
//    /**
//     * 授权
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        User user = (User) principals.getPrimaryPrincipal();
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//        // （目录+菜单+按钮，用于后端权限判断）
//        List<Permission> permissionList = user.getPermissionList();
//
//        for (Permission permission : permissionList) {
//            if (StringUtil.isNotEmpty(permission.getCode())) {
//                info.addStringPermission(permission.getCode());
//            }
//        }
//
//        return info;
//    }
//}