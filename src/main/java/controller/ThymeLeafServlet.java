package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

    public class ThymeLeafServlet extends HttpServlet{
       /*
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
// XHTML is the default mode, but we will set it anyway for better understanding of code
            templateResolver.setTemplateMode("XHTML");
            templateResolver.setPrefix("/WEB-INF/");
            templateResolver.setSuffix(".html");
            templateResolver.setCacheTTLMs(3600000L);
            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(templateResolver);
            WebContext ctx = new WebContext(req, resp, getServletConfig().getServletContext(), req.getLocale());
// This will be prefixed with /WEB-INF/ and suffixed with .html
            templateEngine.process("thymeleaf", ctx, resp.getWriter());
            resp.setContentType("text/html;charset=UTF-8");
            resp.setHeader("Pragma", "no-cache");
            resp.setHeader("Cache-Control", "no-cache");
            resp.setDateHeader("Expires", 1000);
        }
*/

    }

