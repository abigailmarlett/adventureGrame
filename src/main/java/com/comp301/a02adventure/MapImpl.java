package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int width;
  private final int height;
  private final int numItems;
  private final CellImpl[][] board;
  // private final ArrayList list;
  private CellImpl cell;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0) {
      throw new IllegalArgumentException("width cannot be negative");
    }
    if (height <= 0) {
      throw new IllegalArgumentException("height cannot be negative");
    }
    this.width = width;
    this.height = height;
    this.numItems = numItems;
    this.board = new CellImpl[width][height];
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Cell getCell(int x, int y) {
    // Getter method for a specific cell on the map. Throws an IndexOutOfBoundsException for
    // coordinate parameters that are not on the map
    // throw exception
    if (x >= this.getWidth() || x < 0) {
      throw new IndexOutOfBoundsException("X cannot be less than 0");
    }
    if (y >= this.getHeight() || y < 0) {
      throw new IndexOutOfBoundsException("Y cannot be less than 0");
    }

    return this.board[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    // Overloaded getter method for a specific cell on the map. Throws an IndexOutOfBoundsException
    // for coordinate parameters that are not on the map
    if (position == null) {
      throw new IllegalArgumentException("Position cannot be null");
    }
    if (position.getX() >= this.getWidth() || position.getX() < 0) {
      throw new IndexOutOfBoundsException("X cannot be less than 0");
    }
    if (position.getY() >= this.getHeight() || position.getY() < 0) {
      throw new IndexOutOfBoundsException("Y cannot be less than 0");
    }
    // this.cell = new CellImpl(position.getX(), position.getY());
    return this.board[position.getX()][position.getY()];
  }

  @Override
  public void initCell(int x, int y) {
    // Initializes a new CellImpl object at the specified location on the map, overwriting any
    // existing Cell at that location. Throws an IndexOutOfBoundsException for coordinate parameters
    // that are not on the map
    if (x >= this.getWidth() || x < 0) {
      throw new IndexOutOfBoundsException("X cannot be less than 0");
    }
    if (y >= this.getHeight() || y < 0) {
      throw new IndexOutOfBoundsException("Y cannot be less than 0");
    }
    // CellImpl initcell = new CellImpl(x, y);
    // add to array?
    // list.add(initcell);
    // 2D array
    board[x][y] = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
