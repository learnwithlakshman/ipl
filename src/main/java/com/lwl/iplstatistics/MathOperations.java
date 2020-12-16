package com.lwl.iplstatistics;

public class MathOperations {

	public int biggest(int a, int b, int c) {
		return (a > b && a > c) ? a : (b > c) ? b : c;
	}
}
