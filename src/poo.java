import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class poo extends JFrame implements ActionListener {

    public poo() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setLayout(null);

        JLabel etiquetaDeVector = new JLabel();
        etiquetaDeVector.setText("Ingrese los 6 elementos del vector separado por ',' :");
        etiquetaDeVector.setBounds(10, 10, 300, 20);
        this.add(etiquetaDeVector);

        jtfVector = new JTextField();
        jtfVector.setBounds(320, 10, 200, 20);
        this.add(jtfVector);

        JButton jbtnModificarVector = new JButton();
        jbtnModificarVector.setBounds(150, 40, 300, 30);
        jbtnModificarVector.setText("Invertir");
        jbtnModificarVector.addActionListener(this);
        this.add(jbtnModificarVector);

        jlResultado = new JLabel();
        jlResultado.setBounds(10, 80, 300, 30);
        jlResultado.setText("Resultado : ");
        this.add(jlResultado);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            jlResultado.setText("");
            String[] valoresDeVector = jtfVector.getText().split(",");
            if (valoresDeVector.length != 6){
                System.err.println("Tienen que ser 6 valores");
                JOptionPane.showMessageDialog(null, "Tienen que ser 6 valores", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Vector<String> vector = new Vector<String>();
            Collections.addAll(vector, valoresDeVector);
            Collections.reverse(vector);
            jlResultado.setText("Resultado : " + vector.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Parece que hubo un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) throws Exception {
        JOptionPane.showInputDialog(null,"Ingrese los 6 elementos del vector separado por ',' :");
        new poo().setVisible(true);
    }

    private JTextField jtfVector;
    private JLabel jlResultado;
}
