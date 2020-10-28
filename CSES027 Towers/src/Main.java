import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader br = new Reader();
        int n = br.nextInt()-1;
        TreeMap<Integer,Integer> tower_header = new TreeMap();
        tower_header.put(br.nextInt(),1);
        while(n-- > 0) {
            int x = br.nextInt();

            if (tower_header.ceilingKey(x) != null) {
                if (tower_header.ceilingKey(x) != x) {
                    if(tower_header.get(tower_header.ceilingKey(x))==1)
                        tower_header.remove(tower_header.ceilingKey(x));
                    else
                        tower_header.put(tower_header.ceilingKey(x),tower_header.get(tower_header.ceilingKey(x))-1);
                    tower_header.put(x, 1);
                } else {
                    int value = tower_header.get(x);
                    tower_header.remove(x);


                    if(tower_header.ceilingKey(x) != null){
                        if(tower_header.get(tower_header.ceilingKey(x))==1)
                            tower_header.remove(tower_header.ceilingKey(x));
                        else
                            tower_header.put(tower_header.ceilingKey(x),tower_header.get(tower_header.ceilingKey(x))-1);
                    }
                    tower_header.put(x, value + 1);
                }
            }else{
                tower_header.put(x,1);
            }

        }
        int sum=0;
        for(Map.Entry<Integer,Integer> entry : tower_header.entrySet()){
            sum+=entry.getValue();
        }
        System.out.println(sum);
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
