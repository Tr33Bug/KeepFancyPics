package bilderEntscheider;

import java.awt.geom.GeneralPath;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OrdnerInhaltAusgeben {
    OrdnerInhaltAusgeben() {

    }

    public static void main(String[] args) {

        String sourceFile[];

        // Test trash and toKeep at:    1. /home/henrik/Bilder/ProgrammTest/BilderOrdnerEins/
        //                              2. /home/henrik/Bilder/ProgrammTest/BilderOrdnerZwei/
        // Test source at:              3. /home/henrik/Bilder/ProgrammTest/Source/

        String path = JOptionPane.showInputDialog(null,
                "Select the Working-Path! Example: /home/USER/Pictures/myPictures/");

        // @TODO es müssen noch Sicherungen gemacht werden, dass das wirklich ein Pfad
        // ist! ↴↴↴↴↴
        /*
         * while (path.substring(path.length()-1) != "/") { path =
         * JOptionPane.showInputDialog(null,
         * "It should be a Folder, please dont forget the '/' at the end: Example: /home/USER/Pictures/myPictures/"
         * ); }
         */

        // generate working Folders
        File trash = generateDir(path, "Trash");
        File toKeep = generateDir(path, "toKeep");

        String sourcePath = JOptionPane.showInputDialog(null,
                "Select the Source-Path! Example: /home/USER/Pictures/myPictures/source/");

        File source = new File(sourcePath);

        // list files from source
        sourceFile = whatsInside(source);
        sourceFile = onlyJPG(sourceFile);
        


    }

    /**
     * Method creates a Folder at the path + name directory.
     * 
     * @param path
     * @param name
     * @return
     */
    private static File generateDir(String path, String name) {
        File x = new File(path + name);
        x.mkdir();

        System.out.printf("Dir at %s generated! \n", x.getPath());
        return x;

    }

    /**
     * Method returns a List with the index of the given File-Object.
     * 
     * @param file
     * @return
     */
    private static String[] whatsInside(File file) {
        String dateinamen[] = file.list();

        for (String name : dateinamen) {
            System.out.println(name + "\n");
        }

        return dateinamen;
    }

    /**
     * Method to get only the *.jpg-Files in the Array. 
     * @param listOfIndex
     * @return
     */
    private static String[] onlyJPG(String[] listOfIndex) {
        int newPlace = 0;
        String[] sortList = new String[listOfIndex.length - 1];
        for (int i = 0; i < listOfIndex.length; i++) {

            if (listOfIndex[i].contains(".jpg")) {
                sortList[newPlace] = listOfIndex[i];
                System.out.println("Jippie!!! : ");
                System.out.println();
                System.out.println(listOfIndex[i]);
            } else {
                System.out.println("Das sollte jetzt keine JPG datei sein... : " + listOfIndex[i]);
            }

        }

        return listOfIndex;
    }

}
