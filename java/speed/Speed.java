package speed;

import java.util.*;

class Speed {

	static final int ITERATIONS = 50000000;

	static final Random randGenerator = new Random();

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		List<Double> v1 = new Vector<Double>(), v2 = new Vector<Double>(), vAdd = new Vector<Double>(),
				vSub = new Vector<Double>(), vMult = new Vector<Double>(), vDiv = new Vector<Double>();

		System.out.println("Hello world!");

		for (int j = 0; j < 5; ++j) {
			v1 = new Vector<Double>();
			v2 = new Vector<Double>();
			for (int i = 0; i < ITERATIONS; ++i) {
				v1.add(getRandomDouble());
				v2.add(getRandomDouble());
			}
		}
		logTime("populate vectors 5x ", startTime);

		for (int j = 0; j < 20; ++j) {
			for (int i = 0; i < v1.size(); ++i) {
				vAdd.add(v1.get(i) + v2.get(i));
			}
			vAdd = new Vector<Double>();
			
			for (int i = 0; i < v1.size(); ++i) {
				vSub.add(v1.get(i) - v2.get(i));
			}
			vSub = new Vector<Double>();
	
			for (int i = 0; i < v1.size(); ++i) {
				vMult.add(v1.get(i) * v2.get(i));
			}
			vMult = new Vector<Double>();
	
			for (int i = 0; i < v1.size(); ++i) {
				vDiv.add(v1.get(i) / v2.get(i));
			}
			vDiv = new Vector<Double>();
		}
		logTime("float math 20x", startTime);

		Map<String, Integer> bigmap = new HashMap<String, Integer>();
		List<Integer> mapValues = new Vector<Integer>();
		List<String> vsKeys = new Vector<String>();
	
		for (int i = 0; i < ITERATIONS/10; ++i) {
			bigmap.put(getRandomString(255), randGenerator.nextInt());
		}
		logTime("populate map", startTime);

		for(Map.Entry<String,Integer> item: bigmap.entrySet()) {
			mapValues.add(item.getValue());
			vsKeys.add(item.getKey());
		}
		bigmap = new HashMap<String, Integer>();

		Collections.sort(mapValues);
		Collections.sort(vsKeys);
		mapValues = new Vector<Integer>();
		vsKeys = new Vector<String>();
		logTime("map lookup and sort vectors", startTime);
	}

	static String getRandomString(int length) {
		final CharSequence characters = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String randomString = "";
		final int len = characters.length();
	
		for (int i = 0; i < length; ++i) {
			int index = Math.abs(randGenerator.nextInt() % len);
			randomString += characters.charAt(index);
		}
	
		return randomString;
	}

	static void logTime(String message, long startTime) {
		System.out.printf("%s %.3f seconds\n", message, (System.currentTimeMillis() - startTime) / 1000.0);
	}
	
	public static double getRandomDouble() {
		return randGenerator.nextDouble();
	}

}
