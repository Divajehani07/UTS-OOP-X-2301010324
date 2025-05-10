package aplikasimanajemendatamahasiswa;

import java.util.Scanner;

class Mahasiswa {
    private String nim;
    private String nama;
    private String jurusan;

    public Mahasiswa() {
        this.nim = "";
        this.nama = "";
        this.jurusan = "";
    }

    public Mahasiswa(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public String getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void display() {
        System.out.println("NIM     : " + nim);
        System.out.println("Nama    : " + nama);
        System.out.println("Jurusan : " + jurusan);
    }
}

public class AplikasiManajemenDataMahasiswa {
    static Scanner scanner = new Scanner(System.in);
    static Mahasiswa[] daftar = new Mahasiswa[100];
    static int jumlah = 0;

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== MENU MANAJEMEN MAHASISWA ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Lihat Mahasiswa");
            System.out.println("3. Ubah Data Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
    case 1:
        tambahMahasiswa();
        break;
    case 2:
        lihatMahasiswa();
        break;
    case 3:
        ubahMahasiswa();
        break;
    case 4:
        hapusMahasiswa();
        break;
    case 5:
        System.out.println("Program selesai.");
        break;
    default:
        System.out.println("Pilihan tidak valid.");
}

        
        } while (pilihan != 5);
    }

    public static void tambahMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = scanner.nextLine();

        daftar[jumlah] = new Mahasiswa(nim, nama, jurusan);
        jumlah++;
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    public static void lihatMahasiswa() {
        if (jumlah == 0) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            daftar[i].display();
        }
    }

    public static void ubahMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin diubah: ");
        String nimCari = scanner.nextLine();

        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNim().equals(nimCari)) {
                System.out.print("Nama baru: ");
                String namaBaru = scanner.nextLine();
                System.out.print("Jurusan baru: ");
                String jurusanBaru = scanner.nextLine();

                daftar[i].setNama(namaBaru);
                daftar[i].setJurusan(jurusanBaru);
                System.out.println("Data mahasiswa berhasil diubah.");
                return;
            }
        }
        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
    }

    public static void hapusMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nimCari = scanner.nextLine();

        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNim().equals(nimCari)) {
                for (int j = i; j < jumlah - 1; j++) {
                    daftar[j] = daftar[j + 1];
                }
                daftar[jumlah - 1] = null;
                jumlah--;
            }
        }
    }
}
        