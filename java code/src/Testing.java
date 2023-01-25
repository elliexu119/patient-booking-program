/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultrasound.bookings;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ellix
 */
public class Testing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        FileWriter write = null;
//        try {
//            write = new FileWriter("ultrasound booking.txt", true);
//            //Patient a = new Patient (first.getText(), last.getText(), phone.getText(), dob.getText(), notes.getText());
//            //PrintWriter write = new PrintWriter(file);
//        } catch (Exception e) {
//            File file = new File("ultrasound booking.txt");
//            try {
//                write = new FileWriter(file);
//            } catch (Exception x) {
//            }
//        } finally {
//            Patient a = new Patient("john", "smith", "905-987-0909", "01012000", null, null);
//            try {
//               // a.write(write);
//            } catch (Exception x) {
//            }
//        }

//        String formatted = String.format("%02d", 10);
//        System.out.println(formatted);
File file  = new File ("ultrasound booking.txt"); 
Desktop dt = Desktop.getDesktop();
dt.open(file);

        String[] dates = new String[30];
        DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter month = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter day = DateTimeFormatter.ofPattern("dd");
        LocalDateTime now = LocalDateTime.now();
        int nyear = Integer.parseInt(year.format(now));
        int nmonth = Integer.parseInt(month.format(now));
        int nday = Integer.parseInt(day.format(now));

        for (int i = 0; i < dates.length; i++) {
            dates[i] = String.format("%02d", nday) + String.format("%02d", nmonth) + String.format("%02d", nyear);
            nday++;
            if (nday == 32) {
                switch (nmonth) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        nmonth++;
                        nday = 1;
                }
            } else if (nday == 31) {
                switch (nmonth) {
                    case 3:
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        nmonth++;
                        nday = 1;
                }
            }
            if (nmonth == 2) {
                if (nyear % 4 == 0 && nday == 30) {
                    nmonth++;
                    nday = 1;
                } else if (nyear % 4 != 0 && nday == 29) {
                    nmonth++;
                    nday = 1;
                }
            }
            System.out.println(dates[i]);
        }
        
    }

}
