import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader br = new Reader();
        int n = br.nextInt();
        ArrayList<Integer> set = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=1;
        int index=0;
        for(int i = 0; i < n; i++){
            int x = br.nextInt();

            if (map.containsKey(x)) {
                //set.subList(0,set.indexOf(x)+1).clear();
                //index += set.subList(index,set.size()).indexOf(x)+1;
                index = Integer.max(map.get(x)+1,index);
            }
            map.put(x,i);
            set.add(x);

            max = Integer.max(max, i+1-index);
        }

        System.out.println(max);
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
