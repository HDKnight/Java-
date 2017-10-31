import java.util.Random;
import java.util.Vector;

public class Test {
	static int[] c = new int[100];
//	static int[] d = new int[100];
	static Vector<Integer> v = new Vector<Integer>(30);
	static Vector<Integer> w = new Vector<Integer>(30);
	static Vector<Integer> x2 = new Vector<Integer>(200);
	static Vector<Integer> y2 = new Vector<Integer>(200);
	static Vector<Integer> d = new Vector<Integer>(100);

	public Test() {

		x2.add(0);
		y2.add(0);
		d.add(0);
		int x1 = 0, y1 = 0;
		for (int i = 0; i < 100; i++) {
			c[i] = i;
		}
		do {
			int num = 0;
			while (true) {
				Random rand = new Random();
				int i;
				i = rand.nextInt(100);
				if (c[i] == 0) {
					continue;
				} else {
					x1 = c[i] % 10;
					y1 = c[i] / 10;
					break;
				}
			}
			int[][] map = new int[][] {
					// 地图数组
					{ 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 1, 1, 0, 1, 1, 1, 1, 1 },
					{ 1, 1, 0, 1, 0, 1, 1, 1, 1, 1 },
					{ 1, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
					{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
					{ 1, 1, 1, 0, 0, 1, 1, 1, 1, 1 },
					{ 1, 1, 0, 0, 0, 0, 0, 0, 1, 1 },
					{ 1, 1, 1, 1, 1, 0, 1, 1, 0, 0 },
					{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, };
			AStar aStar = new AStar(map, 10, 10);
			int flag = aStar.search(x2.get(x2.size() - 1),
					y2.get(x2.size() - 1), x1, y1);
			if (flag == -1) {
				System.out.println("传输数据有误！");
				continue;
			} else if (flag == 0) {
				System.out.println("没找到！");
				continue;
			} else {
				for (int x = 0; x < 10; x++) {
					for (int y = 0; y < 10; y++) {
						if (map[x][y] == 1) {
							System.out.print("※");
						} else if (map[x][y] == 0) {
							System.out.print("■");
							c[y * 10 + x] = 0;

						} else if (map[x][y] == -1) {
							System.out.print("+");
							c[y * 10 + x] = 0;
						}

					}

					System.out.println();

				}
			}
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					System.out.print(map[x][y]);
				}
				System.out.println();
			}
			for (int x = 0; x < AStar.a.size(); x++) {
				x2.add(AStar.a.get(x));
				y2.add(AStar.b.get(x));

			}
			for (int x = 0; x < 10; x++) {
				for (int y = 0; y < 10; y++) {
					if (map[x][y] == 0) {
						v.add(y);
						w.add(x);
					}
				}
			}

			for (int m = 0; m < 100; m++) {
				num = num + c[m];
			}
			System.out.println("num=" + num);
			if (num == 0)
				break;
		} while (true);
		
		for (int k = 2; k < (x2.size()); k++) {
			if ((x2.get(k) == x2.get(k-1)) && (y2.get(k) == y2.get(k-1))) {
				d.add(k-1);
				
			}
		}
		for (int x = 0; x < x2.size(); x++) {
			System.out.print(x2.get(x));
			System.out.print(y2.get(x));
			System.out.println();
		}

	}
}
