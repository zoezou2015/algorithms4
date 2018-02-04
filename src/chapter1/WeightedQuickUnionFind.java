package chapter1;

public class WeightedQuickUnionFind {

	/** id[i] returns the union id where the ith node belongs to */
	private int[] id;
	/** The number of counts in a union where the node i is in */
	private int[] sz;
	/** The number of unions */
	private int count;

	public WeightedQuickUnionFind(int N) {
		this.count = N;
		this.id = new int[N];
		this.sz = new int[N];
		for (int i = 0; i < N; i++) {
			this.id[i] = i;
			this.sz[i] = 1;
		}
	}

	public int count() {
		return this.count;
	}

	public int find(int p) {
		if (p != this.id[p])
			p = this.id[p];
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int pRootID = find(p);
		int qRootID = find(q);
		if (pRootID == qRootID)
			return;
		int pSize = this.sz[p];
		int qSize = this.sz[q];
		if (pSize >= qSize) {
			this.id[q] = pRootID;
		} else {
			this.id[p] = qRootID;
		}
		this.sz[p] += qSize;
		this.sz[q] += pSize;
		this.count--;
	}
}
