/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultrasound.bookings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ellix
 */
public class Patient {

    String first;
    String last;
    String phone;
    String dob;//month, day, year,
    String initial = null;
    String notes;
    String type; 
    String fileName;

    public Patient() {
        first = null;
        last = null;
        phone = null;
        dob = null;
        type = null;
        notes = null;
    }

    public Patient(String fileName, String first, String last, String phone, String dob, String notes, String type, String initials) {
        this.fileName = fileName; 
        setFirst(first);
        setLast(last);
        setPhone(phone);
        setDob(dob);
        setNotes(notes);
        this.type = type; 
        this.initial = initials.trim().toUpperCase();
    }

    private String formatPhone(String phone) {
        String ans = phone.trim();
        if (phone.contains("-")) {
            StringTokenizer token = new StringTokenizer(phone, "-");
            ans = "";
            while (token.hasMoreTokens()) {
                ans = ans + token.nextToken();
            }
        }
        if (phone.trim().contains(" ")) {
            String temp = "";
            StringTokenizer token = new StringTokenizer(ans, " ");
            while (token.hasMoreTokens()) {
                temp = temp + token.nextToken();
            }
            ans = temp;
        }
        System.out.println(ans);
        return (ans.trim());
    }

    public String getFrirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getInitial() {
        return initial;
    }

    public String getDob() {
        return dob;
    }

    public String getPhone() {
        return phone;
    }

    public String getNotes() {
        return notes;
    }

    public void setFirst(String first) {
        try {
            this.first = first.toUpperCase().trim();
        } catch (NullPointerException e) {
            this.first = null;
        }
    }

    public void setLast(String last) {
        try {
            this.last = last.toUpperCase().trim();
        } catch (NullPointerException e) {
            this.last = null;
        }
    }

    public void setPhone(String phone) {
        try {
            this.phone = formatPhone(phone.trim());
        } catch (NullPointerException e) {
            this.phone = null;
        }
    }

    public void setDob(String dob) {
        try {
            this.dob = dob.trim();
        } catch (NullPointerException e) {
            this.dob = null;
        }
    }

    public void setNotes(String notes) {
        try {
            this.notes = notes;
        } catch (NullPointerException e) {
            this.notes = null;
        }
    }

    public void write(FileWriter file, String info) throws Exception {
        try {
            File file2 = new File(fileName);
            Scanner scan = new Scanner(file2);
            int counter = 0;
            while (scan.hasNext()) {
                scan.nextLine();
                counter++;
            }
            //System.out.println(counter);
            scan = new Scanner(file2);
            String array[] = new String[counter];
            //System.out.println("\n\n");
            
            int ind = -1; 
            System.out.println(info);
            for (int i = 0; scan.hasNext(); i++) {
                array[i] = scan.nextLine();
                if (array[i].contains(info)){
                    ind = i; 
                    System.out.println("i " + i);
                }
            }
            
            array[ind] = array[ind].substring(0, array[ind].indexOf("status") + 7) + "b" + array[ind].substring(array[ind].indexOf("status") + 8); 
            array[ind] = (array[ind] + " first name " + first + " last name " + last + " phone number " + phone + " dob " + dob + " type " + type + " notes " + notes + " initial " + initial);
            scan.close();

            //clears file (maybe? don't remember)
            PrintWriter writer = new PrintWriter(file2);
            writer.print("");
            writer.close();

            System.out.println("array length " + array.length);
            for (String array1 : array) {
                file.write(array1 + System.getProperty("line.separator"));
                System.out.println(array1);
            }
            file.close();

        } catch (IOException e) {

        }
//        try {
//            Scanner scan = new Scanner(fileName);
//            String scanL = null;
//            for (int i = 0; i <= ind; i++) {
//                scanL = scan.nextLine();
//            }
//            scan.close();
//
//            BufferedReader buf = new BufferedReader(new FileReader(fileName));
//            String line;
//            StringBuffer inputBuffer = new StringBuffer();
//            while ((line = buf.readLine()) != null) {
//                inputBuffer.append(line);
//                inputBuffer.append('\n');
//            }
//            String inputStr = inputBuffer.toString();
//
//            file.close();
//
//            System.out.println("----------------------------------\n" + inputStr);
//            inputStr = inputStr.replace(scanL, scanL + "first name " + first + " last name " + last + " phone number " + phone + " dob " + dob + " notes " + notes + " initial " + initial + " end ");
//            
//            System.out.println("----------------------------------\n"  + inputStr);
//            
//            FileOutputStream fileOut = new FileOutputStream(fileName);
//            fileOut.write(inputStr.getBytes());
//            fileOut.close();
//
//        } catch (Exception e) {
//
//        }
        //file.write("first name " + first + " last name " + last + " phone number " + phone + " dob " + dob + " notes " + notes + " initial " + initial + " end ");
        //file.close();
    }

}
