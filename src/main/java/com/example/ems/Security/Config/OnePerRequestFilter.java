//package com.example.ems.Security.Config;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.web.context.request.async.WebAsyncUtils;
//import org.springframework.web.filter.GenericFilterBean;
//
//import java.io.IOException;
//
//public abstract class  OnePerRequestFilter extends GenericFilterBean {
//    public static final String ALREADY_FILTERED_SUFFIX = ".FILTERED";
//
//    public void OncePerRequestFilter() {
//    }
//
//    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if (request instanceof HttpServletRequest httpRequest) {
//            if (response instanceof HttpServletResponse httpResponse) {
//                String alreadyFilteredAttributeName = this.getAlreadyFilteredAttributeName();
//                boolean hasAlreadyFilteredAttribute = request.getAttribute(alreadyFilteredAttributeName) != null;
//                if (!this.skipDispatch(httpRequest) && !this.shouldNotFilter(httpRequest)) {
//                    if (hasAlreadyFilteredAttribute) {
//                        if (DispatcherType.ERROR.equals(request.getDispatcherType())) {
//                            this.doFilterNestedErrorDispatch(httpRequest, httpResponse, filterChain);
//                            return;
//                        }
//
//                        filterChain.doFilter(request, response);
//                    } else {
//                        request.setAttribute(alreadyFilteredAttributeName, Boolean.TRUE);
//
//                        try {
//                            this.doFilterInternal(httpRequest, httpResponse, filterChain);
//                        } finally {
//                            request.removeAttribute(alreadyFilteredAttributeName);
//                        }
//                    }
//                } else {
//                    filterChain.doFilter(request, response);
//                }
//
//                return;
//            }
//        }
//
//        throw new ServletException("OncePerRequestFilter only supports HTTP requests");
//    }
//
//    private boolean skipDispatch(HttpServletRequest request) {
//        if (this.isAsyncDispatch(request) && this.shouldNotFilterAsyncDispatch()) {
//            return true;
//        } else {
//            return request.getAttribute("jakarta.servlet.error.request_uri") != null && this.shouldNotFilterErrorDispatch();
//        }
//    }
//
//    protected boolean isAsyncDispatch(HttpServletRequest request) {
//        return DispatcherType.ASYNC.equals(request.getDispatcherType());
//    }
//
//    protected boolean isAsyncStarted(HttpServletRequest request) {
//        return WebAsyncUtils.getAsyncManager(request).isConcurrentHandlingStarted();
//    }
//
//    protected String getAlreadyFilteredAttributeName() {
//        String name = this.getFilterName();
//        if (name == null) {
//            name = this.getClass().getName();
//        }
//
//        return name + ".FILTERED";
//    }
//
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        return false;
//    }
//
//    protected boolean shouldNotFilterAsyncDispatch() {
//        return true;
//    }
//
//    protected boolean shouldNotFilterErrorDispatch() {
//        return true;
//    }
//
//    protected abstract void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException;
//
//    protected void doFilterNestedErrorDispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        filterChain.doFilter(request, response);
//    }
//}
