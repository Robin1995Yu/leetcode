package com.zhuolu.leetcode.solution;

public class Solution1958 {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char notColor = color == 'B' ? 'W' : 'B';
        boolean[] legal = {
                legal(board, getIndex(0, rMove, cMove, 1), notColor),
                legal(board, getIndex(1, rMove, cMove, 1), notColor),
                legal(board, getIndex(2, rMove, cMove, 1), notColor),
                legal(board, getIndex(3, rMove, cMove, 1), notColor),
                legal(board, getIndex(4, rMove, cMove, 1), notColor),
                legal(board, getIndex(5, rMove, cMove, 1), notColor),
                legal(board, getIndex(6, rMove, cMove, 1), notColor),
                legal(board, getIndex(7, rMove, cMove, 1), notColor)
        };
        int steep = 1;
        while (or(legal)) {
            steep++;
            for (int i = 0; i < 8; i++) {
                if (legal[i]) {
                    int[] index = getIndex(i, rMove, cMove, steep);
                    if (legal(board, index, color)) {
                        return true;
                    }
                    legal[i] = legal(board, index, notColor);
                }
            }
        }
        return false;
    }

    private boolean legal(char[][] board, int[] index, char color) {
        if (index[0] < 0 || index[1] < 0 || index[0] >= board.length || index[1] >= board.length) {
            return false;
        }
        return board[index[0]][index[1]] == color;
    }

    private boolean or(boolean[] b) {
        boolean result = false;
        for (boolean b1 : b) {
            result = result || b1;
        }
        return result;
    }

    private int[] getIndex(int i, int x, int y, int steep) {
        switch (i) {
            case 0:
                return new int[]{x - steep, y - steep};
            case 1:
                return new int[]{x, y - steep};
            case 2:
                return new int[]{x + steep, y - steep};
            case 3:
                return new int[]{x - steep, y};
            case 4:
                return new int[]{x + steep, y};
            case 5:
                return new int[]{x - steep, y + steep};
            case 6:
                return new int[]{x, y + steep};
            case 7:
                return new int[]{x + steep, y + steep};
            default:
                throw new IllegalArgumentException();
        }
    }
}
