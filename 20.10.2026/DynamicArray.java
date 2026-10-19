public class DynamicArray {
    private int[] data;

    public DynamicArray() {
        this.data = new int[0];
    }

    public void add(int value) {
        int[] newData = new int[data.length + 1];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        newData[data.length] = value;
        data = newData;
    }

    public int get(int index) {
        return data[index];
    }

    public int remove(int index) {
        int removedValue = data[index];
        int[] newData = new int[data.length - 1];

        for (int i = 0; i < index; i++) {
            newData[i] = data[i];
        }

        for (int i = index; i < data.length - 1; i++) {
            newData[i] = data[i + 1];
        }
        data = newData;
        return removedValue;
    }

    public int size() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < data.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(data[i]);
        }
        return sb.append("]").toString();
    }
}
