package utils;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
       String str="usr/projects/winnkvideo/userId/video/tmp_9604221ecada8d39fda965e4a53e8af0a4543f396f620eeb.mp4";
        String tempFile= str.substring(0,str.lastIndexOf('/'))+"/tempFile.mp4";
        System.out.println(tempFile);

    }
}
