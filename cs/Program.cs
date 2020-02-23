using System;
using System.Collections.Generic;

namespace cs
{
	class Program
	{
		static int ITERATIONS = 50000000;

		static Random random = new Random();


		static void Main(string[] args)
		{

			List<Double> v1 = new List<Double>(),
				v2 = new List<Double>(),
				vAdd = new List<Double>(),
				vSub = new List<Double>(),
				vMult = new List<Double>(),
				vDiv = new List<Double>();

			var startTime = DateTime.Now;

			Console.WriteLine("Hello World!");

			for (int j = 0; j < 5; j++) {
				v1 = new List<Double>();
				v2 = new List<Double>();
				for (int i = 0; i < ITERATIONS; ++i) {
					v1.Add(getRandomDouble());
					v2.Add(getRandomDouble());
				}
			}
			logTime("populate vectors 5x", startTime);

			for (int j = 0; j < 20; ++j) {
				for (int i = 0; i < v1.Count; ++i) {
					vAdd.Add(v1[i] + v2[i]);
				}
				vAdd = new List<Double>();
				
				for (int i = 0; i < v1.Count; ++i) {
					vSub.Add(v1[i] - v2[i]);
				}
				vSub = new List<Double>();
		
				for (int i = 0; i < v1.Count; ++i) {
					vMult.Add(v1[i] * v2[i]);
				}
				vMult = new List<Double>();
		
				for (int i = 0; i < v1.Count; ++i) {
					vDiv.Add(v1[i] / v2[i]);
				}
				vDiv = new List<Double>();
			}
			logTime("float math 20x", startTime);

			Dictionary<String, int> bigDictionary = new Dictionary<String, int>();
			List<int> mapValues = new List<int>();
			List<String> vsKeys = new List<String>();
		
			for (int i = 0; i < ITERATIONS/10; ++i) {
				bigDictionary.Add(getRandomString(255), random.Next());
			}
			logTime("populate map", startTime);

			foreach (KeyValuePair<String, int> item in bigDictionary) {
				mapValues.Add(item.Value);
				vsKeys.Add(item.Key);
			}
			bigDictionary = new Dictionary<String, int>();

			mapValues.Sort();
			vsKeys.Sort();
			mapValues = new List<int>();
			vsKeys = new List<String>();
			logTime("map lookup and sort vectors", startTime);
		}

		static String getRandomString(int length)
		{
			const String characters = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			String randomString = "";
			int len = characters.Length;

			for (int i = 0; i < length; ++i)
			{
				int index = Math.Abs(random.Next(0, len));
				randomString += characters[index];
			}

			return randomString;
		}
		static void logTime(String message, DateTime startTime)
		{
			Console.WriteLine("{0} {1} seconds", message, (DateTime.Now - startTime).ToString());
		}

		static double getRandomDouble()
		{
			return random.NextDouble();
		}
	}

}
