/***
 * @since 2016
 * @author Min
 *
 * I made this code one day in 2016.
 * I saw this code again in April 2022.
 * OMG. ... I thought I was doing a neat coding in 2016 - it's a mess!
 */
public class GCDandLCM {
	public GCDandLCM() {};
	
	private class Solution {
		public int[] solution(int n, int m) {
			int[] answer = calcTest(n, m);
			return answer;
		}

		private int[] calcTest(int a, int b) {
			int minValue = 2;
			int tempA = a;
			int tempB = b;
			int[] answer = new int[2];
			boolean checkData = true;
			String commonMinNumber = "";
			String commonMaxNumber = "";
			String[] arrMinNumber1;
			String[] arrMaxNumber2;

			while (checkData) {
				if ((tempA / minValue) < 1 || (tempB / minValue) < 1) {
					commonMaxNumber = commonMinNumber;
					commonMinNumber = commonMinNumber + " " + tempA + " " + tempB;

					checkData = false;
					break;
				} else if ((tempA % minValue) != 0 || (tempB % minValue) != 0) {
					minValue = ++minValue;
				} else {
					tempA = tempA / minValue;
					tempB = tempB / minValue;

					commonMinNumber = commonMinNumber + " " + minValue;
				}
			}

			arrMinNumber1 = commonMinNumber.split(" ");
			arrMaxNumber2 = commonMaxNumber.split(" ");

			for (int i = 0; i < arrMinNumber1.length; i++) {
				if (arrMinNumber1[i].length() < 1)
					continue;

				if (answer[1] == 0)
					answer[1] = 1;

				answer[1] = answer[1] * Integer.parseInt(arrMinNumber1[i]);
			}

			for (int i = 0; i < arrMaxNumber2.length; i++) {
				if (arrMaxNumber2[i].length() < 1)
					continue;

				if (answer[0] == 0)
					answer[0] = 1;

				answer[0] = answer[0] * Integer.parseInt(arrMaxNumber2[i]);
			}

			return answer;
		}
	}
}
