package IO.DirList;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by ALiP on 2016.08.11.
 *
 * 使用正则表达式的编译形式创建一个匹配器，
 * 与指定输入匹配。
 * accept()：判断指定的文件是否包含在某一文件列表
 * Arrays类包含操作数组的各种方法
 */
class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        pattern=Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
public class DirList {
    public static void main(String[] args) {
        File path=new File(".");
        String[] list;
        if (args.length==0)
            list=path.list();
        else
            list=path.list(new DirFilter(args[0]));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem:list)
            System.out.println(dirItem);
    }
}
