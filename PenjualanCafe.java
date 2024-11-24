import java.util.Scanner;

public class PenjualanCafe {

    static String[] menu = {"Kopi", "Teh", "Es Degan", "Roti Bakar", "Gorengan"};
    static int[][] penjualan;

    // Fungsi untuk menampilkan seluruh data penjualan
    static void tampilkanSemuaPenjualan() {
        System.out.println("Data Penjualan Setiap Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i] + ": ");
            for (int j = 0; j < penjualan[i].length; j++) {
                System.out.print(penjualan[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Fungsi untuk menampilkan menu yang memiliki penjualan tertinggi
    static void menuPenjualanTertinggi() {
        int totalTertinggi = 0;
        String menuTertinggi = "";

        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;

            for (int j = 0; j < penjualan[i].length; j++) {
                totalPenjualan += penjualan[i][j];
            }
            if (totalPenjualan > totalTertinggi) {
                totalTertinggi = totalPenjualan;
                menuTertinggi = menu[i];
            }
        }

        System.out.println("Menu dengan penjualan tertinggi: " + menuTertinggi);
        System.out.println("Total penjualan: " + totalTertinggi);
    }

    // Fungsi untuk menampilkan rata-rata penjualan untuk setiap menu
    static void rataRataPenjualan() {
        System.out.println("Rata-rata Penjualan Setiap Menu:");
        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;

            for (int j = 0; j < penjualan[i].length; j++) {
                totalPenjualan += penjualan[i][j];
            }

            double rataRata = (double) totalPenjualan / penjualan[i].length;
            System.out.printf("%s: %.2f%n", menu[i], rataRata);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input jumlah mahasiswa
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = input.nextInt();

        // Input jumlah tugas
        System.out.print("Masukkan jumlah tugas: ");
        int jumlahTugas = input.nextInt();

        // Inisialisasi array penjualan dengan ukuran sesuai input
        penjualan = new int[menu.length][jumlahTugas];

        // Input penjualan per tugas
        for (int i = 0; i < menu.length; i++) {
            System.out.println("Masukkan data penjualan untuk menu " + menu[i] + ":");
            for (int j = 0; j < jumlahTugas; j++) {
                System.out.print("Tugas " + (j + 1) + ": ");
                penjualan[i][j] = input.nextInt();
            }
        }

        int pilihan;
        do {
            System.out.println("\n=== Program Penjualan Cafe ===");
            System.out.println("1. Lihat semua data penjualan");
            System.out.println("2. Menu dengan penjualan tertinggi");
            System.out.println("3. Rata-rata penjualan setiap menu");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            // Validasi input agar hanya angka yang diterima
            while (!input.hasNextInt()) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                input.next(); // Clear the invalid input
                System.out.print("Pilih menu: ");
            }

            pilihan = input.nextInt();

            // Menambahkan penanganan untuk pilihan diluar rentang
            if (pilihan == 1) {
                tampilkanSemuaPenjualan();
            } else if (pilihan == 2) {
                menuPenjualanTertinggi();
            } else if (pilihan == 3) {
                rataRataPenjualan();
            } else if (pilihan == 4) {
                System.out.println("Terima kasih!");
            } else {
                System.out.println("Pilihan anda tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        input.close();
    }
}
