/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import static Manager.Validation.getString;
import java.io.File;

/**
 *
 * @author Windows
 */
public class Analyze {
     public void checkInputPath() {
        System.out.print("Please input Path: ");
        String path = getString("Please input a valid path!!");
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            System.out.println("Disk: " + getDisk(path));
            System.out.println("Extension: " + getExtension(path));
            System.out.println("File name: " + getFileName(path));
            System.out.println("Path: " + getPath(path));
        } else {
            System.err.println("Path isn't file.");
        }
    }

    public   String getPath(String path) {
        int fromDisk = path.indexOf("\\");
        int toNameFile = path.lastIndexOf("\\");
        return path.substring(fromDisk + 1, toNameFile);
    }

    public  String getFileName(String path) {
        int positionFrom = path.lastIndexOf("\\");
        int positionTo = path.lastIndexOf(".");
        return path.substring(positionFrom + 1, positionTo);
    }

    public  String getExtension(String path) {
        int positionDot = path.lastIndexOf(".");
        return path.substring(positionDot, path.length());
    }

    public  String getDisk(String path) {
        int positionColon = path.indexOf("\\");
        return path.substring(0, positionColon + 1);
    }

    public String getFolder(String path) {
    int positionColon = path.indexOf("\\");
    int positionDot = path.lastIndexOf("\\");
    String folderPath = path.substring(positionColon, positionDot);
    String[] splitFile = folderPath.split("\\\\");
    return splitFile[splitFile.length - 1];
}

    }

