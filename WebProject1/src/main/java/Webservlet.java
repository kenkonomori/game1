

//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class WebServret
// */
//@WebServlet(name = "WebServlet", urlPatterns = { "/WebServlet" })
//public class Webservlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Webservlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}

//import java.io.IOException;
//import java.io.PrintWriter;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/Webservlet")
//public class Webservlet extends HttpServlet {
//private static final long serialVersionUID = 1L;
//
//public Webservlet() {
//super();
//}
//
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//response.setContentType("text/html; charset=Shift_JIS");
//
//// HTMLレスポンスの生成（LoopServletの処理を統合）
//PrintWriter out = response.getWriter();
//out.println("<html>");
//out.println("<head>");
//out.println("<title>Webservlet</title>");
//out.println("</head>");
//out.println("<body>");
//
//// ループでHTMLを生成（サンプル1〜5を出力）
//for (int i = 1; i <= 5; i++) {
//out.print("<p>サンプル");
//out.println(i);
//out.print("</p>");
//}
//
//out.println("</body>");
//out.println("</html>");
//}
//
//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//doGet(request, response);
//}
//}


//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//サーブレットでフォームから送信されたデータを受け取り、それをリクエスト属性としてJSPに渡す

//@WebServlet(name = "WebServlet", urlPatterns = { "/submitMessage" })
//public class Webservlet extends HttpServlet {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	        throws ServletException, IOException {
//		
//		//フォームから贈られたデータを取得
//		request.setCharacterEncoding("UTF-8");
//		
//	   String name = request.getParameter("name");
//	   String message = request.getParameter("message");
//	   
//	   System.out.println("名前: " + name);
//       System.out.println("メッセージ: " + message);
//	   
//	   //データをリクエスト属性にセット
//	   request.setAttribute("name", name);
//	   request.setAttribute("message", message);
//	   
//	   // 結果を表示するJSPにフォワード
//	   request.getRequestDispatcher("/WEB-INF/view/showMessage.jsp").forward(request, response);
//	}
//
//    }
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//@WebServlet(name = "WebServlet", urlPatterns = { "/submitMessage" })
//public class Webservlet extends HttpServlet {
//
//    // GETリクエストが来たとき：フォーム入力画面に転送する
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("/WEB-INF/view/input.jsp").forward(request, response);
//    }
//
//    // POSTリクエストが来たとき：入力されたデータを処理して、結果表示画面に渡す
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String name = request.getParameter("name");
//        String message = request.getParameter("message");
//
//        request.setAttribute("name", name);
//        request.setAttribute("message", message);
//
//        request.getRequestDispatcher("/WEB-INF/view/showMessage.jsp").forward(request, response);
//    }
//}
