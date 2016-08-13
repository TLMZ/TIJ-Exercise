package IO;

import java.io.File;
import java.io.IOException;

public class listDir {
    public static void listDirectory(File dir)throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("文件不存在！");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }
        File[] file = dir.listFiles();
        if (file != null && file.length > 0) {
            for (File files : file) {
                if (files.isDirectory()){
                    listDirectory(files);
                }else {
                    System.out.println(files);
                }
            }
        }
    }

        }
