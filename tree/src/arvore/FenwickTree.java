package arvore;

public class FenwickTree {
	public int value;
	public int leftSize;
	public FenwickTree left;
	public FenwickTree right;

	FenwickTree(int Value) {
		value = Value;
		leftSize = 0;
		left = null;
		right = null;
	}

	FenwickTree(int LeftSize, FenwickTree Left, FenwickTree Right) {
		value = Left.value + Right.value;
		if (LeftSize == 0) {
			leftSize = 1;
		} else {
			leftSize = LeftSize;
		}
		left = Left;
		right = Right;
	}

	public String toString() {
		if (leftSize == 0) {
			if (right == null) {
				return "[" + value + "," + leftSize + "]";
			}
			return "[" + value + "," + leftSize + "," + right.toString() + "]";
		}
		if (right == null) {
			return "[" + value + "," + leftSize + "," + left.toString() + ","
					+ "]";
		}

		return "[" + value + "," + leftSize + "," + left.toString() + ","
				+ right.toString() + "]";
	}

	static FenwickTree allZeros(int n) {
		if (n == 0) {
			return null;
		}
		if (n == 1) {
			return new FenwickTree(0);
		}
		int m = n / 2;
		return new FenwickTree(n - m, allZeros(n - m), allZeros(m));
	}

	public int size() {
		if (leftSize == 0) {
			return 1;
		}
		return leftSize + right.size();
	}

	public static void main(String[] args) {
		// teste de correcao
		System.out.println("Verificacao de correcao da funcao...");
		FenwickTree T = new FenwickTree(3, new FenwickTree(1,
				new FenwickTree(0), new FenwickTree(1, new FenwickTree(0),
						new FenwickTree(0))), new FenwickTree(1,
				new FenwickTree(0), new FenwickTree(1, new FenwickTree(0),
						new FenwickTree(0))));
		System.out.println("Arvore this : " + T);
		T.increment(0, 4);
		System.out.println("Resultado de increment(0, 4) : " + T);
		T.increment(1, 2);
		System.out.println("Resultado de increment(1, 2) : " + T);
		T.increment(2, 5);
		System.out.println("Resultado de increment(2, 5) : " + T);
		T.increment(3, 3);
		System.out.println("Resultado de increment(3, 3) : " + T);
		T.increment(4, 6);
		System.out.println("Resultado de increment(4, 6) : " + T);
		T.increment(5, 1);
		System.out.println("Resultado de increment(5, 1) : " + T);
	}

	public void increment(int i, int delta) {
		value += delta;
		if (leftSize == 0)
			return;
		if (i < leftSize) {
			left.increment(i, delta);
		} else {
			right.increment(i - leftSize, delta);
		}
	}

}
