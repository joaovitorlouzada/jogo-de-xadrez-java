package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}


	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		// todos os 8 movimentos possíveis do cavalo
		int[][] moves = {
				{-2, -1}, {-2, +1},
				{-1, -2}, {-1, +2},
				{+1, -2}, {+1, +2},
				{+2, -1}, {+2, +1}
		};

		for (int[] move : moves) {
			p.setValues(position.getRow() + move[0], position.getColumn() + move[1]);
			if (checkIfCanMove(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}

		return mat;
	}

	public String toString() {
		return "N";
	}
	public boolean checkIfCanMove(Position p) {
		return getBoard().positionExists(p) && canMove(p);
	}

}
