import java.util.Scanner;

/**
 * Level 2 Problem 5: Palindrome Checker
 * Demonstrates modular programming with separate functions for input, checking, and display
 */
public class PalindromeChecker {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Palindrome Checker ===");

        // Get string input from user
        String input = getStringInput();

        // Check if palindrome using different methods
        boolean isPalindromeBasic = isPalindromeBasic(input);
        boolean isPalindromeIgnoreCase = isPalindromeIgnoreCase(input);
        boolean isPalindromeIgnoreSpaces = isPalindromeIgnoreSpacesAndCase(input);

        // Display results
        displayResults(input, isPalindromeBasic, isPalindromeIgnoreCase, isPalindromeIgnoreSpaces);

        // Demonstrate with additional examples
        demonstrateWithExamples();

        scanner.close();
    }

    /**
     * Get string input from user
     * @return User input string
     */
    private static String getStringInput() {
        System.out.print("Enter a word or phrase to check if it's a palindrome: ");
        return scanner.nextLine().trim();
    }

    /**
     * Basic palindrome check (case-sensitive, includes spaces)
     * @param str String to check
     * @return true if string is palindrome
     */
    private static boolean isPalindromeBasic(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * Palindrome check ignoring case
     * @param str String to check
     * @return true if string is palindrome (ignoring case)
     */
    private static boolean isPalindromeIgnoreCase(String str) {
        if (str == null) return true;

        String lowerStr = str.toLowerCase();
        return isPalindromeBasic(lowerStr);
    }

    /**
     * Palindrome check ignoring spaces, punctuation, and case
     * @param str String to check
     * @return true if string is palindrome (ignoring spaces, punctuation, and case)
     */
    private static boolean isPalindromeIgnoreSpacesAndCase(String str) {
        if (str == null) return true;

        // Clean string: remove non-alphanumeric characters and convert to lowercase
        String cleanStr = cleanString(str);
        return isPalindromeBasic(cleanStr);
    }

    /**
     * Clean string by removing non-alphanumeric characters and converting to lowercase
     * @param str String to clean
     * @return Cleaned string
     */
    private static String cleanString(String str) {
        StringBuilder cleaned = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        return cleaned.toString();
    }

    /**
     * Alternative palindrome check using StringBuilder reverse
     * @param str String to check
     * @return true if string is palindrome
     */
    private static boolean isPalindromeUsingReverse(String str) {
        if (str == null) return true;

        String cleanStr = cleanString(str);
        String reversedStr = new StringBuilder(cleanStr).reverse().toString();

        return cleanStr.equals(reversedStr);
    }

    /**
     * Recursive palindrome check
     * @param str String to check
     * @param start Start index
     * @param end End index
     * @return true if substring is palindrome
     */
    private static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    /**
     * Find the longest palindromic substring
     * @param str Input string
     * @return Longest palindromic substring
     */
    private static String findLongestPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }

        String longest = "";

        for (int i = 0; i < str.length(); i++) {
            // Check for odd length palindromes
            String palindrome1 = expandAroundCenter(str, i, i);
            // Check for even length palindromes
            String palindrome2 = expandAroundCenter(str, i, i + 1);

            String currentLongest = palindrome1.length() > palindrome2.length() ? 
                                   palindrome1 : palindrome2;

            if (currentLongest.length() > longest.length()) {
                longest = currentLongest;
            }
        }

        return longest;
    }

    /**
     * Helper method to expand around center for palindrome detection
     * @param str Input string
     * @param left Left center index
     * @param right Right center index
     * @return Palindromic substring
     */
    private static String expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }

    /**
     * Count palindromic substrings
     * @param str Input string
     * @return Number of palindromic substrings
     */
    private static int countPalindromicSubstrings(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            // Count odd length palindromes
            count += countPalindromes(str, i, i);
            // Count even length palindromes
            count += countPalindromes(str, i, i + 1);
        }

        return count;
    }

    /**
     * Helper method to count palindromes expanding from center
     * @param str Input string
     * @param left Left center
     * @param right Right center
     * @return Count of palindromes
     */
    private static int countPalindromes(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    /**
     * Display palindrome checking results
     * @param input Original input string
     * @param basicResult Result of basic check
     * @param ignoreCaseResult Result ignoring case
     * @param ignoreSpacesResult Result ignoring spaces and case
     */
    private static void displayResults(String input, boolean basicResult, 
                                     boolean ignoreCaseResult, boolean ignoreSpacesResult) {
        System.out.println("\n=== Palindrome Check Results ===");
        System.out.println("Input string: \"" + input + "\"");
        System.out.println("Length: " + input.length() + " characters");

        System.out.println("\nCheck Results:");
        System.out.println("Basic check (exact match): " + (basicResult ? "✓ IS palindrome" : "✗ NOT palindrome"));
        System.out.println("Ignoring case: " + (ignoreCaseResult ? "✓ IS palindrome" : "✗ NOT palindrome"));
        System.out.println("Ignoring spaces & case: " + (ignoreSpacesResult ? "✓ IS palindrome" : "✗ NOT palindrome"));

        // Show cleaned version
        String cleaned = cleanString(input);
        if (!cleaned.equals(input.toLowerCase().replaceAll("\\s", ""))) {
            System.out.println("Cleaned version: \"" + cleaned + "\"");
        }

        // Additional analysis
        String longestPalindrome = findLongestPalindrome(input);
        int palindromeCount = countPalindromicSubstrings(input);

        System.out.println("\nAdditional Analysis:");
        System.out.println("Longest palindromic substring: \"" + longestPalindrome + "\"");
        System.out.println("Total palindromic substrings: " + palindromeCount);

        // Performance comparison
        comparePerformance(input);
    }

    /**
     * Compare performance of different palindrome checking methods
     * @param str String to test
     */
    private static void comparePerformance(String str) {
        System.out.println("\nPerformance Comparison:");

        // Test basic approach
        long startTime = System.nanoTime();
        boolean result1 = isPalindromeIgnoreSpacesAndCase(str);
        long endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Test reverse approach
        startTime = System.nanoTime();
        boolean result2 = isPalindromeUsingReverse(str);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // Test recursive approach
        startTime = System.nanoTime();
        String cleaned = cleanString(str);
        boolean result3 = cleaned.length() > 0 ? 
                         isPalindromeRecursive(cleaned, 0, cleaned.length() - 1) : true;
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        System.out.println("Two-pointer approach: " + time1 + " nanoseconds");
        System.out.println("Reverse string approach: " + time2 + " nanoseconds");
        System.out.println("Recursive approach: " + time3 + " nanoseconds");
        System.out.println("All methods agree: " + 
                          (result1 == result2 && result2 == result3 ? "✓ Yes" : "✗ No"));
    }

    /**
     * Demonstrate palindrome checking with various examples
     */
    private static void demonstrateWithExamples() {
        System.out.println("\n=== Example Palindromes ===");

        String[] examples = {
            "racecar",
            "A man a plan a canal Panama",
            "race a car",
            "Madam",
            "Was it a car or a cat I saw?",
            "No 'x' in Nixon",
            "12321",
            "hello"
        };

        for (String example : examples) {
            boolean ispalindrome = isPalindromeIgnoreSpacesAndCase(example);
            System.out.println("\"" + example + "\" -> " + 
                             (ispalindrome ? "✓ Palindrome" : "✗ Not palindrome"));
        }
    }
}