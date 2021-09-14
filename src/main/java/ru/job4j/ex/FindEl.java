package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws FindNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new FindNotFoundException("The index for the string '" + key + "' was not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"a", "b"}, "a");
            indexOf(new String[]{"a", "b"}, "c");
        } catch (FindNotFoundException e) {
            e.printStackTrace();
        }
    }
}
