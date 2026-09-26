class Solution {

    public String evaluate(String s, List<List<String>> knowledge) {

        // Store all key-value pairs in a HashMap
        HashMap<String, String> knowledgeBase = new HashMap<>();

        for (List<String> entry : knowledge) {
            knowledgeBase.put(entry.get(0), entry.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder currentKey = new StringBuilder();

        boolean insideBracket = false;

        for (char currentChar : s.toCharArray()) {

            if (currentChar == '(') {

                // Start reading a key
                insideBracket = true;
                currentKey.setLength(0);

            } else if (currentChar == ')') {

                // Key is complete, look it up
                String value = knowledgeBase.getOrDefault(
                    currentKey.toString(),
                    "?"
                );

                result.append(value);

                // Stop reading the key
                insideBracket = false;

            } else {

                if (insideBracket) {
                    currentKey.append(currentChar);
                } else {
                    result.append(currentChar);
                }
            }
        }

        return result.toString();
    }
}