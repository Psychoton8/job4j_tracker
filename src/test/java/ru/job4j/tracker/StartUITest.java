package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("item one"));
        Item two = tracker.add(new Item("item two"));
        String findMyItem = "item one";

        UserAction[] actions = new UserAction[]{
                new FIndByNameAction(out),
                new ExitAction()
        };
        Input in = new StubInput(
                new String[] {"0", findMyItem, "1"}
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
                        + "=== Find items by name ===" + ln
                        + "Item{id=1, name='" + findMyItem + "', created="
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"))
                        + "}" + ln
                        + "Menu." + ln
                        + "0. Find item by name" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindByIdActionIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("item one"));
        Item two = tracker.add(new Item("item two"));

        UserAction[] actions = new UserAction[]{
                new FindByIDAction(out),
                new ExitAction()
        };
        Input in = new StubInput(
                new String[] {"0", String.valueOf(two.getId()), "1"}
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find item by ID" + ln
                        + "1. Exit Program" + ln
                        + "=== Find item by id ===" + ln
                        + "Item{id=2, name='" + two.getName() + "', created="
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"))
                        + "}" + ln
                        + "Menu." + ln
                        + "0. Find item by ID" + ln
                        + "1. Exit Program" + ln
        );
    }

    @Test
    public void whenFindAllActionIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("item one"));
        Item two = tracker.add(new Item("item two"));
        Item three = tracker.add(new Item("item three"));

        UserAction[] actions = new UserAction[]{
                new ShowAction(out),
                new ExitAction()
        };
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Item{id=1, name='" + one.getName() + "', created="
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"))
                        + "}" + ln
                        + "Item{id=2, name='" + two.getName() + "', created="
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"))
                        + "}" + ln
                        + "Item{id=3, name='" + three.getName() + "', created="
                        + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"))
                        + "}" + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        );
    }
}