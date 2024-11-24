public class Kubus25 {

    //membuat fungsi untuk menghitung vol kubus
    public static int hitungVolume(int sisi) {
        return sisi * sisi * sisi;
    }

    //membuat fungsi unutk menghitung l.perm kubus
    public static int hitungLuasPermukaan(int sisi) {
        return 6* sisi* sisi;
    }

    public static void main(String[] args) {
        int sisi = 8;

        int volume = hitungVolume(sisi);
        int luasPermukaan = hitungLuasPermukaan(sisi);

        System.out.println("Volume kubus dengan sisi " + sisi + " adalah: " + volume);
        System.out.println("Luas permukaa kubus dengan sisi " + sisi + " adalah: " + luasPermukaan);
    }   
}
