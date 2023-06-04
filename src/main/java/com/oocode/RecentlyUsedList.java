package com.oocode;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList {

    List<String> recentItems = new ArrayList<String>();

    public boolean isEmpty() {
        return recentItems.isEmpty();
    }

    public void add(String item) {
        addNewestItemToTopoflist(item);
    }

    public String get(int index) {
        return recentItems.get(index);
    }

    public int size() {
        return recentItems.size();
    }

  private void addNewestItemToTopoflist(String item) {
    recentItems.remove(item);
    recentItems.add(0, item);
  }

}
