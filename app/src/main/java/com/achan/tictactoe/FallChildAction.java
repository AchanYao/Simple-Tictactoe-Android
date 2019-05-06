package com.achan.tictactoe;

public class FallChildAction {

    private short count = 0;
    private int[][] chess = null;
    private boolean onePlayer = false;

    public class State {
        private int state = 0;
        private String information = null;

        public State(int state) {
            switch (state) {
                case 1:
                    this.information = "O获胜";
                    this.state = state;
                    break;
                case 2:
                    this.information = "X获胜";
                    this.state = state;
                    break;
                case -1:
                    this.information = "平局";
                    this.state = -1;
                    break;
                default:
                    break;
            }
        }

        public int getState()
        {
            return state;
        }

        public String getInformation() {
            return information;
        }
    }

    private State state = null;

    public FallChildAction(boolean isOnePlayer) {
        onePlayer = isOnePlayer;
        count = 0;
        chess = new int[3][3];

        // 初始化棋盘
        for (int i = 0; i < chess.length; i++)
            for (int j = 0; j < chess[i].length; j++)
                chess[i][j] = 0;
    }

    public String getChild() {
        int temp = count - 1;
        if (temp % 2 == 0)
            return "O";
        else
            return "X";
    }

    private int[][] getChess() {
        return chess;
    }

    /**
     * @param x 落子x坐标
     * @param y 落子y坐标
     * @return 是否成功落子
     */
    public void fallChild(int x, int y) {
        if (chess[x][y] == 0 && state.getState() == 0) {
            chess[x][y] = count % 2 + 1;
            count++;
        }
        isFinish();
    }

    /**
     * @return 是否结束对局
     */
    public void isFinish() {
        for (int i = 0; i < 3; i++) {
            if (chess[i][0] == chess[i][1] && chess[i][1] == chess[i][2]) {
                state = new State(chess[i][1]);
                return;
            }
            if (chess[0][i] == chess[1][i] && chess[1][i] == chess[2][i]) {
                state = new State(chess[1][i]);
                return;
            }
        }
        if (chess[0][0] == chess[1][1] && chess[1][1] == chess[2][2]) {
            state = new State(chess[1][1]);
            return;
        }
        if (chess[0][2] == chess[1][1] && chess[1][1] == chess[2][0]) {
            state = new State(chess[1][1]);
            return;
        }
        if (count >= 9 && state.getState() == 0)
            state = new State(-1);
    }

    public State getState() {
        return state;
    }

    /**
     * 机器人自动落子
     * @return 位置编号 1-9
     */
    public int autoFall()
    {
        if (chess[1][1] == 0)
        {
            chess[1][1] = count % 2 + 1;
            count++;
            return 5;
        }

        // 堵对手
        return -1;
    }

    public boolean isOnePlayer()
    {
        return onePlayer;
    }
}
