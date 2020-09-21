import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


public class Main {
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
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Reader br = new Reader();
        //int n = Integer.parseInt(br.readLine());
        int n = br.nextInt();
        String[] input;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        int a,b;
        while (n-- > 0){
//            input = br.readLine().split(" ");
//            a = Integer.parseInt(input[0]);
//            b = Integer.parseInt(input[1]);
            a = br.nextInt();
            b = br.nextInt();

            if (!(map.containsKey(a) && map.get(a)==b) && !(map.ceilingEntry(a) != null && map.ceilingEntry(a).getValue() <= b)) {

                while (map.floorEntry(a) != null && map.floorEntry(a).getValue() >= b) {
                        map.remove(map.floorKey(a));
                }
                map.put(a, b);
            }

        }

        int sum=0;

        Map.Entry<Integer,Integer> temp = map.firstEntry();

        while (temp!=null){
            temp = map.ceilingEntry(temp.getValue());
            sum+=1;
        }

        System.out.println(sum);
    }
}
