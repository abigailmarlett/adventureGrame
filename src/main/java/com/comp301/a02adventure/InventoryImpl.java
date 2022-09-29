package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private final List<Item> itemsList;

  public InventoryImpl() {
    itemsList = new ArrayList<Item>();
  }

  public boolean isEmpty() {
    return itemsList.size() == 0; // returns true if the size is equal to 0, false otherwise
  }

  public int getNumItems() {
    return this.itemsList.size();
  }

  public List<Item> getItems() {
    return new ArrayList<>(itemsList);
  }

  public void addItem(Item item) {
    this.itemsList.add(item);
  }

  public void removeItem(Item item) {
    this.itemsList.remove(item);
  }

  public void clear() {
    this.itemsList.clear();
  }

  public void transferFrom(Inventory other) {
    // Removes the Items from an "other" Inventory, and adds them into "this" Inventory
    for (int i = 0; i < other.getNumItems(); i++) {
      this.itemsList.add(other.getItems().get(i));
    }
    other.clear();
  }
}
