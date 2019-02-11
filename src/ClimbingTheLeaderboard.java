import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem#!
 */
public class ClimbingTheLeaderboard {
	static int index = 0;

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		buffer = new BufferedReader(fr);
		int n = Integer.parseInt(buffer.readLine());
		int[] scores = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int m = Integer.parseInt(buffer.readLine());
		int[] aliceScore = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] ranking = getRanking(scores);
		int[] aliceRanking = new int[aliceScore.length];
		index = scores.length - 1;
		for (int i = 0; i < aliceRanking.length; i++)
			aliceRanking[i] = getAliceRank(ranking, scores, aliceScore[i]);

		for (int i = 0; i < aliceRanking.length; i++)
			System.out.println(aliceRanking[i]);

	}

	public static int[] getRanking(int[] scores) {
		int[] rankings = new int[scores.length];
		int rank = 1;
		rankings[0] = rank;
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] < scores[i - 1])
				rankings[i] = ++rank;
			else
				rankings[i] = rank;
		}
		return rankings;
	}

	public static int getAliceRank(int[] ranks, int[] scores, int aliceScore) {
		int rank = -1;
		if (aliceScore >= scores[0])
			return 1;
		if (aliceScore < scores[scores.length - 1])
			return ranks[ranks.length - 1] + 1;

		for (; index > 0; index--) {
			if (aliceScore == scores[index]) {
				return ranks[index];
			}
			if (aliceScore < scores[index - 1] && aliceScore > scores[index])
				return ranks[index - 1] + 1;
		}
		return 0;
	}
}
