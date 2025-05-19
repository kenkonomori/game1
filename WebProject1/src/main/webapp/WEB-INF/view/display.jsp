<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.*, model.ScoreEntry" %>
<%
    List<ScoreEntry> ranking = (List<ScoreEntry>) application.getAttribute("rankingList");
    String userId = (String) request.getAttribute("id");
%>
<html>
<head>
  <title>ようこそ！マイページ</title>
  <!-- Bootstrap 5 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <!-- Icons -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
  
  <style>
    body {
      background: linear-gradient(to right, #dfe9f3, #ffffff);
      min-height: 100vh;
    }
    .center-box {
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      height: 80vh;
    }
    .card {
      padding: 2rem;
      border-radius: 1rem;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
      text-align: center;
    }
    .start-btn {
      font-size: 1.2rem;
      padding: 10px 30px;
      border-radius: 50px;
      margin-top: 20px;
      transition: 0.3s;
    }
    .start-btn:hover {
      background-color: #0d6efd;
      color: white;
    }
  </style>
</head>
<body>

<!-- ヘッダー：マイページドロップダウン -->
<nav class="navbar navbar-light bg-light px-3">
  <span class="navbar-brand mb-0 h1"><i class="fas fa-keyboard"></i> タイピングゲーム</span>
  <div class="dropdown">
    <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
      <i class="fas fa-user-circle"></i> マイページ
    </button>
    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton">
      <li><a class="dropdown-item" href="profile.jsp"><i class="fas fa-id-card"></i> プロフィール</a></li>
      <li><a class="dropdown-item" href="settings.jsp"><i class="fas fa-cog"></i> 設定</a></li>
      <li><hr class="dropdown-divider"></li>
      <li><a class="dropdown-item text-danger" href="logout"><i class="fas fa-sign-out-alt"></i> ログアウト</a></li>
    </ul>
  </div>
</nav>

<!-- メインカード -->
<div class="container center-box">
  <div class="card">
    <h2 class="mb-3">こんにちは、<%= request.getAttribute("id") %>さん！</h2>
    <p class="text-muted">難易度を選んでください</p>
    <button class="btn btn-outline-primary start-btn" onclick="window.open('game/game1.jsp', '_blank', 'width=800,height=600')">
      <i class="fas fa-play"></i> 初級
    </button>
     <button class="btn btn-outline-primary start-btn" onclick="window.open('game/game2.jsp', '_blank', 'width=800,height=600')">
      <i class="fas fa-play"></i> 中級
    </button>
     <button class="btn btn-outline-primary start-btn" onclick="window.open('game/game3.jsp', '_blank', 'width=800,height=600')">
      <i class="fas fa-play"></i> 上級
    </button>
  </div>
  <!-- ランキングセクション -->
<div class="container mt-4">
  <h3>🏆 ランキング</h3>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>順位</th>
        <th>ユーザー</th>
        <th>スコア</th>
      </tr>
    </thead>
    <tbody>
      <%
        if (ranking != null) {
          int rank = 1;
          for (ScoreEntry entry : ranking) {
      %>
        <tr<%= entry.getId().equals(userId) ? " class='table-warning'" : "" %>>
          <td><%= rank++ %></td>
          <td><%= entry.getId() %></td>
          <td><%= entry.getScore() %></td>
        </tr>
      <%
          }
        } else {
      %>
        <tr><td colspan="3">ランキング情報がありません</td></tr>
      <%
        }
      %>
    </tbody>
  </table>
</div>
</div>

</body>
</html>
