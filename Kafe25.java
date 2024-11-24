import java.util.Scanner;

public class Kafe25 {
    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }
        
        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga(int pilihanMenu, int banyakItem, String kodePromo) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        if (kodePromo.equals("DISKON50")) {
            hargaTotal = hargaTotal / 2; 
            System.out.println("Selamat, Anda mendapatkan diskon 50%!");
        } else if (kodePromo.equals("DISKON30")) {
            hargaTotal = hargaTotal - (hargaTotal * 30 / 100); 
            System.out.println("Selamat, Anda mendapatkan diskon 30%!");
        } else {
            System.out.println("Kode promo invalid.");
        }

        return hargaTotal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // untuk tampilan menu
        Menu("Andi", true);

        int totalPesanan = 0;
        boolean lanjut = true;

        System.out.print("Masukkan kode promo (jika tidak ada, ketik 'NONE'): ");
        String kodePromo = sc.next();

        while (lanjut) {
        // Input pilihan menu
        System.out.print("Masukkan nomor menu yang ingin Anda pesan: ");
        int pilihanMenu = sc.nextInt();

        if (pilihanMenu < 1 || pilihanMenu > 6) {
            System.out.println("Menu tidak valid, silakan pilih ulang!");
            continue;
        }

        // Input jumlah pesanan
        System.out.print("Masukkan jumlah item yang ingin dipesan: ");
        int banyakItem = sc.nextInt();

        
        // Hitung total harga
        int totalHarga = hitungTotalHarga(pilihanMenu, banyakItem, kodePromo);
        totalPesanan += totalHarga;

        // untuk menanyakan apa ingin memesan lagi?
        System.out.print("Apakah anda ingin memesan lagi? (y/n): ");
        String jawaban = sc.next();
        if (!jawaban.equalsIgnoreCase("y")) {
            lanjut = false;
        }
    }

    //total keseluruhan 
    System.out.println("\n===== STRUK PESANAN =====");
    System.out.println("Total keseluruhan pesanan anda: Rp " + totalPesanan);
    System.out.println("==========================");
    
    }
}


