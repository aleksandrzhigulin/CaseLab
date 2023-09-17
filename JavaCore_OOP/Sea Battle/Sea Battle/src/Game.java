import java.util.Scanner;

public class Game {

  public static final int FIELD_WIDTH = 10;
  public static final int FIELD_HEIGHT = 10;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Player player = new Player();
    Player bot = new Player();
    String turn = "player";
    while (player.getHp() > 0 && bot.getHp() > 0) {
      if (turn.equals("player")) {
        System.out.println("Ваша карта");
        printField(player.getField());
        System.out.println("Карта ваших ударов");
        printField(player.getBattlefield());
        System.out.println("Карта противника (dev mode)");
        printField(bot.getField());
        System.out.println("Your hp: " + player.getHp() + ", bot's hp: " + bot.getHp());
        System.out.println("Введите координаты удара через пробел");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        if (!player.makeShot(row - 1, col - 1, bot)) {
          turn = "bot";
          System.out.println("Промах");
        }
      } else {
        if (!bot.makeShot(player)) {
          turn = "player";
          System.out.println("Промах");
        }
      }
    }

    if (player.getHp() == 0) {
      System.out.println("Вы проиграли :(");
    } else {
      System.out.println("Вы выиграли :)");
    }

    scanner.close();
  }


  public static void printField(char[][] field) {
    System.out.println("    1 2 3 4 5 6 7 8 9 10");
    System.out.println("    -------------------");
    for (int row = 0; row < field.length; row++) {
      if ((row + 1) <= 9) {
        System.out.print(" " + (row + 1) + "| ");
      } else {
        System.out.print((row + 1) + "| ");
      }

      for (int col = 0; col < field[row].length; col++) {
        if (col != field[row].length - 1) {
          System.out.print(field[row][col] + " ");
        } else {
          System.out.print(field[row][col]);
        }

      }
      System.out.println();
    }
  }
}
