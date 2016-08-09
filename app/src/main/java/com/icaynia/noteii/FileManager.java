package com.icaynia.noteii;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by icaynia on 16. 8. 6..
 */

public class FileManager {
    String dirPath = "/sdcard/Noteii";
    File file = new File(dirPath);

    public void listFile() {
        if ( file.listFiles().length > 0 )
            for ( File f : file.listFiles() ) {
                String str = f.getName();
                Log.v(null,"fileName : "+str);
                String loadPath = dirPath+"/"+str;

            }
    }
    public String loadFile(String FileName) {

        String content = "";
        if ( file.listFiles().length > 0 ) {
            for (File f : file.listFiles()) {
                String str = FileName;
                Log.v(null, "fileName : " + str);
                String loadPath = dirPath + "/" + str;
                try {
                    FileInputStream fis = new FileInputStream(loadPath);
                    BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fis));

                    String temp = "";
                    while ((temp = bufferReader.readLine()) != null) {
                        content += temp;
                    }
                    Log.v(null, "" + content.toString());


                } catch (Exception e) {

                }

            }
        } else {

        }
        return content;
    }

    public void saveFile(String FileName, String str) {
        // 일치하는 폴더가 없으면 생성
        if( !file.exists() ) {
            file.mkdirs();
        }

        // rio 파일 생성
        String testStr = str;

        File savefile = new File(dirPath+"/"+FileName);
        try{
            FileOutputStream fos = new FileOutputStream(savefile);
            fos.write(testStr.getBytes());
            fos.close();
        } catch(IOException e){}
    }


}
