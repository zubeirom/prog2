public class GgtRekursiv implements GgT {

    @Override
    public long berechneGgt(long a, long b) {
        return b == 0 ? a : berechneGgt(b, a % b);
    }
}
