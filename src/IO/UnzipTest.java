package IO;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class UnzipTest {
    public static void main(String[] args) {
        File file = new File("D:\\Java\\IO SPACE\\hello.zip");
        try {
            ZipFile zipfile = new ZipFile(file);
            ZipInputStream zipin = new ZipInputStream(new FileInputStream(file));
            ZipEntry entry = zipin.getNextEntry();
            while(((entry=zipin.getNextEntry())!=null)&&!entry.isDirectory()){
                File tmp = new File("D:\\Java\\IO SPACE"+entry.getName());
                if (!tmp.exists()){
                    tmp.getParentFile().mkdirs();
                    OutputStream os = new FileOutputStream(tmp);
                    InputStream in = zipfile.getInputStream(entry);
                    int count = 0;
                    while ((count=in.read())!=-1){
                        os.write(count);
                    }
                    os.close();
                    in.close();
                }
                zipin.closeEntry();
                System.out.println("解压成功");
            }
            zipin.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
