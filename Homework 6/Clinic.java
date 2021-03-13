import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class Clinic extends InvalidPetException {
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
        this(new File(fileName));
    }

    public String nextDay(File f) throws FileNotFoundException {
        File fileIn = f;
        String[] tokens = null;
        String[] name = new String[5];
        String[] petType = new String[5];
        double[] petCharac = new double[5];
        String[] time = new String[5];
        int[] timeElapsed = new int[5];
        int index = 0;
        Scanner input = new Scanner(System.in);
        Scanner fileScan = null;
        String result = "";

        try {
            fileScan = new Scanner(fileIn);
            String line = null;
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                tokens = line.split(",");
                name[index] = tokens[0];
                petType[index] = tokens[1];
                petCharac[index] = Double.parseDouble(tokens[2]);
                time[index] = tokens[3];
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
        for (int i = 0; i < 5; i++) {
            System.out.print("Consultation for " + name[i] + " the " + petType[i] + " at " + time[i] + ".\nWhat is the health of " + name[i] + "?\n");
            if (!petType[i].equalsIgnoreCase("Dog") || !petType[i].equalsIgnoreCase("Cat")) {
                //throw new InvalidPetException();
            }

            double[] health = new double[5];
            int[] painLevel = new int[5];

            while (true) {
                System.out.print("Input this Pet's health: ");
                try {
                    health[i] = Double.parseDouble(input.next());
                    break;
                } catch (NumberFormatException ignore) {
                    System.out.println("Invalid input");
                }
            }
            while (true) {
                System.out.print("Input this Pet's pain level: ");
                try {
                    painLevel[i] = Integer.parseInt(input.next());
                    break;
                } catch (NumberFormatException ignore) {
                    System.out.println("Invalid input");
                }
            }
            if (petType[i].equalsIgnoreCase("Cat")) {
                Cat animal = new Cat(name[i], health[i], painLevel[i]);
                animal.speak();
                timeElapsed[i] = animal.treat();
            }
            if (petType[i].equalsIgnoreCase("Dog")) {
                Dog animal = new Dog(name[i], health[i], painLevel[i]);
                animal.speak();
                timeElapsed[i] = animal.treat();
            }
            
            result = result + name[i] + "," + petType[i] + "," + petCharac[i] + "," + day + "," + time[i] + "," + this.addTime(time[i], timeElapsed[i]) + "," + health[i] + "," + painLevel[i] + "\n";
        }
        System.out.println(result);
        day++;
        return result;
    }

    public String nextDay(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        return nextDay(file);
    }


    boolean addToFile(String patientInfo) {
        int counter = 0;
        String column = patientInfo;
        String[] columnArray = patientInfo.split(",");
        String[] columnTest = patientInfo.split("\\n");
        String name = columnArray[0];
        String petType = columnArray[1];
        String petCharac = columnArray[2];
        String day = columnArray[3];
        String timeIn = columnArray[4];
        String timeOut = columnArray[5];
        String health = columnArray[6];
        String painLevel = columnArray[7];
        
        File fileIn = new File("Patients 2.csv");
        File fileOut = new File("Patients.csv");
        
        Scanner fileScan = null;
        PrintWriter filePrint = null;
        String[] tokens = null;

        try {
            fileScan = new Scanner(fileIn);
            String doc = "";
            while(fileScan.hasNext()) {
                String line = fileScan.nextLine();
                doc += line + "\n";
                tokens = line.split(",");
                if (name == tokens[0]) {
                    doc = doc + line + "," + day + "," + timeIn + "," + timeOut + "," + health + "," + painLevel;
                }
            }
            filePrint = new PrintWriter(fileIn);
            filePrint.println(doc + columnTest[0]);
            /*
            System.out.println("Chego aqui? > " + columnTest[0]);
            while (fileScan.hasNextLine()) {
                System.out.println("Chego aqui? Antes do line = fileScan.nextLin()");
                line = fileScan.nextLine();
                filePrint.println(line);
                System.out.println("Chego aqui? Antes dos splits dos tokens");
                filePrint.println("Chego aqui? Dentro do documento");
                tokens = line.split(",");
                if (name == tokens[0]) {
                    filePrint.println(doc + line + "," + day + "," + timeIn + "," + timeOut + "," + health + "," + painLevel);
                    return true;
                } else {
                    doc = doc + name + "," + petType + "," + petCharac + "," + day + "," + timeIn + "," + timeOut + "," + health + "," + painLevel + "\n";
                    filePrint.println(doc);
                }
                System.out.println(doc);
            }
                filePrint.println(doc + columnTest[0]);
                /*
                tokens = line.split(",");
                if (tokens[0] == column[0]) {
                    counter++;
                }
            }
            if (counter > 0) {
                tokens[8] = column[3];
                tokens[9] = column[4];
                tokens[10] = column[5];
                tokens[11] = column[6];
                tokens[12] = column[7];
                for (String value : tokens) {
                    filePrint.print(value + ",");
                }
                filePrint.println();
            } else {
                tokens = column;
                for (String value : tokens) {
                    filePrint.print(value + ",");
                }
                filePrint.println();
            }
            //filePrint.println(tokens);
            */
            return true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (filePrint != null) {
                filePrint.close();
            }
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }

    private String addTime(String timeIn, int treatmentTime) {
        int timeOut;
        int time = Integer.parseInt(timeIn);
        int units = time % 100;
        int hundreds = time - units;

        int upperMinutes = units + treatmentTime;
        int hundredsTreatment = 0;

        while (upperMinutes > 60) {
            hundredsTreatment++;
            upperMinutes -= 60;
        }

        timeOut = hundreds + hundredsTreatment + upperMinutes;
        if (timeOut < 1000) {
            return "0" + timeOut + "";    
        } else {
        return "" + timeOut + "";
        }
    }
}
