package com.xrk.web.controller;

import com.google.common.collect.Maps;
import com.xrk.entity.Role;
import com.xrk.entity.User;
import com.xrk.entity.UserRole;
import com.xrk.service.role.RoleService;
import com.xrk.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户
 *
 * @author tong
 *         2013-11-19
 * @version 1.0v
 * @Email: luomingtong@163.com
 */
@Controller
@RequestMapping("/admin/background/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService rolesService;

    /**
     * 用户列表
     *
     * @param model
     * @param userName
     * @param userNickname
     * @param pageNow
     * @return
     */
    @RequestMapping("query")
    public String query(Model model, String userName, String userNickname, Integer pageNow) {
        Map<String, Object> params = Maps.newHashMap();
        if (StringUtils.isNotBlank(userName)) params.put("userName", userName);
        if (StringUtils.isNotBlank(userNickname)) params.put("userNickname", userNickname);

        List<Map<String, Object>> pageBean = userService.findAllByPage(params);
        model.addAttribute("pageView", pageBean);
        return "/background/user/list";
    }

    /**
     * 保存数据
     * @param redirectAttributes
     * @param user
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Map<String, String> add(RedirectAttributes redirectAttributes, Model model, User user) {
        Map<String,String> res = new HashMap<String, String>();
        int result = userService.add(user);
        res.put("msg","success");
        if (result > 0){
            res.put("msg", "success");
        }else {
            res.put("msg", "error");
        }
        return res;
    }

    /**
     * 新增界面
     *
     * @return
     */
    @RequestMapping("addUI")
    public String addUI() {
        return "/background/user/add";
    }

    /**
     * 删除
     *
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteById")
    public Map<String, String> deleteById(Model model, String userId) {
        Map<String, String> res = new HashMap<String, String>();
        int result = userService.deleteById(userId);

        res.put("msg", "success");
        if (result > 0) {
            res.put("msg", "success");
        } else {
            res.put("msg", "error");
        }
        return res;
    }

    /**
     * 修改界面
     *
     * @param model
     * @return
     */
    @RequestMapping("getById")
    public String getById(Model model, String userId, int type) {
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        List<Role> roles = rolesService.findAll();
        model.addAttribute("roles", roles);
        if (type == 1) {
            return "/background/user/edit";
        } else {
            return "/background/user/show";
        }
    }

    /**
     * 修改
     *
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public Map<String, String> update(Model model, User user, UserRole userRoles) {
        Map<String, String> res = new HashMap<String, String>();
        int result = userService.update(user);
        if (userRoles.getRoleId() != null){
            rolesService.saveUserRole(userRoles);
        }

        res.put("msg", "success");
        if (result > 0) {
            res.put("msg", "success");
        } else {
            res.put("msg", "error");
        }

        return res;
    }

    /**
     * 删除所选的
     *
     * @param model
     * @return
     */
    @RequestMapping("deleteAll")
    public String deleteAll(Model model, String[] check) {
        for (String string : check) {
            userService.deleteById(string);
        }
        return "redirect:query";
    }

    /**
     * 给用户分配角色界面
     *
     * @return
     */
    @RequestMapping("userRole")
    public String userRole(Model model, String userId) {
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        List<Role> roles = rolesService.findAll();
        model.addAttribute("roles", roles);
        return "/background/user/userRole";
    }

    /**
     * 保存用户分配角色
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("allocation")
    public String allocation(Model model, UserRole userRoles) {
        String errorCode = "1000";
        try {
            rolesService.saveUserRole(userRoles);
        } catch (Exception e) {
            e.printStackTrace();
            errorCode = "1001";
        }
        return errorCode;
    }
}