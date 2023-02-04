let player = "X";
let squares = document.querySelectorAll(".square");
let restart = document.querySelector(".restart-btn")
let gameOver = false;
const winningCombinations = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
];
const result = document.getElementById('result');
let restartBtn = document.getElementById('restart-btn');
const scoreX = document.getElementById('score-x');
const scoreO = document.getElementById('score-o');
let xScore = 0;
let oScore = 0;
let scoreX;
let scoreO = 0;


for (let i = 0; i < squares.length; i++)
{
    squares[i].addEventListener("click", function(e) {
        if(gameOver == false)
        {
            if(squares[i].textContent == "")
            {
                squares[i].innerHTML = player;
                switchPlayer();
            }
        }
    });
}

function switchPlayer()
{
    if (player === "X")
    {
        player = "O";
        document.querySelector(".scoreO").innerHTML = "O:"+scoreO++;
    } else
    {
        player = "X";
    }
}

restart.addEventListener("click", function(e)
{
    for (let i = 0; i < squares.length; i++)
    {
        squares[i].innerHTML = "";
    }
    player = "X";
    gameOver = false;
});