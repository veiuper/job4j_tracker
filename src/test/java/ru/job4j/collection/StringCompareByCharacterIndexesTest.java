package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class StringCompareByCharacterIndexesTest {

    @Test
    public void compareWhen11And11() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        String in1 = "11";
        String in2 = "11";
        assertThat(comparator.compare(in1, in2), is(0));
    }

    @Test
    public void compareWhen12And11() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("12", "11"), greaterThan(0));
    }

    @Test
    public void compareWhen21And11() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("21", "11"), greaterThan(0));
    }

    @Test
    public void compareWhen11And12() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("11", "12"), lessThan(0));
    }

    @Test
    public void compareWhen11And21() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("11", "21"), lessThan(0));
    }

    @Test
    public void compareWhen11And111() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("11", "111"), lessThan(0));
    }

    @Test
    public void compareWhen12And111() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("12", "111"), greaterThan(0));
    }

    @Test
    public void compareWhen21And111() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("21", "111"), greaterThan(0));
    }

    @Test
    public void compareWhen11And121() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("11", "121"), lessThan(0));
    }

    @Test
    public void compareWhen11And211() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("11", "211"), lessThan(0));
    }

    @Test
    public void compareWhen111And11() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("111", "11"), greaterThan(0));
    }

    @Test
    public void compareWhen121And11() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("121", "11"), greaterThan(0));
    }

    @Test
    public void compareWhen211And11() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("211", "11"), greaterThan(0));
    }

    @Test
    public void compareWhen111And12() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("111", "12"), lessThan(0));
    }

    @Test
    public void compareWhen111And21() {
        StringCompareByCharacterIndexes comparator = new StringCompareByCharacterIndexes();
        assertThat(comparator.compare("111", "21"), lessThan(0));
    }
}