package netcracker.intensive.rover;


public class main {
    public static void main(String[] args) {

    }


    static void test(Integer... args) {
        int tmp = 0;
        int[][] array = new int[2][2];
        double oldSize = Math.sqrt((double) args.length);
        int size = (int) oldSize;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                array[i][j] = args[tmp];
                ++tmp;
            }
        }

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.println(array[i][j]);
            }
        }

    }
}


