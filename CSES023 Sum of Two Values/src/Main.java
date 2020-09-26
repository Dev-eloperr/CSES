import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader br = new Reader();
        int n = br.nextInt();
        int x = br.nextInt();
        int t;
        List<Integer> orig = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            t = br.nextInt();
            orig.add(t);
            sorted.add(t);
        }
        Collections.sort(sorted);

        int i;
        t = -1;
        for (i = 0; i < n - 1; i++) {
            t = Collections.binarySearch(sorted.subList(i + 1, n), x - sorted.get(i));
            if (t >= 0) {
                break;
            }
        }

        if (t < 0 || n == 1)
            System.out.println("IMPOSSIBLE");
        else {
            int ai = sorted.get(i);
            int bi = sorted.get(t + i + 1);
            int a = orig.indexOf(ai), b = (orig.indexOf(bi));
            int flag = 0;
            if (a == b) {
                for (int j = a + 1; j < n; j++) {
                    if (orig.get(j) == ai) {
                        a = j;
                        flag = 1;
                        break;
                    }

                }
                if (flag == 0) {
                    for (int j = b; j < n; j++) {
                        if (orig.get(j) == bi) {
                            b = j;
                            break;
                        }
                    }
                }

            }

            System.out.println((a + 1) + " " + (b + 1));
        }

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }
}
