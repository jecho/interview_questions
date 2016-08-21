package com.foxley.interview;

/**
 *  Date 08/20/2016
 *  @author Jecho Ricafrente
 *
 *      construct an htree based on the depth (say level) and by a half'ed length
 */

public class HTree {

	// assumed to draw a line, assumed implemeneted 
	public static void drawLine(double x1, double y1, double x2, double y2) { }

	// build the H
	public static void construct(int start_x, int start_y, int length, int depth) {
		
		// base case
		if (depth == 0) return;

		int newLength = length/2;
		// compute the coordinates
		double x0 = x - newLength;
		double x1 = x + newLength;
		double y0 = y - newLength;
		double y1 = y + newLength;

		// build waist, upper left and right, and lower left and right
		drawLine(x0, y0, x1, y1);
		drawLine(x0, y0, x0, y1);
		drawLine(x1, y0, x1, y1);
		drawLine(x0, y, x1,  y);


		construct(x0, y0, newLength, depth-1);  // lower left
		construct(x0, y1, newLength, depth-1);	// upper left
		construct(x1, y1, newLength, depth-1);	// upper right
		construct(x1, y0, newLength, depth-1);	// lower right

	}
}