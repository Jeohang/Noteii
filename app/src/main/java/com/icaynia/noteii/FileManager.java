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
        if( !file.exists() ) {
            file.mkdirs();
        }
        String content = "";
        if ( file.listFiles() != null ) {
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
            Log.v(null, "wwww");
            return "" +
                    "간단한 메모장. Noteii\n" +
                    "\n" +
                    "0. Noteii는 기능이라고는 쓰기 저장 밖에 없는 메모장입니다.\n" +
                    "1. 상단 오른쪽 메뉴의 Save를 눌러 저장시킬 수 있습니다.\n" +
                    "2. 또는 어플리케이션을 정상적인 방법으로 종료하셔도 자동 저장 됩니다.\n" +
                    "3. 저장되는 경우 \"Saved\" 메시지가 송출되며 어플리케이션 종료 후 다시 불러오실 수 있습니다.\n" +
                    "4. 문서의 제목은 맨 첫줄의 텍스트로 적용되며 현재는 텍스트를 변경하고 어플 재시작 시 변경이 됩니다.\n\n\n\n\n";
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
