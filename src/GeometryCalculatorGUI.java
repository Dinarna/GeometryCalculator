import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Kelas GeometryCalculatorGUI menyediakan antarmuka grafis untuk menghitung
 * luas dan keliling dari berbagai bangun datar seperti persegi, persegi panjang, dan lingkaran.
 * <p>
 * Pengguna dapat memilih jenis bangun datar dan perhitungan yang diinginkan, 
 * lalu memasukkan nilai input untuk melakukan kalkulasi.
 */
public class GeometryCalculatorGUI extends JFrame implements ActionListener {

    // Field input untuk nilai sisi, jari-jari, panjang, atau lebar
    private JTextField inputField1, inputField2, resultField;

    // Dropdown untuk memilih bentuk bangun datar dan jenis perhitungan
    private JComboBox<String> shapeSelector, calculationType;

    // Tombol untuk menjalankan kalkulasi
    private JButton calculateButton;

    /**
     * Konstruktor untuk menginisialisasi GUI dan komponennya.
     * Menambahkan semua elemen dan mengatur layout dasar.
     */
    public GeometryCalculatorGUI() {
        setTitle("Geometry Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Pilih Bangun Datar (misalnya: Persegi, Persegi Panjang, Lingkaran)
        shapeSelector = new JComboBox<>(new String[]{"Persegi", "Persegi Panjang", "Lingkaran"});
        shapeSelector.addActionListener(this);
        add(new JLabel("Pilih Bangun Datar:"));
        add(shapeSelector);

        // Jenis Perhitungan (Luas atau Keliling)
        calculationType = new JComboBox<>(new String[]{"Luas", "Keliling"});
        add(new JLabel("Pilih Jenis Perhitungan:"));
        add(calculationType);

        // Input untuk nilai-nilai yang dibutuhkan dalam perhitungan
        inputField1 = new JTextField();
        inputField2 = new JTextField();
        add(new JLabel("Input 1 (Sisi / Jari-jari / Panjang):"));
        add(inputField1);
        add(new JLabel("Input 2 (Lebar, jika diperlukan):"));
        add(inputField2);

        // Tombol untuk memulai kalkulasi
        calculateButton = new JButton("Hitung");
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Output hasil perhitungan
        resultField = new JTextField();
        resultField.setEditable(false);
        add(new JLabel("Hasil:"));
        add(resultField);

        setVisible(true);
        updateInputFields(); // Mengatur enable/disable inputField2 sesuai bangun datar
    }

    /**
     * Mengaktifkan atau menonaktifkan inputField2 berdasarkan bentuk yang dipilih.
     * Memastikan inputField2 hanya aktif saat diperlukan (untuk persegi panjang).
     */
    private void updateInputFields() {
        String shape = (String) shapeSelector.getSelectedItem();
        if ("Persegi".equals(shape) || "Lingkaran".equals(shape)) {
            inputField2.setEnabled(false); // Tidak perlu input kedua untuk persegi/lingkaran
            inputField2.setText("");
        } else {
            inputField2.setEnabled(true);
        }
    }

    /**
     * Mengatur logika perhitungan berdasarkan pilihan pengguna dan menghitung
     * luas atau keliling sesuai bangun datar yang dipilih.
     * @param e ActionEvent dari komponen GUI
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shapeSelector) {
            updateInputFields();
            return;
        }

        try {
            // Membaca bentuk dan jenis perhitungan dari dropdown
            String shape = (String) shapeSelector.getSelectedItem();
            String calculation = (String) calculationType.getSelectedItem();
            
            // Mengonversi input user ke tipe double
            double value1 = Double.parseDouble(inputField1.getText());
            double value2 = inputField2.isEnabled() ? Double.parseDouble(inputField2.getText()) : 0;
            double result = 0; // Menyimpan hasil perhitungan

            // Memproses perhitungan berdasarkan bentuk dan jenis yang dipilih
            switch (shape) {
                case "Persegi":
                    result = "Luas".equals(calculation) ? value1 * value1 : 4 * value1;
                    break;
                case "Persegi Panjang":
                    result = "Luas".equals(calculation) ? value1 * value2 : 2 * (value1 + value2);
                    break;
                case "Lingkaran":
                    result = "Luas".equals(calculation) ? Math.PI * value1 * value1 : 2 * Math.PI * value1;
                    break;
            }

            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            // Menampilkan pesan kesalahan jika input tidak valid
            JOptionPane.showMessageDialog(this, "Input tidak valid, masukkan angka yang benar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Memulai aplikasi GUI untuk kalkulator bangun datar.
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GeometryCalculatorGUI());
    }
}
