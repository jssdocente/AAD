package ejemplos;


import java.util.Arrays;
import java.util.List;

public class Ejemplo_Objects {
    public static void main(String[] args) {




    }

    /* Cuando la programación funcional brilla, es cuando trabajamos con objectos */
    public void calculateTotalItems() {

        Item item1 = new Item(1, 10);
        Item item2 = new Item(2, 15);
        Item item3 = new Item(3, 25);
        Item item4 = new Item(4, 40);

        List<Item> items = Arrays.asList(item1, item2, item3, item4);

        //Sumamos -- varias formas

        //Con sum
        Integer suma1= items.stream()
                .mapToInt(item->Integer.valueOf(item.getPrice()))
                .sum();

        //Con Reducción
        Integer sum = items.stream()
                .map(x -> x.getPrice())
                .reduce(0, (a,b) -> Integer.sum(a,b));


    }


    public class Item {

        private int id;
        private Integer price;

        public Item(int id, Integer price) {
            this.id = id;
            this.price = price;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        // Standard getters and setters
    }
}
