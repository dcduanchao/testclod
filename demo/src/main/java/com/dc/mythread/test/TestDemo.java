package com.dc.mythread.test;

/**
 * @author duanchao
 * @CreateDate: 2019/10/21 0021 14:14
 */
public class TestDemo {

    public static void main(String[] args) {

        boolean isV1 = false;
        boolean responseIsSign = false;
        String model = null;
        String appId = null;
        String developerId = null;


        String servletPath = "/v2/guozhomng/detail.do";
        if (servletPath.matches("/v[\\d]+.+") || servletPath.startsWith("/health") || servletPath.startsWith("/gwy")) {
            int modeBeginIndex = servletPath.indexOf("/", servletPath.indexOf("/") + 1) + 1;
            model = servletPath.substring(modeBeginIndex, servletPath.indexOf("/", modeBeginIndex)).replace("/", "");
        } else {
            isV1 = true;
            responseIsSign = true;
            model = servletPath.substring(1, servletPath.indexOf("/", 2)).replace("/", "");
        }

    }
}
