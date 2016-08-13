package IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafDemo {
    public static void main(String[] args) throws IOException {
        File demo = new File("demo");
        if(!demo.exists())demo.mkdir();
        File file=new File(demo,"raf.dat");
        if(!file.exists())file.createNewFile();

        RandomAccessFile raf=new RandomAccessFile(file,"rw");
        //指针的位置
        System.out.println(raf.getFilePointer());

        raf.write('a');
        System.out.println(raf.getFilePointer());
        raf.write('b');

        int i=0x7fffffff;
        raf.write(i>>24);
        raf.write(i>>16);
        raf.write(i>>8);
        raf.write(i);
        System.out.println(raf.getFilePointer());

        String s="中";
        byte[] utf8=s.getBytes();
        raf.write(utf8);
        System.out.println(raf.length());

        /*
        读文件，必须把指针移到头部
         */
        raf.seek(0);
        //一次性读完
        byte[] buf=new byte[(int)raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));
    }
}
