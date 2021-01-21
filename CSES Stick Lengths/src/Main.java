import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader br = new Reader();
        int n = br.nextInt();
        double sum=0;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = br.nextInt();
        }
        Arrays.sort(a);
        double median;
        if(n%2==0)
            median = ((double)a[n/2]+(double)a[(n/2)-1])/2;
        else
            median = a[n/2];

        long f = (long)Math.floor(median);
        long c = (long)Math.ceil(median);
        long minc=0;
        long minf=0;
        for (int i = 0; i < n; i++) {
                minf += Math.abs(a[i]-f);
                minc += Math.abs(a[i]-c);
        }
        System.out.println(Math.min(minc, minf));
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }
}
