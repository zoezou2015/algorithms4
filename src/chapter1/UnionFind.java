package chapter1;

public class UnionFind {

	private int[] id;
	/** The number of unions **/
	private int count;

	public UnionFind(int N) {
		this.id = new int[N];
		this.count = N;
		for (int i = 0; i < N; i++)
			this.id[i] = i;
	}

	/** Union p and q **/
	public void union(int p, int q) {

	}

	/** Union p and q **/
	public void quickUnion(int p, int q) {
		int pID = quickFind(p);
		int qID = quickFind(q);
		if (pID == qID)
			return;
		for (int i = 0; i < this.id.length; i++) {
			if (this.id[i] == pID)
				this.id[i] = qID;
		}
		this.count--;
	}

	/** find the union where the p is in **/
	public int quickFind(int p) {
		return this.id[p];
	}

	public void quickTreeUnion(int p, int q) {
		int pRootID = quickTreeFind(p);
		int qRootID = quickTreeFind(q);
		if (pRootID == qRootID)
			return;
		this.id[p] = qRootID;
		this.count--;
	}

	public int quickTreeFind(int p) {
		while (p != this.id[p])
			p = this.id[p];
		return p;
	}

	/** find the union where the p is in **/
	public int find(int p) {
		return -1;
	}

	/** Return true if p and q are connected **/
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	/** Return the number of unions **/
	public int count() {
		return this.count;
	}
}
