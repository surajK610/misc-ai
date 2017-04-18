/**
 * Created by suraj on 4/13/17.
 */

public class minimax {

    public int minimax(Node node, boolean maximizingScore)
    {
        if (node.isEndNode())
        {
            return node.evaluate();
        }

        int bestScore = maximizingScore ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (Node child: node.getChildren())
        {
            int score = minimax(child, !maximizingScore);
            if (maximizingScore)
            {
                bestScore = Math.max(score, bestScore);
            }
            else
            {
                Math.min(score, bestScore);
            }
        }
        return bestScore;
    }
}
