package guia2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

class Carro {
    String marca;
    String modelo;
    String color;
    int kilometraje;

    public Carro(String marca, String modelo, String color, int kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.kilometraje = kilometraje;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
    public int getKilometraje() { return kilometraje; }
}

public class punto4 extends JFrame {
    private Carro[] carros;
    private JTextArea areaTexto;
    private JButton botonModelo, botonKilometraje;

    public punto4() {
        setTitle("Ordenar Carros");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane);
        
        JPanel panelBotones = new JPanel();
        botonModelo = new JButton("Ordenar por Modelo");
        botonKilometraje = new JButton("Ordenar por Kilometraje");
        panelBotones.add(botonModelo);
        panelBotones.add(botonKilometraje);
        add(panelBotones, "South");
        
        botonModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(carros, Comparator.comparing(Carro::getModelo));
                mostrarCarros();
            }
        });

        botonKilometraje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(carros, Comparator.comparingInt(Carro::getKilometraje));
                mostrarCarros();
            }
        });

        ingresarCarros();
    }

    private void ingresarCarros() {
        String cantidadStr = JOptionPane.showInputDialog(this, "Ingrese la cantidad de carros:");
        int cantidad = Integer.parseInt(cantidadStr);
        carros = new Carro[cantidad];

        for (int i = 0; i < cantidad; i++) {
            String marca = JOptionPane.showInputDialog(this, "Marca del carro " + (i + 1) + ":");
            String modelo = JOptionPane.showInputDialog(this, "Modelo del carro " + (i + 1) + ":");
            String color = JOptionPane.showInputDialog(this, "Color del carro " + (i + 1) + ":");
            String kilometrajeStr = JOptionPane.showInputDialog(this, "Kilometraje del carro " + (i + 1) + ":");
            int kilometraje = Integer.parseInt(kilometrajeStr);

            carros[i] = new Carro(marca, modelo, color, kilometraje);
        }

        mostrarCarros();
    }

    private void mostrarCarros() {
        areaTexto.setText("");
        for (Carro carro : carros) {
            areaTexto.append("Marca: " + carro.getMarca() + ", Modelo: " + carro.getModelo() + ", Color: " + carro.getColor() + ", Kilometraje: " + carro.getKilometraje() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new punto4().setVisible(true);
            }
        });
    }
}