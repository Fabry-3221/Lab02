package guia2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEjercicios {

    public static void main(String[] args) {
        // Crear la ventana (JFrame)
        JFrame frame = new JFrame("Menú de Ejercicios");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Layout absoluto

        // Crear los botones
        JButton btnPunto1 = new JButton("Punto 1");
        JButton btnPunto2 = new JButton("Punto 2");
        JButton btnPunto3 = new JButton("Punto 3");
        JButton btnPunto4 = new JButton("Punto 4");

        // Establecer posición y tamaño de los botones
        btnPunto1.setBounds(50, 30, 200, 30);
        btnPunto2.setBounds(50, 70, 200, 30);
        btnPunto3.setBounds(50, 110, 200, 30);
        btnPunto4.setBounds(50, 150, 200, 30);
        // Añadir los botones a la ventana
        frame.add(btnPunto1);
        frame.add(btnPunto2);
        frame.add(btnPunto3);
        frame.add(btnPunto4);
        // Añadir ActionListener para manejar el clic en cada botón
        btnPunto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la clase Punto1
                punto1 punto1 = new punto1();
                punto1.main(null); // Llamar al método main de la clase Punto1
            }
        });

        btnPunto2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la clase Punto2
                punto2 punto2 = new punto2();
                punto2.main(null); // Llamar al método main de la clase Punto2
            }
        });

        btnPunto3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la clase Punto3
                punto3 punto3 = new punto3();
                punto3.main(null); // Llamar al método main de la clase Punto3
            }
        });
 btnPunto4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar a la clase Punto3
                punto4 punto4 = new punto4();
                punto4.main(null); // Llamar al método main de la clase Punto3
            }
        });
        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
