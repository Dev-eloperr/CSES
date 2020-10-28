import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader br = new Reader();
        int n = br.nextInt();
        long sum=0, max=0;
        int max_under_zero = Integer.MIN_VALUE, flag=0;
        for(int i =0;i<n;i++){
            int x = br.nextInt();
            if(x > max_under_zero && x<0)
                max_under_zero = x;
            sum += x;
            if(sum<0) {
                sum = 0;
                flag++;
            }
            if(sum > max){
                max = sum;
            }
        }
        if(flag==n) System.out.println(max_under_zero);
        else System.out.println(max);
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
