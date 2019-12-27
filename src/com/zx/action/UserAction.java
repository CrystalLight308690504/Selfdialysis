package com.zx.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zx.entity.User;
import com.zx.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * 用户模块
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    @Autowired
    private UserService userService;
    private User user;

    /**
     * 登入验证
     *
     * @return
     * @throws Exception
     */
    public String login() {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        Object userSession = session.get("user");
        if (userSession != null) { // 如果登入过
            return "toCenter";
        }

        User findUser = userService.getByName(user.getName());
        if (findUser == null) {
            actionContext.put("messages", "该账号不存在");
            return "toLogin";
        } else if (!findUser.getPassword().equals(user.getPassword())) {
            actionContext.put("messages", "密码错误");
            return "toLogin";
        }
        actionContext.getSession().put("user", findUser);
        return "toCenter";
    }

    /**
     * 退出登入
     *
     * @return
     * @throws Exception
     */
    public String unLogin() {
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        User user = (User) session.get("user");
        if (user != null) {
            session.remove("user");
            session.put("user", null);
        }
        return "toLogin";
    }

    /**
     * 转到注册页面
     *
     * @return
     * @throws Exception
     */
    public String toRegisterUi() throws Exception {
        return "toRegisterUi";
    }

    /**
     * 注册验证
     *
     * @return
     * @throws Exception
     */
    public String register() {
        ActionContext actionContext = ActionContext.getContext();
        if (user.getName() != null || user.getPassword() != null) {// 如果账号或者密码不为空
            User findUser = userService.getByName(user.getName());
            if (user.getName().trim().equals("") || user.getPassword().trim().equals("")) {// 如果账号或者密码为空
                actionContext.put("messages", "请填写账号和密码");
                return "toRegisterUi";
            }
            if (findUser != null) {//如果用户已经存在
                actionContext.put("messages", "该用户已经存在!");
                return "toRegisterUi";
            }
            userService.save(user);
            return "toLogin";
        } else {
            actionContext.put("messages", "请填写账号和密码");
            return "toRegisterUi";
        }
    }

    /**
     * 转到编辑用户页面,页面
     *
     * @return
     * @throws Exception
     */
    public String toEditorUi() throws Exception {
        return "toEditorUi";
    }

    /**
     * 修改用户信息
     *
     * @return
     * @throws Exception
     */
    public String editor() {
        ActionContext actionContext = ActionContext.getContext();
        User sessionUser = (User) actionContext.getSession().get("user");

        if (!user.getPassword().equals(user.getPasswordAgain())) { // 验证新密码是否一致
            actionContext.put("messages", "新密码不一致!");
            return "toEditorUi";
        }

        if (sessionUser.getPassword().equals(user.getOldPassword())) { // 验证原密码
            sessionUser.setPassword(this.user.getPassword());
            sessionUser.setGender(this.user.getGender());
            userService.update(sessionUser);
            actionContext.put("messages", "修改成功!");
            return "toEditorUi";
        } else {
            actionContext.put("messages", "原密码错误!");
            return "toEditorUi";
        }
    }

    @Override
    public User getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }
}
