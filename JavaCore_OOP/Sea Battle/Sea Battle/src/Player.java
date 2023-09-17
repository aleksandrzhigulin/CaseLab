import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Player {

  private final char[][] field = new char[Game.FIELD_WIDTH][Game.FIELD_HEIGHT];
  private final char[][] battlefield = new char[Game.FIELD_WIDTH][Game.FIELD_HEIGHT];

  private final Set<List<Integer>> shots = new HashSet<>();
  private int hp = 20;

  public Player() {
    // Field setup
    for (int row = 0; row < Game.FIELD_WIDTH; row++) {
      for (int col = 0; col < Game.FIELD_HEIGHT; col++) {
        field[row][col] = '0';
        battlefield[row][col] = '0';
      }
    }

    generateField();

    for (int row = 0; row < field.length; row++) {
      for (int col = 0; col < field[row].length; col++) {
        if (field[row][col] == 'x') {
          field[row][col] = '0';
        }
      }
    }

  }

  public char[][] getField() {
    return field;
  }

  public char[][] getBattlefield() {
    return battlefield;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  private void generateField() {
    /* 4 однопалубных, 3 двухпалубных, 2 трёхпалубных, 1 четырёхпалубный */
    try {
      Map<Integer, Integer> ships = new HashMap<>() {
      };
      // Палубность, количество
      ships.put(1, 4);
      ships.put(2, 3);
      ships.put(3, 2);
      ships.put(4, 1);
      for (Entry<Integer, Integer> el : ships.entrySet()) {
        for (int i = 0; i < el.getValue(); i++) {
          generateShip(el.getKey());
        }
      }
    } catch (RuntimeException e) {
      for (int row = 0; row < Game.FIELD_WIDTH; row++) {
        for (int col = 0; col < Game.FIELD_HEIGHT; col++) {
          field[row][col] = '0';
          battlefield[row][col] = '0';
        }
      }
      generateField();
    }


  }

  private void generateShip(Integer palubs) {
    boolean flag = true;
    int iterations = 0;
    while (flag) {
      if (iterations > 20) {
        throw new RuntimeException("Unavailable to generate the field");
      }
      String orientation = (int) (Math.random() * 2) == 0 ? "horizontal" : "vertical";
      int[] startCell = generateFirstCell();
      int row = startCell[0];
      int col = startCell[1];
      List<List<Integer>> cellsOfShip = new ArrayList<>();
      for (int i = 1; i <= palubs; i++) {
        if (orientation.equals("horizontal")) {
          if (isFree(row, col + i)) {
            cellsOfShip.add(Arrays.asList(row, col + i));
          } else {
            cellsOfShip.clear();
            break;
          }
        } else {
          if (isFree(row + i, col)) {
            cellsOfShip.add(Arrays.asList(row + i, col));
          } else {
            cellsOfShip.clear();
            break;
          }
        }

      }

      if (cellsOfShip.size() != palubs) {
        for (int i = 1; i <= palubs; i++) {

          if (orientation.equals("horizontal")) {
            if (isFree(row, col - i)) {
              cellsOfShip.add(Arrays.asList(row, col - i));
            } else {
              cellsOfShip.clear();
              break;
            }
          } else {
            if (isFree(row - i, col)) {
              cellsOfShip.add(Arrays.asList(row - i, col));
            } else {
              cellsOfShip.clear();
              break;
            }
          }
        }

        if (cellsOfShip.size() == palubs) {
          flag = false;
          updateBlacklist(cellsOfShip);
          for (List<Integer> list : cellsOfShip) {
            field[list.get(0)][list.get(1)] = palubs.toString().toCharArray()[0];
          }
        }

      }
      iterations++;
    }
  }

  private void updateBlacklist(List<List<Integer>> cellsOfShip) {
    /* # - клетки корабля
       0 - клетки поля
       x - недоступные для расстановки кораблей клетки

       0 0 0 0 0 0   |  0 0 0 0 0
       0 x x x x 0   |  0 x x x 0
       0 x # # x 0   |  0 x # x 0
       0 x x x x 0   |  0 x x x 0
       0 0 0 0 0 0   |  0 0 0 0 0
    */
    int min_row = Integer.MAX_VALUE;
    int max_row = Integer.MIN_VALUE;
    int min_col = Integer.MAX_VALUE;
    int max_col = Integer.MIN_VALUE;
    for (List<Integer> integers : cellsOfShip) {
      min_row = Math.min(integers.get(0), min_row);
      max_row = Math.max(integers.get(0), max_row);
      min_col = Math.min(integers.get(1), min_col);
      max_col = Math.max(integers.get(1), max_col);
    }

    for (int row = min_row - 1; row <= max_row + 1; row++) {
      for (int col = min_col - 1; col <= max_col + 1; col++) {
        if ((row >= 0 && row < 10) && (col >= 0 && col < 10)) {
          field[row][col] = 'x';
        }
      }
    }
  }

  public void setCellValue(int row, int col, char value) {
    field[row][col] = value;
  }

  public char getCellValue(int row, int col) {
    return field[row][col];
  }

  private int[] generateFirstCell() {

    int row = (int) (Math.random() * (Game.FIELD_WIDTH));
    int column = (int) (Math.random() * (Game.FIELD_HEIGHT));

    while (field[row][column] != '0') {
      if (field[row][column] == '0') {
        return new int[]{row, column};
      }
      row = (int) (Math.random() * (Game.FIELD_WIDTH));
      column = (int) (Math.random() * (Game.FIELD_HEIGHT));
    }
    return new int[]{row, column};
  }

  private boolean isFree(int row, int column) {
    try {
      return field[row][column] == '0';
    } catch (Exception e) {
      return false;
    }

  }

  // Для бота
  public boolean makeShot(Player enemy) {
    int row = (int) (Math.random() * (Game.FIELD_WIDTH));
    int col = (int) (Math.random() * (Game.FIELD_HEIGHT));
    while (shots.contains(Arrays.asList(row, col))) {
      row = (int) (Math.random() * (Game.FIELD_WIDTH));
      col = (int) (Math.random() * (Game.FIELD_HEIGHT));
    }
    System.out.println("Противник выбрал строку:" + (row + 1) + ", столбец:" + (col + 1));
    shots.add(Arrays.asList(row, col));
    return makeShot(row, col, enemy);
  }

  public boolean makeShot(int row, int col, Player enemy) {
    // true -> попадание
    // false -> промах
    if (enemy.getCellValue(row, col) != '0' && enemy.getCellValue(row, col) != 'x') {
      battlefield[row][col] = 'X';
      System.out.println("Попадание");
      enemy.setHp(enemy.getHp() - 1);
      enemy.setCellValue(row, col, 'x');
      return true;
    }
    battlefield[row][col] = '#';
    return false;
  }

}
