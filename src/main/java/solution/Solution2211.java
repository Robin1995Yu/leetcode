package solution;

public class Solution2211 {
    public int countCollisions(String directions) {
        directions = directions.replaceAll("^L+", "");
        directions = directions.replaceAll("[$R+]", "");
        return directions.length() - (int) directions.chars().filter(c -> c == 'S').count();
    }
}
