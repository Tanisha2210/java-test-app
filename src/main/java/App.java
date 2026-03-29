import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {

    // Check exact duplicate
    public static boolean isDuplicate(String text1, String text2) {
        if (text1 == null || text2 == null) return false;
        return text1.trim().equalsIgnoreCase(text2.trim());
    }

    // Calculate similarity using Jaccard similarity (word-based)
    public static double calculateSimilarity(String text1, String text2) {
        if (text1 == null || text2 == null) return 0.0;

        Set<String> set1 = new HashSet<>(Arrays.asList(text1.toLowerCase().split("\\s+")));
        Set<String> set2 = new HashSet<>(Arrays.asList(text2.toLowerCase().split("\\s+")));

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        if (union.isEmpty()) return 0.0;

        return (double) intersection.size() / union.size();
    }

    // Check if similarity exceeds threshold
    public static boolean isAboveThreshold(String text1, String text2, double threshold) {
        double similarity = calculateSimilarity(text1, text2);
        return similarity >= threshold;
    }

    public static void main(String[] args) {
        String t1 = "This is a plagiarism detection system";
        String t2 = "This is plagiarism detection";

        System.out.println("Duplicate: " + isDuplicate(t1, t2));
        System.out.println("Similarity: " + calculateSimilarity(t1, t2));
        System.out.println("Above Threshold (0.5): " + isAboveThreshold(t1, t2, 0.5));
    }
}