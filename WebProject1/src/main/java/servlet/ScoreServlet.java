package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.ScoreEntry; // ← これが追加

@WebServlet("/submitScore")
public class ScoreServlet extends HttpServlet {
    private static final List<ScoreEntry> scores = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String id = request.getParameter("id");
        int score = Integer.parseInt(request.getParameter("score"));

        scores.add(new ScoreEntry(id, score));
        scores.sort((a, b) -> Integer.compare(b.getScore(), a.getScore())); // 修正：getterを使用

        getServletContext().setAttribute("rankingList", scores);
        request.setAttribute("ranking", scores);
        request.getRequestDispatcher("/WEB-INF/view/display.jsp").forward(request, response);
    }
}
