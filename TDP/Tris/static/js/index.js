let player = "X";
let squares = document.querySelectorAll(".square");
let restart = document.querySelector(".restart-btn")
let gameOver = false;
let scoreX = 0;
let scoreO = 0;
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
                switchPlayer();

                for (let i = 0; i < winningCombinations.length; i++) {
                    let a = winningCombinations[i][0];
                    let b = winningCombinations[i][1];
                    let c = winningCombinations[i][2];
                    if (squares[a].innerHTML === player && squares[b].innerHTML === player && squares[c].innerHTML === player) {
                        gameOver = true;
                        if(player === "X")
                        {
                            scoreX++
                            document.querySelector(".scoreX").innerHTML = scoreX;
                        } else
                        {
                            scoreO++
                            document.querySelector(".scoreO").innerHTML = scoreO;
                        }
                    }
                }
            }
        }
    });
}

function switchPlayer()
{
    if (player === "X")
    {
        player = "O";
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