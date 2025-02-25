package bitc.fullstack503.team1.util;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class CheckLogin implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        HttpSession session = req.getSession();
        if(session.getAttribute("userId") == null){
            System.out.println(" 비 로그인 상태 ");
            ScriptUtil.alertAndPage(res,"로그인이 필요합니다.","/khamro");
            return false;
        }else{
            System.out.println(" 로그인 상태 ");
//            session.setMaxInactiveInterval(60*60*2);
            return true;
        }
    }
}
