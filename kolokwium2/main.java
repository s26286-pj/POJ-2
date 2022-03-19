public class main {
	public static String sum(String[] array) {
		int returned = 0;
		for (int i = 0; i < array.length; i++) {
			try {
				int a = Integer.parseInt(array[i]);
				returned += a;
			} catch (Exception e) {
				
			}
			
		}
		return returned + "";
	}

	public static void main(String[] args) {
		String[] tablica = { "1", "2", "d", "3"};
		System.out.println(sum(tablica));
	}
}
