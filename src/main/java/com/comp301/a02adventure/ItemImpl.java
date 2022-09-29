package com.comp301.a02adventure;

public class ItemImpl implements Item {
  private final String name;

  public ItemImpl(String name) {
    // constructor goes here
    // throw exception
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object other) {
    /*The equals() method tests to see if the "this" object is the same as the "other" object,
    returning true if they are the same, or false if they are not. For this method, assume two
    Items are the same if they have the same "name" String.*/
    if (other instanceof Item) {
      Item otherCasted = (Item) other;
      return this.getName().equals(otherCasted.getName());
    }
    return false;
  }

  @Override
  public String toString() {
    /*The toString() method generates a human-readable, String representation of the object,
    suitable for printing to the console either for debugging or for the eventual user to read. For
    this method, assume the "string representation" of an Item is simply the item's name String.*/
    return this.getName();
  }
}
