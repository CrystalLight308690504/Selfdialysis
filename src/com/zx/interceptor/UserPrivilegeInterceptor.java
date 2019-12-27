package com.zx.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class UserPrivilegeInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        //得到正在执行的代理对象
        ActionProxy proxy = actionInvocation.getProxy();

        //通过代理对象得到正在执行的方法
        String method = proxy.getMethod();

        // 获取session
        ActionContext actionContext = actionInvocation.getInvocationContext();
        Map<String, Object> session = actionContext.getSession();

        // 如果不是登入\注册方法
        if (method.equals("login") || method.equals("toRegisterUi") || method.equals("register")) {
            return actionInvocation.invoke();
        } else {
            Object user = session.get("user");
            if (user == null) { // 如果没有登入过
                actionContext.put("messages", "请先登入!");
                return "toLogin";
            } else {
                return actionInvocation.invoke();
            }
        }
    }
}
