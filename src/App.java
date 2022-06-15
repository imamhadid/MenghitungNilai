import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

// Overloading Class = Overloading Operation
class Pengantar {
    String cekDosen(String dosen) {
        return "Terima kasih untuk Ibu/Bapak " + dosen;
    }
}

class Ucapan extends Pengantar {
    String cekInfo(String linkGithub) {
        return ", selanjutnya anda akan dibawa menujuh halaman GitHub pengembang aplikasi ini." + linkGithub;
    }
}

public class App {

    // Explicit pointer manipulation
    public static void main(String[] args) throws InterruptedException {

        // Improper Casting
        try (Scanner save = new Scanner(System.in)) {

            int choose, presence;
            String name = "", nim = "", message = "", namaDosen = "";
            char IPK;
            float nduty, midtermExam, finalExams, totvalue, attendance, realization;

            System.out.println("Silahkan Masukan Nama Anda : ");
            namaDosen = save.nextLine();

            String load = "|/-\\";
            int percent = 0;
            System.out.print("\033[2J");
            long start = System.currentTimeMillis();
            while (true) {
                for (int gear = 0; gear < 4; gear++) {
                    System.out.print("\033[2J");
                    System.out.print("\033[0;0H");
                    System.out.print("        ");
                    for (int much = 0; much < 5; much++) {
                        System.out.print(load.charAt(gear));
                    }
                    System.out.print("        Mohon Tunggu... ");
                    System.out.print(percent + " %        ");
                    percent = percent + 5;
                    for (int much = 0; much < 5; much++) {
                        System.out.print(load.charAt(gear));
                    }
                    Thread.sleep(250);
                }
                long now = System.currentTimeMillis();
                if (now - start >= 5000)
                    break;
            }
            System.out.print("\033[?25h");
            System.out.print("\033[2J");

            System.out.println("\n=====================================================");
            System.out.println("===== Aplikasi Menghitung Nilai Pemrograman JAVA ======");
            System.out.println("        GitHub: https://github.com/imamhadid");
            System.out.println("      Supprot Me: https://saweria.co/HaditVanh");
            System.out.println("=====================================================\n");

            System.out.println("Masukan Nama Mahasiswa : ");
            name = save.nextLine();
            System.out.println("Masukan NIM Mahasiswa : ");
            nim = save.nextLine();
            System.out.println("Masukan Jumlah Pertemuan : ");
            presence = save.nextInt();
            System.out.println("Input Kehadiran (0 Sampai " + presence + " ) :");
            attendance = save.nextInt();
            if (attendance < 0 || attendance > presence) {
                attendance = 0;
            }
            System.out.println("Masukan Jumlah SKS (2 SKS atau 3 SKS) : ");
            choose = save.nextInt();
            switch (choose) {
                case 2:
                    realization = 14;
                    break;
                case 3:
                    realization = 18;
                    break;
                default:
                    realization = 0;
                    message = " Salah Pilih Realisasi Maka 0, Silakan Ulangi";
            }
            System.out.println("Nilai Tugas : ");
            nduty = save.nextInt();
            System.out.println("Nilai UTS : ");
            midtermExam = save.nextInt();
            System.out.println("Nilai UAS : ");
            finalExams = save.nextInt();
            if (nduty > 100) {
                nduty = 0;
            } else if (midtermExam > 100) {
                midtermExam = 0;
            } else if (finalExams > 100) {
                finalExams = 0;
            }

            // Structures

            // 10% nilai kehadiran
            // 15% tugas
            // 35% uts
            // 40% uas

            totvalue = (attendance / realization * 10 / 100) + (nduty * 15 / 100) + (midtermExam * 35 / 100)
                    + (finalExams * 40 / 100);
            if (totvalue >= 90 && totvalue < 100) {
                IPK = 'A';
            } else if (totvalue >= 80 && totvalue < 90) {
                IPK = 'B';
            } else if (totvalue >= 70 && totvalue < 80) {
                IPK = 'C';
            } else if (totvalue >= 60 && totvalue < 70) {
                IPK = 'D';
            } else {
                IPK = 'E';
            }
            System.out.println("\n ===== RINCIAN HASIL =====\n");
            if (IPK == 'A' || IPK == 'B' || IPK == 'C') {
                System.out.println("Nama : " + name);
                System.out.println("NIM : " + nim);
                System.out.println("Nilai Kehadiran : " + attendance);
                System.out.println("Realisasi : " + realization + message);
                System.out.println("Nilai Tugas : " + nduty);
                System.out.println("Nilai UTS : " + midtermExam);
                System.out.println("Nilai UAS : " + finalExams);
                System.out.println("Total Nilai : " + totvalue + " = IPK: (" + IPK + ") " + "" + "LULUS");
            } else {
                System.out.println("Nama : " + name);
                System.out.println("NIM : " + nim);
                System.out.println("Nilai Kehadiran : " + attendance);
                System.out.println("Realisasi : " + realization + message);
                System.out.println("Nilai Tugas : " + nduty);
                System.out.println("Nilai UTS : " + midtermExam);
                System.out.println("Nilai UAS : " + finalExams);
                System.out.println("Total Nilai : " + totvalue + " = (IPK: " + IPK + ") " + "" + "TIDAK LULUS");
            }
            Ucapan Terimakasih = new Ucapan();
            System.out.print(Terimakasih.cekDosen(namaDosen));
            System.out.println(Terimakasih.cekInfo("https://github.com/imamhadid"));

            try {
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI oURL = new URI("https://github.com/imamhadid");
                desktop.browse(oURL);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
