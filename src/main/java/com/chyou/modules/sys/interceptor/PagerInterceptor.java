package com.chyou.modules.sys.interceptor;

import com.chyou.common.persistence.SystemContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PagerInterceptor extends HandlerInterceptorAdapter {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        int offset = this.getOffset(request);
        int pagesize = this.getPagesize(request);
        String searchValue = this.getSearchValue(request);
        SystemContext.setOffset(offset);
        SystemContext.setPageSize(pagesize);
        SystemContext.setSearchValue(searchValue);
        request.setAttribute("offset", offset);
        request.setAttribute("pagesize", pagesize);
        request.setAttribute("searchValue", searchValue);
        return true;
    }

    private String getSearchValue(HttpServletRequest request) {
        return request.getParameter("searchValue");
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        request.setAttribute("offset", SystemContext.getOffset());
        request.setAttribute("pagesize", SystemContext.getPageSize());
        request.setAttribute("searchValue", SystemContext.getSearchValue());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        SystemContext.removeOffset();
        SystemContext.removePageSize();
        SystemContext.removeSearchValue();
    }


    protected int getOffset(HttpServletRequest request) {
        int offset = SystemContext.getOffset();
        String strOffset = request.getParameter("pager.offset");

        try {
            if (strOffset != null && !"".equals(strOffset)) {
                offset = Integer.parseInt(strOffset);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return offset;
    }

    protected int getPagesize(HttpServletRequest request) {
        int pagesize = SystemContext.getPageSize();
        String strPagesize = request.getParameter("pagesize");

        try {
            if (strPagesize != null && !"".equals(strPagesize)) {
                pagesize = Integer.parseInt(strPagesize);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return pagesize;
    }


}
