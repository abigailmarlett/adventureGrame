package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private int x;
  private int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    int x = this.getX();
    int y = this.getY();
    PositionImpl neighbor = new PositionImpl(x, y);
    if (direction == Direction.NORTH) {
      neighbor.y += 1;
    }
    if (direction == Direction.SOUTH) {
      neighbor.y -= 1;
    }
    if (direction == Direction.EAST) {
      neighbor.x += 1;
    }
    if (direction == Direction.WEST) {
      neighbor.x -= 1;
    }
    return neighbor;
  }
}
