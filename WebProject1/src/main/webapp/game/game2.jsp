<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>タイピングゲームテスト</title>
</head>
<body>
  <div>
    <div id="word">test</div>
    <input id="input" />
    <p id="score">スコア: 0</p>
    <p id="timer">残り時間: 30秒</p>
  </div>

  <script>
    let score = 0;
    let time = 30;

    document.getElementById("input").addEventListener("input", function () {
      if (this.value === document.getElementById("word").innerText) {
        score++;
        this.value = "";
        document.getElementById("score").innerText = `スコア: ${score}`;
        document.getElementById("word").innerText = "test"; // 再表示
      }
    });

    setInterval(() => {
      if (time <= 0) return;
      time--;
      document.getElementById("timer").innerText = `残り時間: ${time}秒`;
    }, 1000);
  </script>
</body>
</html>
