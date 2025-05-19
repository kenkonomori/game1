<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>タイピングゲーム</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f0f8ff;
    }
    .game-box {
      margin-top: 100px;
      text-align: center;
    }
    #word {
      font-size: 2rem;
      font-weight: bold;
      color: #333;
    }
    #timer {
      font-size: 1.5rem;
      color: red;
      background-color: yellow;
    }
  </style>
</head>
<body>
  <div class="container game-box">
    <h2>タイピングゲーム</h2>
    <div id="word" style="margin: 20px 0;"></div>
    <input type="text" id="input" class="form-control" placeholder="ここにタイプ">
    <p id="timer">残り時間: 30秒</p>
    <p id="score">スコア: 0</p>
  </div>

  <script>
  document.addEventListener("DOMContentLoaded", function () {
	  let words = [];
	  let time = 30;
	  let score = 0;
	  let timerInterval;

	  async function loadWords() {
		  try {
		    const response = await fetch('words.json');
		    if (!response.ok) throw new Error('Network response was not ok');
		    words = await response.json();
		  } catch (error) {
		    console.error('Failed to load words:', error);
		    words = ["apple", "banana", "cherry", "grape", "orange"];
		  }
		  startGame(); // ← 成功・失敗に関係なくここで呼ぶ
		}
			 
	  function randomWord() {
	    return words[Math.floor(Math.random() * words.length)];
	  }

	  function startGame() {
	    score = 0;
	    time = 30;
	    document.getElementById("score").innerText = `スコア: ${score}`;
	    document.getElementById("word").innerText = randomWord();
	    document.getElementById("input").disabled = false;
	    document.getElementById("input").focus();
	    startTimer();
	  }

	  function startTimer() {
		  console.log("startTimer called");
		  document.getElementById("timer").innerText = `残り時間: ${time}秒`;
		  timerInterval = setInterval(() => {
		    console.log("タイマー更新中:", time); // ← 追加
		    time--;
		    document.getElementById("timer").textContent = `残り時間: ${time}秒`;
		    if (time <= 0) {
		      clearInterval(timerInterval);
		      endGame();
		    }
		  }, 1000);
		}

	  function endGame() {
	    document.getElementById("word").innerText = "終了！";
	    document.getElementById("input").disabled = true;
	    alert(`ゲーム終了！あなたのスコアは ${score} 点です`);
	  }

	  document.getElementById("input").addEventListener("input", function () {
	    const current = document.getElementById("word").innerText;
	    if (this.value === current) {
	      score++;
	      this.value = "";
	      document.getElementById("score").innerText = `スコア: ${score}`;
	      document.getElementById("word").innerText = randomWord();
	    }
	  });

	  loadWords(); // スタート
	});

  </script>
</body>
</html>
