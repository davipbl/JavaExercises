import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class Clinic {
    private File patientFile;
    private int day;

    public Clinic(File file) {
        this.patientFile = file;
        String name;
        String petType;
        int timeIn;
        int timeOut;
        double health;
        int painLevel;
        int day = 1; 
    }

    public Clinic(String fileName) {
        File file = (fileName+".csv");
        Clinic(file);
    }

    public String nextDay(File f) throws FileNotFoundException {
        File fileIn = new File(f);
        String[] tokens = null;
        String[] name = new String[5];
        String[] petType = new String[5];
        double[] petCharac = new double[5];
        int[] time = new int[5];
        int index = 0;
        Scanner input = new Scanner(System.in);
        Scanner lineRead = null;

        try {
            Scanner fileScan = new Scanner(fileIn);
            String line = null;
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                tokens = line.split(",");
                name[index] = String.parseString(tokens[0]);
                petType[index] = String.parseString(tokens[1]);
                petCharc[index] = Double.parseDouble(tokens[2]);
                time[index] = Int.parseInt(tokens[3]);
                index++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }

        
    }
    
    public static void main(String[] args) {
        String inputFileName = args[0];

        File fileIn = new File(inputFileName);

        Scanner fileScan = null;

        String[] tokens = null;
        String[] name = new String[5];
        String[] type = new String[5];


        try {
            fileScan = new Scanner(fileIn);
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                tokens = line.split(",");
                
            }
        }
    }
}
