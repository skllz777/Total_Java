package Store;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    ToyStore toyStore = new ToyStore();

    toyStore.addToy(new Toy(1, "Кукла", 0.3));
    toyStore.addToy(new Toy(2, "Робот", 0.4));
    toyStore.addToy(new Toy(3, "Мяч", 0.3));
    toyStore.addToy(new Toy(4, "Настольная игра", 0.4));
    toyStore.addToy(new Toy(5, "Самолетик", 0.2));

    try {
      FileWriter writer = new FileWriter("Toy store\\output.txt");

      int counter = 0;
      int maxToys = 10;
      while (counter < maxToys) {
        Toy toy = toyStore.getRandomToy();

        if (toy != null) {
          counter++;
          writer.write(counter + ". " + "Выбрана игрушка: " + toy.getName() + " (Шанс выпадения" + " " + toy.getChance()
              + "%" + ")\n");
        }
      }

      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}