public class Main {
    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        System.out.println("Пустой массив: " + array);

        array.add(10);
        array.add(20);
        array.add(30);

        System.out.println("После добавления: " + array);

        System.out.println("Элемент по индексу 1: " + array.get(1));

        int removed = array.remove(0);
        System.out.println("Удалён элемент: " + removed);

        System.out.println("После удаления: " + array);
        System.out.println("Текущий размер: " + array.size());
    }
}
