package com.mycompany;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 *
 * @see com.mycompany.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<HomePage> getHomePage()
    {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init()
    {
        super.init();

        // add your configuration here
        mountPage("/MyPage.html", MyPage.class);
        mountPage("/ChildPage.html", ChildPage.class);
        mountPage("/SignUpPage.html", SignUpPage.class);
        mountPage("/ProductListPage.html", ProductListPage.class);

        // lookup resource also in webapp directory
        // see https://cwiki.apache.org/WICKET/control-where-html-files-are-loaded-from.html#ControlwhereHTMLfilesareloadedfrom-InWicket1.4
        // mount webapp directory for resources
        getResourceSettings().addResourceFolder("");

        // skip package directory
        getResourceSettings().setResourceStreamLocator(new PathStripperLocator());
    }

//	@Override
    public Session newSession(Request request, Response response) {

        HttpServletRequest hsr = (HttpServletRequest) request.getContainerRequest();

        // setting a mobile style at session creation time after some dumb user agent sniffing
        Session session = (Session) super.newSession(request, response);

        String userAgent = hsr.getHeader("User-Agent");
        System.out.printf("user agent is %s", userAgent);
        if (userAgent != null
                && userAgent.contains("Mobile")) {
            session.setStyle("mobile");
        }

        return session;
    }

}
