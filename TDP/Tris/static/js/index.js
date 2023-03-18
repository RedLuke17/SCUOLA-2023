let player = "X";
let squares = document.querySelectorAll(".square");
let restart = document.querySelector(".restart-btn");
let gameOver = false;
let scoreX = 0;
let scoreO = 0;
let display = document.querySelector(".display-winning");
let content = document.querySelector(".content");
let close = document.querySelector(".close");
let menuClosed = document.querySelector(".close-menu,.menu");
let menu = document.querySelector(".menu");
let changeMode = document.querySelector(".change-mode")
let botMode = document.querySelector(".bot-mode")
let PvPmode = document.querySelector(".PvP-mode")
let mode = true;
let menuOpen = true;
let winningCombinations = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
];


for (let i = 0; i < squares.length; i++)
{
    squares[i].addEventListener("click", function(e) {
        if(gameOver === false)
        {
            if(squares[i].innerHTML === "")
            {
                squares[i].innerHTML = player;
                for (let i = 0; i < winningCombinations.length; i++) {
                    let a = winningCombinations[i][0];
                    let b = winningCombinations[i][1];
                    let c = winningCombinations[i][2];
                    if (squares[a].innerHTML === player && squares[b].innerHTML === player && squares[c].innerHTML === player) {
                        gameOver = true;
                        if(player === "X")
                        {
                            content.innerHTML = "X wins!";
                            display.classList.add("show");
                            scoreX++
                            document.querySelector(".scoreX").innerHTML = scoreX;
                        } else
                        {
                            content.innerHTML = "O wins!";
                            display.classList.add("show");
                            scoreO++
                            document.querySelector(".scoreO").innerHTML = scoreO;
                        }
                    }
                }
                if (mode === true){
                    switchPlayer();
                } else {
                    switchPlayerAi();
                }

            }
        }
    });
}

function switchPlayer() {
    if (player === "X")
    {
        player = "O";
    } else
    {
        player = "X";
    }
}

PvPmode.addEventListener("click", function (e){
    mode = true;
    for (let i = 0; i < squares.length; i++)
    {
        squares[i].innerHTML = "";
    }
    player = "X";
    gameOver = false;
    display.classList.remove("show");
})

botMode.addEventListener("click", function (e){
    mode = false;
    for (let i = 0; i < squares.length; i++)
    {
        squares[i].innerHTML = "";
    }
    player = "X";
    gameOver = false;
    display.classList.remove("show");
})

restart.addEventListener("click", function(e)
{
    for (let i = 0; i < squares.length; i++)
    {
        squares[i].innerHTML = "";
    }
    player = "X";
    gameOver = false;
    display.classList.remove("show");
});

close.addEventListener("click", function(e){
    display.classList.remove("show");
});

menuClosed.addEventListener("click", function(e){
    if (menuOpen === false) {
        menuOpen = true;
        menu.classList.add("closed");
    } else  {
        menu.classList.remove("closed");
        menuOpen = false;
    }
});

changeMode.addEventListener("click", function(e){
    menu.classList.remove("closed");
})

menu.addEventListener("click", function(e){
    if (display.classList.contains("menu closed")){
        display.classList.remove("closed");
    }
})

function switchPlayerAi() {
    if (player === "X") {
        player = "O";
        let bestScore = -Infinity;
        let bestMove;
        for (let i = 0; i < 9; i++) {
            if (squares[i].innerHTML === "") {
                squares[i].innerHTML = "O";
                let score = minimax(getBoard(), 0, false);
                squares[i].innerHTML = "";
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                    getBestMove()
                }
            }
        }
        squares[bestMove].innerHTML = "O";
        for (let i = 0; i < winningCombinations.length; i++) {
            let a = winningCombinations[i][0];
            let b = winningCombinations[i][1];
            let c = winningCombinations[i][2];
            if (squares[a].innerHTML === "O" && squares[b].innerHTML === "O" && squares[c].innerHTML === "O") {
                gameOver = true;
                content.innerHTML = "O wins!";
                display.classList.add("show");
                scoreO++
                document.querySelector(".scoreO").innerHTML = scoreO;
            }
        }
        player = "X";
    } else {
        player = "X";
    }
}

function getBoard() {
    let board = [];
    for (let i = 0; i < squares.length; i++) {
        board.push(squares[i].innerHTML);
    }
    return board;
}

function score(state) {
    if (state.includes("") === false) {
        return 0;
    }

    for (let i = 0; i < winningCombinations.length; i++) {
        let [a, b, c] = winningCombinations[i];
        if (state[a] === state[b] && state[b] === state[c]) {
            if (state[a] === "X") {
                return 1;
            } else if (state[a] === "O") {
                return -1;
            }
        }
    }

    return 0;
}

function minimax(state, depth, maximizingPlayer) {
    let currentScore = score(state);

    if (currentScore !== 0) {
        return currentScore;
    }

    if (maximizingPlayer) {
        let bestScore = -Infinity;
        for (let i = 0; i < 9; i++) {
            if (state[i] === "") {
                state[i] = "O";
                let score = minimax(state, depth + 1, false);
                state[i] = "";
                bestScore = Math.max(bestScore, score);
            }
        }
        return bestScore;
    } else {
        let bestScore = Infinity;
        for (let i = 0; i < 9; i++) {
            if (state[i] === "") {
                state[i] = "X";
                let score = minimax(state, depth + 1, true);
                state[i] = "";
                bestScore = Math.min(bestScore, score);
            }
        }
        return bestScore;
    }
}

function getBestMove() {
    let bestScore = -Infinity;
    let bestMove;
    for (let i = 0; i < 9; i++) {
        if (squares[i].innerHTML === "") {
            squares[i].innerHTML = "O";
            let score = minimax(getBoard(), 0, false);
            squares[i].innerHTML = "";
            if (score > bestScore) {
                bestScore = score;
                bestMove = i;
            }
        }
    }
    return bestMove;
}