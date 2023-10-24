package pair;

public class Pair<T, U> {

    private final T first;

    private final U second;

    private Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T, U> Pair<T, U> of(T first, U second) {
        return new Pair<>(first, second);
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair<?, ?> other = (Pair<?, ?>) obj;

        return java.util.Objects.equals(first, other.first)
                && java.util.Objects.equals(second, other.second);
    }

    @Override
    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }

}
