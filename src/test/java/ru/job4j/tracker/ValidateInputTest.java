package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Input in = new StubInput(new String[]{"one", "1"});
        ValidateInput validateInput = new ValidateInput(new StubOutput(), in);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Input in = new StubInput(new String[]{"1"});
        ValidateInput validateInput = new ValidateInput(new StubOutput(), in);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInputRepeatedly() {
        Input in = new StubInput(new String[]{"1", "2"});
        ValidateInput validateInput = new ValidateInput(new StubOutput(), in);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(1));
        selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(2));
    }

    @Test
    public void whenNegativeNumber() {
        Input in = new StubInput(new String[]{"-1"});
        ValidateInput validateInput = new ValidateInput(new StubOutput(), in);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}