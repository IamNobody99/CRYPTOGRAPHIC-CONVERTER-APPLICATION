import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnkripsiAffine extends JDialog{
    private JPanel enkripsiAffine;
    private JTextField inputPT;
    private JButton ENCRYPTButton;
    private JTextField hasilEncrypt;
    private JComboBox inputKey1;
    private JComboBox inputKey2;

    static String encryptMessage(JTextField PlainText, JComboBox Key1, JComboBox Key2)
    {
        /// Cipher Text initially empty
        String msg = PlainText.getText().toUpperCase();
        int key1 = Integer.parseInt(Key1.getSelectedItem().toString());
        int key2 = Integer.parseInt(Key2.getSelectedItem().toString());

        String cipher = "";
        for (int i = 0; i < msg.length(); i++)
        {
            // Avoid space to be encrypted
			/* applying encryption formula ( a x + b ) mod m
			{here x is msg[i] and m is 26} and added 'A' to
			bring it in range of ascii alphabet[ 65-90 | A-Z ] */
            if (msg.charAt(i) != ' ')
            {
                cipher = cipher
                        + (char) ((((key1 * (msg.charAt(i) - 'A')) + key2) % 26) + 'A');
            } else // else simply append space character
            {
                cipher += msg.charAt(i);
            }
        }
        return cipher;
    }

    public EnkripsiAffine(JFrame parent){
        super(parent);
        setTitle("MENU ENKRIPSI AFFINE ");
        setContentPane(enkripsiAffine);
        setMinimumSize(new Dimension(700,900));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        ENCRYPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasilEncrypt.setText(encryptMessage(inputPT,inputKey1,inputKey2));
            }
        });
    }
}
