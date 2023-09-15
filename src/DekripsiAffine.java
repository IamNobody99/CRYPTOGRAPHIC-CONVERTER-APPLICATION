import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DekripsiAffine extends JDialog{
    private JPanel dekripsiAffine;
    private JTextField inputCT;
    private JButton DECRYPTButton;
    private JTextField hasilDecrypt;
    private JComboBox inputKey1;
    private JComboBox inputKey2;

    static String decryptCipher(JTextField str, JComboBox Key1, JComboBox Key2)
    {
        String cipher = str.getText().toUpperCase();
        int key1 = Integer.parseInt(Key1.getSelectedItem().toString());
        int key2 = Integer.parseInt(Key2.getSelectedItem().toString());
        String msg = "";
        int a_inv = 0;
        int flag = 0;

        //Find a^-1 (the multiplicative inverse of a
        //in the group of integers modulo m.)
        for (int i = 0; i < 26; i++)
        {
            flag = (key1 * i) % 26;

            // Check if (a*i)%26 == 1,
            // then i will be the multiplicative inverse of a
            if (flag == 1)
            {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++)
        {
			/*Applying decryption formula a^-1 ( x - b ) mod m
			{here x is cipher[i] and m is 26} and added 'A'
			to bring it in range of ASCII alphabet[ 65-90 | A-Z ] */
            if (cipher.charAt(i) != ' ')
            {
                msg = msg + (char) (((a_inv *
                        ((cipher.charAt(i) + 'A' - key2)) % 26)) + 'A');
            }
            else //else simply append space character
            {
                msg += cipher.charAt(i);
            }
        }

        return msg;
    }

    public DekripsiAffine(JFrame parent){
        super(parent);
        setTitle("MENU DEKRIPSI AFFINE");
        setContentPane(dekripsiAffine);
        setMinimumSize(new Dimension(800,900));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        DECRYPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasilDecrypt.setText(decryptCipher(inputCT,inputKey1,inputKey2));
            }
        });
    }
}
