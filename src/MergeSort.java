public class MergeSort {

	public static void main(String[] args) {
		int[] list = { 1, 2, 3, 4, 5 };

		System.out.println("Before mergesort");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]);
			System.out.print(" ");
		}

		System.out.println("\n\n------------------\n");

		mergeSort(list);

		System.out.println("After mergesort");
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i]);
			System.out.print(" ");
		}
	};

	private static int[] mergeSort(int[] sortList) {
		// boundary condition
		if (sortList.length == 1) {
			return sortList;
		}

		int[] first = new int[sortList.length / 2];
		int[] last = new int[sortList.length - first.length];

		// // copy list
		// for (int i = 0; i < first.length; i++) {
		// first[i] = sortList[i];
		// }
		//
		// for (int j = 0; j < last.length; j++) {
		// last[j] = sortList[first.length + j];
		// }
		System.arraycopy(sortList, 0, first, 0, first.length);
		System.arraycopy(sortList, first.length, last, 0, last.length);

		// mergeSort each halfed list
		mergeSort(first);
		mergeSort(last);

		// change list
		merge(first, last, sortList);

		return sortList;
	}

	private static void merge(int[] first, int[] last, int[] list) {
		int idx_first = 0;
		int idx_last = 0;
		int idx_list = 0;

		while (idx_first < first.length && idx_last < last.length) {
			if (first[idx_first] < last[idx_last]) {
				list[idx_list] = first[idx_first];
				idx_first++;
			} else {
				list[idx_list] = last[idx_last];
				idx_last++;
			}
			idx_list++;
		}

		// copy what's left
		System.arraycopy(first, idx_first, list, idx_list, first.length
				- idx_first);
		System.arraycopy(last, idx_last, list, idx_list, last.length - idx_last);
	}
}
