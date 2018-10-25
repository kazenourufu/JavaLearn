package IO;

import java.io.*;

public class JavaIO {

    final static String address = "D:\\Java\\IO SPACE\\";
    final static String file_1 = "文件1.txt";
    final static String file_2 = "文件2.txt";


    public static void main(String[] args) {
        System.out.println("*************test组1*************");
        testFileCreateAndDelete();
        System.out.println();
        System.out.println("*************test组2*************");
        testReadAndWrite();
    }


    public static void testFileCreateAndDelete(){
        File file = new File(address,file_1);
        if(file.exists()){
            analyzeFile(file);
            file.delete();
            System.out.println("文件存在,并已删除");
        } else{
            System.out.println("文件不存在");
            try {
                file.createNewFile();
                System.out.println("文件已创立");
                analyzeFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void analyzeFile(File file){
        if(file.exists()){
            System.out.println("----------目标文件已定位----------");
            String fileName = file.getName();
            long leng = file.length();
            boolean isHidden = file.isHidden();
            String path = file.getPath();
            String parent = file.getParent();
            long size = file.getTotalSpace();
            System.out.println("-----------文件分析开始-----------");
            System.out.println(
                      "文件名: " + fileName + "\n"
                    + "文件长度: " + leng + "\n"
                    + "文件是否隐藏: " + isHidden+"\n"
                    + "文件路径: " + path +"\n"
                    + "文件父路径: " + parent + "\n"
                    + "总空间：" + size
            );
        }
    }

    public static void testReadAndWrite(){
        File file = new File(address,file_2);
        try {
            FileOutputStream out = new FileOutputStream(file);
            String str = "万物皆虚，万事皆允";
            byte out_data[] = str.getBytes();
            out.write(out_data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            FileInputStream in = new FileInputStream(file);
            byte in_data[] = new byte[2000];
            int length = in.read(in_data);
            String in_str = new String(in_data,0,length);
            System.out.println(in_str);
        } catch (Exception e){
            e.printStackTrace();
        }

        analyzeFile(file);
    }
}
