
import java.io.*;
import java.util.*;

public class D {
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

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
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
    }
    static Reader sc = new Reader();
    static StringBuilder output = new StringBuilder();
    static TreeSet<Integer> DataSet = new TreeSet();
    static Integer Lower;
    static Integer Higher;
    static TreeMap<Integer,Integer> GapHeap = new TreeMap<Integer,Integer>();
    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int q = sc.nextInt();
        for (int i=0;i<n;i++){
            add(sc.nextInt());
        }
        appendAns();
        for (int i=0;i<q;i++){
            if (sc.nextInt()==1){
                add(sc.nextInt());
            }else {
                remove(sc.nextInt());
            }
            appendAns();
        }
        System.out.println(output);
    }
    public static void add(int n){
        DataSet.add(n);
        Higher = DataSet.higher(n);
        Lower = DataSet.lower(n);
        if (Higher==null){
            if (Lower==null){
                return;
            }
            addTo(n-Lower);
            return;
        }
        if (Lower==null){
            addTo(Higher-n);
            return;
        }
        removeFrom(Higher-Lower);
        addTo(Higher-n);
        addTo(n-Lower);
    }
    public static void addTo(int x){
        if (GapHeap.containsKey(x)){
           GapHeap.put(x,GapHeap.get(x)+1);
        }else {
            GapHeap.put(x,1);
        }
    }
    public static void removeFrom(int x){
        if (GapHeap.containsKey(x)){
            if (GapHeap.get(x)<=1){
                GapHeap.remove(x);
            }else {
                GapHeap.put(x,GapHeap.get(x)-1);
            }
        }
    }
    public static void remove(int n){
        Higher = DataSet.higher(n);
        Lower = DataSet.lower(n);
        if (Higher==null){
            if (Lower==null){
                DataSet.remove(n);
                return;
            }
            removeFrom(n-Lower);
            DataSet.remove(n);
            return;
        }
        if (Lower==null){
            if ( Higher==null){
                DataSet.remove(n);
                return;
            }
            removeFrom( Higher-n);
            DataSet.remove(n);
            return;
        }
        removeFrom(Higher-n);
        removeFrom(n-Lower);
        addTo(Higher-Lower);
        DataSet.remove(n);
    }
    public static void appendAns(){
        int ans = 0;
        if (DataSet.isEmpty()){
        }else {
            ans = DataSet.last()-DataSet.first();
        }
        if (GapHeap.isEmpty()){
            ans = 0;
        }else {
            ans = ans - GapHeap.lastKey();
        }
        output.append(ans+"\n");
    }
}
/***
 *
 *
 *
 *
 *     1 4 5 6 8 9
 *     Max - min = (Max Gap)
 *
 *     A   C   B
 *
 *      B-C C-A
 *
 *  | | | | | | |
 *     A C
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */