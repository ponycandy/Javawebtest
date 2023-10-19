package loginservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 // 设置请求对象字符编码格式
        request.setCharacterEncoding("utf-8");
        // 获取登录表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 判断登录是否成功
        if (username.equals("ponycandy") && password.equals("15397")) {
            // 采用重定向，跳转到登录成功页面
            response.sendRedirect("success.jsp?username=" + URLEncoder.encode(username, "utf-8"));
        } else {
            // 采用重定向，跳转到登录失败页面
            response.sendRedirect("failure.jsp?username=" + URLEncoder.encode(username, "utf-8"));
        }
	}

}
