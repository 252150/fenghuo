package com.wanjia.infoshopmallmanage.shiro.filter;

import com.alibaba.fastjson.JSON;
import com.wanjia.infoshopmallmanage.entity.AppConstant;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wlj
 * @date: 2020/10/15 10:31
 * @version: 1.0
 */
public class PermFailFilter extends PermissionsAuthorizationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {

        Subject subject = getSubject(request, response);
        // If the subject isn't identified, redirect to login URL
        if (subject.getPrincipal() == null) {
            //跳转至登录页
            redirectToLogin(request,response);
        } else {
            //给前端提示无接口访问权限的错误码
            responseError(response,RestResponse.fail(AppConstant.PermissionDenied,"无权限请求对应api接口",null));
        }
        return false;
    }


    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response){
        responseError(response, RestResponse.fail(AppConstant.authenticationFailure,"登陆时间过长，请重新登陆",null));
    }


    private void responseError(ServletResponse response, RestResponse restResponse) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        try {
            response.getWriter().write(JSON.toJSONString(restResponse));
        } catch ( IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
