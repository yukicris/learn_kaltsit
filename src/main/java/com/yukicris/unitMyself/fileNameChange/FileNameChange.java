package com.yukicris.unitMyself.fileNameChange;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileNameChange {
    public static void main(String[] args) {
        //选择所有文件下所有该后缀文件
        File folder = new File("G:/gal/mv/");
        File[] files = folder.listFiles();
        //List<File> imageFiles = new ArrayList<>();
        List<String> fileNameList = new ArrayList<>();
        for (File file:files) {
            if (file.isDirectory()){
                File[] newFiles = file.listFiles();
                for (File fileChild:newFiles) {
                    if(fileChild.isFile()&&fileChild.getName().endsWith(".jpg")){
                        //imageFiles.add(file);
                        fileNameList.add(fileChild.getName());

                        String Name = fileChild.getName().replace(".jpg",".mp4");
                        fileChild.renameTo(new File(fileChild.getParent()+ "\\" +Name));
                    }
                }
            }else{
                if(file.isFile()&&file.getName().endsWith(".jpg")){
                    //imageFiles.add(file);
                    fileNameList.add(file.getName());
                    String Name = file.getName().replace(".jpg",".mp4");
                    file.renameTo(new File(file.getParent()+ "\\" +Name));
                }
            }
        }

    }

}
