import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {

    // Duplicate content test
    @Test
    public void testDuplicateContent() {
        String t1 = "Hello World";
        String t2 = "Hello World";

        assertTrue(App.isDuplicate(t1, t2));
    }

    // Non-duplicate test
    @Test
    public void testNonDuplicateContent() {
        String t1 = "Hello World";
        String t2 = "Hello Java";

        assertFalse(App.isDuplicate(t1, t2));
    }

    // Similarity calculation test
    @Test
    public void testSimilarityCalculation() {
        String t1 = "Java is great";
        String t2 = "Java is awesome";

        double similarity = App.calculateSimilarity(t1, t2);

        assertTrue(similarity > 0);
        assertTrue(similarity < 1);
    }

    // High similarity threshold test
    @Test
    public void testAboveThreshold() {
        String t1 = "Machine learning is fun";
        String t2 = "Machine learning is very fun";

        assertTrue(App.isAboveThreshold(t1, t2, 0.5));
    }

    // Low similarity threshold test
    @Test
    public void testBelowThreshold() {
        String t1 = "Python coding";
        String t2 = "Football match";

        assertFalse(App.isAboveThreshold(t1, t2, 0.5));
    }
}