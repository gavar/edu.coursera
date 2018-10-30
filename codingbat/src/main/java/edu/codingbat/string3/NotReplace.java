package edu.codingbat.string3;

/**
 * Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not".
 * The word "is" should not be immediately preceded or followed by a letter -- so for example the "is" in "this" does not count.
 * (Note: Character.isLetter(char) tests if a char is a letter.)
 * https://codingbat.com/prob/p154137
 */
@SuppressWarnings("WeakerAccess")
class NotReplace {

    public String notReplace(String str) {
        int from = 0, to = 0;
        int size = str.length();
        StringBuilder sb = new StringBuilder();

        while (to < size) {
            int next = indexOfNonLetter(str, to, size);
            if (match(str, to, next, "is")) {
                sb.append(str, from, next);
                sb.append(" not");
                from = next;
            }
            to = next + 1;
        }

        if (from < size)
            sb.append(str, from, size);

        return sb.toString();
    }

    private int indexOfNonLetter(String str, int i, int size) {
        for (; i < size; i++)
            if (!isLetter(str.charAt(i)))
                break;
        return i;
    }

    private boolean match(String str, int from, int to, String value) {
        int size = value.length();
        if (to - from != size)
            return false;

        for (int i = 0; i < size; i++)
            if (str.charAt(from + i) != value.charAt(i))
                return false;

        return true;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' ||
                c >= 'A' && c <= 'Z';
    }
}
