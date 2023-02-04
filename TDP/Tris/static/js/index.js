let player = "X";
let squares = document.querySelectorAll(".square");
let restart = document.querySelector(".restart-btn")
let gameOver = false;
let scoreX = 0;
let scoreO = 0;


for (let i = 0; i < squares.length; i++)
{
    squares[i].addEventListener("click", function(e) {
        if(gameOver === false)
        {
            if(squares[i].textContent === "")
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
        document.querySelector(".scoreO").innerHTML = scoreO++;
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