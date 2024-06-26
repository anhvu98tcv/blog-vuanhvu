//package com.vuanhvu.blog.auth;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.CookieRequestCache;
//import org.springframework.security.web.savedrequest.RequestCache;
//import org.springframework.stereotype.Component;
//import org.thymeleaf.extras.springsecurity5.auth.AuthUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//public class MyCustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//
//    public MyCustomLoginSuccessHandler(String defaultTargetUrl) {
//        setDefaultTargetUrl(defaultTargetUrl);
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        if (session != null) {
//            String redirectUrl = (String) session.getAttribute("url_prior_login");
//            if (redirectUrl != null) {
//                // we do not forget to clean this attribute from session
//                session.removeAttribute("url_prior_login");
//                // then we redirect
//                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
//            } else {
//                super.onAuthenticationSuccess(request, response, authentication);
//            }
//        } else {
//            super.onAuthenticationSuccess(request, response, authentication);
//        }
//    }
//}
