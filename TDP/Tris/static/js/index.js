const squares = document.querySelectorAll('.square');
let currentPlayer = 'X';
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
let x = 0;
let o = 0;

for (let i = 0; i < squares.length; i++) {
    squares[i].addEventListener('click', function(e) {
        if (!gameOver) {
            if (e.target.textContent === '') {
                e.target.textContent = currentPlayer;
                checkForWin();
                checkForTie();
                switchPlayer();
            }
        }
    });
}


function checkForWin() {
    for (let i = 0; i < winningCombinations.length; i++) {
        const [a, b, c] = winningCombinations[i];
        if (squares[a].textContent === currentPlayer && squares[b].textContent === currentPlayer && squares[c].textContent === currentPlayer) {
            result.textContent = `Player ${currentPlayer} wins!`;
            gameOver = true;
            if (currentPlayer === 'X') {
                xScore++;
                x++;
                scoreX.textContent = x;
            } else {
                oScore++;
                o++;
                scoreO.textContent = o;
            }
        }
    }
}


function checkForTie() {
    let openSquares = 0;
    for (let i = 0; i < squares.length; i++) {
        if (squares[i].textContent === '') {
            openSquares++;
        }
    }
    if (openSquares === 0 && !gameOver) {
        result.textContent = 'Its a tie!';
        gameOver = true;
    }
}

function switchPlayer() {
    if (currentPlayer === 'X') {
        currentPlayer = 'O';
    } else {
        currentPlayer = 'X';
    }
}

restartBtn.addEventListener('click', function() {
    for (let i = 0; i < squares.length; i++) {
        squares[i].textContent = '';
    }
    x++;
    result.textContent = '';
    gameOver = false;
    currentPlayer = 'X';
});

