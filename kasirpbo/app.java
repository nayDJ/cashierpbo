import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Membuat instance Cashier untuk mengelola transaksi.
        Cashier cashier = new Cashier();
        Scanner scanner = new Scanner(System.in); // Membuat scanner untuk input pengguna.

        while (true) {
            // Menampilkan menu pilihan kepada pengguna.
            System.out.println("----------------------------------");
            System.out.println("|\tProgram Transaksi Kasir\t\t |");
            System.out.println("----------------------------------");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Hapus Barang");
            System.out.println("3. Tampilkan Total & Bayar");
            System.out.println("4. Keluar");
            System.out.println("----------------------------------");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt(); // Membaca pilihan pengguna.

            switch (choice) {
                case 1:
                    // Menambah barang ke dalam daftar belanja.
                    System.out.println("----------------------------------");
                    System.out.print("Masukkan kode barang: ");
                    String addCode = scanner.next(); // Membaca kode barang.
                    System.out.print("Masukkan nama barang: ");
                    String addName = scanner.next(); // Membaca nama barang.
                    System.out.print("Masukkan harga barang: ");
                    int addPrice = scanner.nextInt(); // Membaca harga barang sebagai int.
                    System.out.print("Masukkan jumlah barang: ");
                    int addQty = scanner.nextInt(); // Membaca jumlah barang.
                    cashier.addItem(addPrice, addCode, addName, addQty); // Menambahkan barang melalui metode addItem().
                    break;

                case 2:
                    // Menghapus barang dari daftar belanja berdasarkan kode barang.
                    if (cashier.isEmpty()) {
                        System.out.println("Daftar barang kosong. Tambahkan barang terlebih dahulu.");
                    } else {
                        System.out.print("Masukkan kode barang yang akan dihapus: ");
                        String removeCode = scanner.next(); // Membaca kode barang yang akan dihapus.
                        cashier.removeItem(removeCode); // Menghapus barang melalui metode removeItem().
                    }
                    break;

                case 3:
                    // Menampilkan total belanja dan meminta pembayaran.
                    if (cashier.isEmpty()) {
                        System.out.println("Daftar barang kosong. Tambahkan barang terlebih dahulu.");
                    } else {
                        System.out.println("----------------------------------");
                        cashier.displayTotal(); // Menampilkan daftar barang dan total harga.

                        // Setelah menampilkan total, langsung meminta jumlah pembayaran.
                        System.out.print("Masukkan jumlah pembayaran: ");
                        int payment = scanner.nextInt(); // Membaca jumlah uang yang dibayarkan pengguna sebagai int.
                        cashier.processPayment(payment); // Menghitung kembalian melalui metode processPayment().
                    }
                    break;

                case 4:
                    // Mengakhiri program.
                    System.out.println("Terima kasih telah menggunakan sistem kasir kami!");
                    return; // Menghentikan program.

                default:
                    // Menangani input yang tidak valid.
                    System.out.println("Opsi tidak valid.");
            }
        }
    }
}

