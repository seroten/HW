public class Backpack {
    private Item[] items;

    public Backpack(Item[] items) {
        this.items = items;
    }

    public int findBestSum(int number, int weight) {
        if(number < 0) {
            return 0;
        }

        if(items[number].weight > weight) {
            return findBestSum(number-1, weight);
        } else {
            return Math.max(findBestSum(number-1, weight),
                    findBestSum(number-1,
                            weight - items[number].weight + items[number].price));
        }
    }
}