package com.vuanhvu.blog.auth;

import com.vuanhvu.blog.entity.User;
import com.vuanhvu.blog.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyCustomFbLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private UserServiceImpl userService;

    public MyCustomFbLoginSuccessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
        User user = userService.processOAuthPostLogin(oauthUser.getEmail(), oauthUser.getOauth2ClientName());
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId().toString());


        String redirectUrl = (String) session.getAttribute("url_prior_login");
        if (redirectUrl != null) {
            session.removeAttribute("url_prior_login");
            response.sendRedirect(redirectUrl);
        } else {
            response.sendRedirect("/");
        }
    }
}
