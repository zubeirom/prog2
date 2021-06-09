public abstract class ApplyAndPrint {

    public void applyAndPrint(int i, int j, MyFunction func) {
        for (int k = i; k <= j; k++) {
            System.out.println(func.apply(i));
        }
    }
}

