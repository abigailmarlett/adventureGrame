package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;
  // private ArrayList<Cell> visited;

  public GameImpl(Map map, Player player) {
    if (player == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    if (map == null) {
      throw new IllegalArgumentException("Map cannot be null");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return new ArrayList<>(player.getInventory().getItems());
  }

  @Override
  public boolean getIsWinner() {
    // Returns true if all items on the map have been collected by the player
    return this.player.getInventory().getNumItems() == this.map.getNumItems();
  }

  @Override
  public void printCellInfo() {
    // This method prints information about the Cell where the Player is currently located,
    // according to the following format:
    // First, print "Location: " followed by the Cell's name. For example, if the Cell is named
    // "Polk Place", then this should print: "Location: Polk Place"
    // Next, print the Cell's description on its own line. For example, a description of Polk Place
    // might be: "A beautiful park surrounded by college buildings and an old library. This is the
    // heart of UNC's campus.
    // Next, if the Cell has already been visited before, print the following text on a new line:
    // "You have already visited this location."
    // Next, if there is a chest in the Cell, print the following text on the next line of output:
    // "You found a chest! Type 'open' to see what's inside, or keep moving."
    // Finally, this method should formally mark the Cell "visited" by calling the Cell's visit()
    // method
    System.out.println("Location: " + map.getCell(getPlayerPosition()).getName());
    System.out.println(map.getCell(getPlayerPosition()).getDescription());
    int x = this.getPlayerPosition().getX();
    int y = this.getPlayerPosition().getY();
    // if the spot exists in the arraylist, say you've already visited
    if (this.map.getCell(getPlayerPosition()).getIsVisited()) {
      System.out.println("You have already visited this location.");
    }
    if (this.map.getCell(getPlayerPosition()).hasChest()) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    this.map.getCell(getPlayerPosition()).visit();
  }

  @Override
  public void openChest() {
    // This method handles a user's interaction when they try to open a treasure chest at the
    // current location. If a chest exists in the current Cell, it should be opened and its contents
    //  transferred to the Player's Inventory. Hint: Use the transferFrom() method.
    //  If there is no chest at the current Cell, print: "No chest to open, sorry!"
    //  If there is a chest at the current Cell, but it is empty, print: "The chest is empty."
    //  If the chest is not empty, transfer the chest contents to the Player's Inventory and
    //  print:
    //  "You collected these items: [list of chest items]"
    //  Hint: If you correctly set up the toString() method in the ItemImpl class, you should
    //  be able to print the whole inventory by simply printing the chest items list. For example
    //  something like: System.out.println("You collected these items: " + chest.getItems());
    /*Scanner input = new Scanner(System.in);
    String open = input.nextLine();*/
    int x = this.getPlayerPosition().getX();
    int y = this.getPlayerPosition().getY();
    if (this.map.getCell(this.player.getPosition()).hasChest()) {
      // test if chest has anything
      if (this.map.getCell(this.player.getPosition()).getChest().isEmpty()) {
        System.out.println("The chest is empty.");
      }
      // this.player.getInventory().transferFrom(this.player.getPosition().getChest());
      // else
      else {
        System.out.println(
            "You collected these items: "
                + this.map.getCell(x, y).getChest().getItems().toString());
        this.player.getInventory().transferFrom(map.getCell(x, y).getChest());
      }
    }
    if (!this.map.getCell(this.player.getPosition()).hasChest()) {
      System.out.println("No chest to open, sorry!");
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    Position position = player.getPosition().getNeighbor(direction);
    int x = position.getX();
    int y = position.getY();
    if (x < 0 || x >= map.getWidth() || y < 0 || y >= map.getHeight()) {
      return false;
    } else {
      Cell cell = map.getCell(position);
      return cell != null;
    }
  }

  @Override
  public void move(Direction direction) {
    // Attempts to move the player one unit in the indicated direction. If the player cannot be
    // moved
    // in that direction (i.e., canMove() returns false), this method should instead print the
    // following String on its own line: "You can't go that way! Try another direction." If the move
    // operation was successful, then print the new cell's info to the console using the
    // printCellInfo() method.
    if (!this.canMove(direction)) {
      System.out.println("You can't go that way! Try another direction.");
    } else {
      this.player.move(direction);
      printCellInfo();
    }
  }
}
