package bitc.fullstack503.team1.util;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ScriptUtil {

    public static void init(HttpServletResponse res){
        res.setContentType("text/html; charset=utf-8");
        res.setCharacterEncoding("utf-8");
    }

    // alert 를 controller 에서 사용가능하도록 만든 util (alert 메세지만 출력)
    public static void alert(HttpServletResponse res, String alertText) throws IOException {
        init(res);
        PrintWriter out = res.getWriter();
        out.println("<script>alert('" + alertText + "')</script>");
        out.flush();
    }
    // alert 를 controller 에서 사용가능하도록 만든 util (alert + 페이지이동 )
    public static void alertAndPage(HttpServletResponse res, String alertText, String page) throws IOException {
        init(res);
        PrintWriter out = res.getWriter();
        out.println("<script>alert('" + alertText + "'); location.href='" + page + "'</script>");
        out.flush();
    }
    public static void alertAndBack(HttpServletResponse res, String alertText) throws IOException {
        init(res);
        PrintWriter out = res.getWriter();
        out.println("<script>alert('" + alertText + "'); history.back(); </script>");
        out.flush();
    }
}
