class Solution02 {
    public String shortestBeautifulSubstring(String s, int k) {

        String best = "";

        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            int count = 0;
            for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
                // Update the count for this index
                if (s.charAt(endIndex) == '1') {
                    count++;
                }

                // If we have a beautiful substring, we can stop looking
                if (count == k) {
                    String candidate = s.substring(startIndex, endIndex + 1);
                    if (best.isEmpty() || candidate.length() < best.length() ||
                        (candidate.length() == best.length() && candidate.compareTo(best) < 0))
                    {
                        best = candidate;
                    }
                    break;
                }
            }
        }

        return best;
    }

}