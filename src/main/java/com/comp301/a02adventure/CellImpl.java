package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private final Position position;
  private String name;
  private String description;
  private Inventory chest;
  private boolean visited;
  private boolean hasChest;

  public CellImpl(int x, int y, String name, String description) {
    Position position = new PositionImpl(x, y);
    this.chest = null;
    // Inventory chest = new InventoryImpl();
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    if (description == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.name = name;
    this.description = description;
    this.visited = false;
    this.position = position;
    this.hasChest = false;
  }

  public CellImpl(int x, int y) {
    this.chest = null;
    Position position = new PositionImpl(x, y);
    Inventory chest = new InventoryImpl();
    this.name = "";
    this.description = "";
    this.visited = false;
    this.position = position;
    this.hasChest = false;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    // throw exception
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.name = name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public void setDescription(String description) {
    // throw exception
    if (description == null) {
      throw new IllegalArgumentException("Description cannot be null");
    }
    this.description = description;
  }

  @Override
  public Position getPosition() {
    return this.position;
  }

  @Override
  public Inventory getChest() {
    return this.chest;
  }

  @Override
  public void setChest(Inventory chest) {
    // throw exception
    if (chest == null) {
      throw new IllegalArgumentException("Chest cannot be null");
    }
    this.chest = chest;
    this.hasChest = true;
  }

  @Override
  public boolean getIsVisited() {
    return this.visited;
  }

  @Override
  public boolean hasChest() {
    return this.hasChest;
  }

  @Override
  public void visit() {
    this.visited = true; // using keyword final???
  }
}
