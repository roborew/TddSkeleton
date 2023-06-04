package com.oocode;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RecentlyUsedListTest {

    @Test
    public void listShouldBeEmptyWhenInitialised() {
        RecentlyUsedList list = new RecentlyUsedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void listShouldBeAbleToAddItems() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertFalse(list.isEmpty());
    }

    @Test
    public void listShouldbeAbleToGetItems() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("item1");
        assertEquals("item1", list.get(0));
    }

    @Test
    public void listShouldBeAbleToGetTheMostRecentItemFirst() {
        RecentlyUsedList list = new RecentlyUsedList();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        assertEquals("item3", list.get(0));
        assertEquals("item2", list.get(1));
        assertEquals("item1", list.get(2));
    }

    @Test
    public void itemsInTheListAreUnique() {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("item1");
        recentlyUsedList.add("item2");
        recentlyUsedList.add("item1");
        assertThat(recentlyUsedList.get(1), is("item2"));
        assertThat(recentlyUsedList.get(0), is("item1"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itemsInTheListAreUniqueSoDropOffEnd() {
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("item1");
        recentlyUsedList.add("item2");
        recentlyUsedList.add("item1");
        recentlyUsedList.get(2);
    }

    @Test
    public void canTellSize() {
        // also covers theMostRecentItemShouldBeFirstInTheList
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("item1");
        recentlyUsedList.add("item2");
        assertThat(recentlyUsedList.size(), is(2));
    }

    @Test
    public void canTellSizeRemovingDuplicates() {
        // also covers theMostRecentItemShouldBeFirstInTheList
        RecentlyUsedList recentlyUsedList = new RecentlyUsedList();
        recentlyUsedList.add("item1");
        recentlyUsedList.add("item1");
        assertThat(recentlyUsedList.size(), is(1));
    }

}