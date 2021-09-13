package ru.job4j.tracker;

public class StubOutput implements Output {
    private final StringBuilder builder = new StringBuilder();

    @Override
    public String toString() {
        return builder.toString();
    }

    @Override
    public void println(Object object) {
        if (object != null) {
            builder.append(object);
        } else {
            builder.append("null");
        }
        builder.append(System.lineSeparator());
    }
}
