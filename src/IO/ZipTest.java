package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {
    private void zip(String fileNamel, File inputFile) throws Exception {
        ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(fileNamel));
        zip(zipout,inputFile,"");
        System.out.println("文件正在压缩");
        zipout.close();
    }

    private void zip(ZipOutputStream zipout, File inputFile, String base) throws Exception{
        if(inputFile.isDirectory()){
            File[] files = inputFile.listFiles();
            if(base.length()!=0){
                zipout.putNextEntry(new ZipEntry(base+"/"));
            }
            for (int i = 0; i < files.length; i++) {
                zip(zipout,files[i],base+files[i]);
            }
        } else {
            zipout.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(inputFile);
            int b;
            System.out.println("文件："+base);
            while((b=in.read())!=-1){
                System.out.println("b 是" + b);
                zipout.write(b);
            }
            System.out.println("准备关闭流");
            in.close();
        }
    }

    public static void main(String[] args) {
        ZipTest myzip = new ZipTest();
        try {
            String filename = "D:\\Java\\IO SPACE\\hello.zip";
            File tgt = new File("D:\\Java\\IO SPACE\\hello.txt");
            if(!tgt.exists()){
                tgt.createNewFile();
            }
            myzip.zip(filename,tgt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
