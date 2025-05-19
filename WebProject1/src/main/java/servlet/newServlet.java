package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 一時的にユーザー情報を保存するマップ（本来はDBなど）
@WebServlet(name = "newServlet", urlPatterns = { "/newuser" })
public class newServlet extends HttpServlet {

    // 簡単な保存場所（アプリ全体で共有するため static にする）
    private static Map<String, String> userMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/new.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        if (id == null || pass == null || id.isEmpty() || pass.isEmpty()) {
            request.setAttribute("error", "IDとパスワードは必須です");
            request.getRequestDispatcher("/WEB-INF/view/new.jsp").forward(request, response);
            return;
        }

        else if (userMap.containsKey(id)) {
            request.setAttribute("error", "そのIDは既に使われています");
            request.getRequestDispatcher("/WEB-INF/view/new.jsp").forward(request, response);
            return;
        }
        else {

        // 登録処理
        userMap.put(id, pass);

        // 成功 → ログイン画面にリダイレクト
        response.sendRedirect(request.getContextPath() + "/homepage");
    }
        }
    

    // 他のサーブレットが使えるようにユーザー一覧を返す
    public static boolean isValidUser(String id, String pass) {
        return pass.equals(userMap.get(id));
    }
    
}
