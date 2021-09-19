package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    private final List<String> answer;
    private int position = 0;

    public StubInput(List<String> answer) {
        this.answer = answer;
    }

    @Override
    public String askStr(String question) {
        return answer.get(position++);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
