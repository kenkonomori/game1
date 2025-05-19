package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.LoginModel;
//test1クラスがhomepageというURLパスにマッピングされる
@WebServlet(name = "test1", urlPatterns = { "/homepage" })
public class test1 extends HttpServlet {

    // GETリクエストが来たとき：フォーム入力画面に転送する
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/input.jsp").forward(request, response);
    }

    // POSTリクエストが来たとき：入力されたデータを処理して、結果表示画面に渡す
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        
        boolean check = LoginModel.checkuser(id, pass);
        
        HttpSession session = request.getSession();
        session.setAttribute("id", id); // ログイン成功後などに

        request.setAttribute("id", id);
        request.setAttribute("pass", pass);
        
        if(check) {
        	request.getRequestDispatcher("/WEB-INF/view/display.jsp").forward(request, response);
        }
        else {
        	request.setAttribute("error", "IDまたはパスワードが間違っています");
        	request.getRequestDispatcher("/WEB-INF/view/input.jsp").forward(request, response);
        }
    }
}
