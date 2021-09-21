package ru.job4j.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        String key = "1";
        String name = "name 1";
        HashMap<String, Order> map = OrderConvert.process(
                List.of(new Order(key, name))
        );
        assertThat(map.get(key), is(new Order(key, name)));
    }

    @Test
    public void whenDuplicateOrderInList() {
        String key = "1";
        String name = "name 1";
        List<Order> list = List.of(
                new Order(key, name),
                new Order(key, name)
        );
        HashMap<String, Order> map = OrderConvert.process(list);
        assertEquals(list.size() - 1, map.size());
    }
}