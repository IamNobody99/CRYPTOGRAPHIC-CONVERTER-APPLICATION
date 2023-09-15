import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JDialog{
    private JButton CANCELButton;
    private JButton NEXTButton;
    private JPanel MenuPanel;
    private JComboBox namaAlgo;
    private JComboBox status;

    public MenuPage(JFrame parent){
        super(parent); // untuk mengakses parent class
        setTitle("MENU");
        setContentPane(MenuPanel); //Untuk membuat konten pada panel
        setMinimumSize(new Dimension(900,950)); //untuk mengatur batas ukuran minimum pada frame
        setLocationRelativeTo(parent); // untuk membuat frame nya berada di tengah
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        NEXTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(status.getSelectedItem().toString().equalsIgnoreCase("Enkripsi")
                && namaAlgo.getSelectedItem().toString().equalsIgnoreCase("Caesar")) {
                    new EnkripsiCaesar(null);
                }
                if(status.getSelectedItem().toString().equalsIgnoreCase("Enkripsi")
                        &&namaAlgo.getSelectedItem().toString().equalsIgnoreCase("Vigenere")){
                    new EnkripsiVigenere(null);
                }
                if(status.getSelectedItem().toString().equalsIgnoreCase("Enkripsi")
                        &&namaAlgo.getSelectedItem().toString().equalsIgnoreCase("Affine Chiper"))
                {
                    new EnkripsiAffine(null);
                }
                if(status.getSelectedItem().toString().equalsIgnoreCase("Dekripsi")
                && namaAlgo.getSelectedItem().toString().equalsIgnoreCase("Caesar")){
                    new DekripsiCaesar(null);
                }
                if(status.getSelectedItem().toString().equalsIgnoreCase("Dekripsi")
                        && namaAlgo.getSelectedItem().toString().equalsIgnoreCase("Vigenere")){
                    new DekripsiVigenere(null);
                }
                if(status.getSelectedItem().toString().equalsIgnoreCase("Dekripsi")
                        && namaAlgo.getSelectedItem().toString().equalsIgnoreCase("Affine Chiper")){
                    new DekripsiAffine(null);
                }
            }
        });
        CANCELButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPage(null);
    }
}
