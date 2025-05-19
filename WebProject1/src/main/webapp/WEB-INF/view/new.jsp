<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>新規登録フォーム</title>
	<style>
        body, html {
            height: 100%;
            margin: 0;         
    		background-image: url("${pageContext.request.contextPath}/image/2.jpg");/* 背景画像のパス */
    		background-size: cover;          /* 全体に広げる */
    		background-position: center;     /* 中央に配置 */
    		background-repeat: no-repeat;    /* 繰り返さない */
	  		
	        }
        .center-container {
            display: flex;            /*フレックスボックスを有効にする*/
            justify-content: center;  /* 横方向中央寄せ */
            align-items: center;      /* 縦方向中央寄せ */
            height: 100vh;			  /* 画面の高さ全体を使う */
            text-align: center;		  /* テキストやインライン要素を中央寄せ */
            flex-direction: column;   /* 縦に並べたいときに便利 */
        }
    
  		
   </style>
</head>
<body>
	<div class ="center-container">	
	<h2>新規登録</h2>
	<form action="newuser" method="POST">
		<h4>ユーザーID</h4>
        <input type="text" name ="id"><br>
        <h4>パスワード</h4>
        <input type="password" name = "pass"><br><br>
        <input type="submit" value="登録する" >
    </form>    
        <form action="logout" method="POST">
        <input type="submit" value="戻る">
    </form>
    
    
     <p style="color: red;">
        <%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
    </p>
    </div>
    </body>
    </html>