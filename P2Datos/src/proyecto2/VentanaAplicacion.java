/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import graphs.Graph;
import graphs.view.GraphPanel;
import graphs.view.Modelo;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Carlos
 */
public class VentanaAplicacion extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     *
     * @param titulo
     * @param modelo
     * @param g
     */
    public VentanaAplicacion(String titulo, Modelo modelo, Graph<Integer, Integer> g)
            throws HeadlessException {
        super(titulo);
        this.modelo = modelo;
        this.g = g;
        configurar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        puntoPartidaLabel = new javax.swing.JLabel();
        puntoPartidaTxt = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 8), new java.awt.Dimension(32767, 16));
        puntoDestinoLabel = new javax.swing.JLabel();
        puntoDestinoTxt = new javax.swing.JTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 16), new java.awt.Dimension(32767, 16));
        calcularBtn = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 16), new java.awt.Dimension(32767, 16));
        play_chkbox = new javax.swing.JCheckBox();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelMapa = new GraphPanel(modelo, g);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(125, 189));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(160, 300));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        puntoPartidaLabel.setText("Punto de Partida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(puntoPartidaLabel, gridBagConstraints);

        puntoPartidaTxt.setPreferredSize(new java.awt.Dimension(50, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(puntoPartidaTxt, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel1.add(filler1, gridBagConstraints);

        puntoDestinoLabel.setText("Punto de Destino");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(puntoDestinoLabel, gridBagConstraints);

        puntoDestinoTxt.setPreferredSize(new java.awt.Dimension(50, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(puntoDestinoTxt, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        jPanel1.add(filler2, gridBagConstraints);

        calcularBtn.setText("Calcular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(calcularBtn, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel1.add(filler4, gridBagConstraints);

        play_chkbox.setText("Play");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        jPanel1.add(play_chkbox, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(filler3, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout PanelMapaLayout = new javax.swing.GroupLayout(PanelMapa);
        PanelMapa.setLayout(PanelMapaLayout);
        PanelMapaLayout.setHorizontalGroup(
                PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 740, Short.MAX_VALUE)
        );
        PanelMapaLayout.setVerticalGroup(
                PanelMapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 572, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(PanelMapa);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configurar() {
        ajustarComponentes(getContentPane());
        setResizable(true);
        setSize(800, 600);
        setMinimumSize(new Dimension(640, 480));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                g.setActive(false);
                System.exit(0);
            }
        });
    }

    private void ajustarComponentes(Container contentPane) {
        contentPane.setLayout(new BorderLayout());
        contentPane.add(BorderLayout.CENTER, this.PanelMapa = new GraphPanel(modelo, g));
        this.initComponents();
        this.play_chkbox.addActionListener(
                (ActionEvent evt) -> {
                    cambiarActivo(play_chkbox.isSelected());
                }
        );
        this.calcularBtn.addActionListener((ActionEvent e) -> {
            String rutaInicio = this.puntoPartidaTxt.getText();
            String rutaDestino = this.puntoDestinoTxt.getText();
            if (rutaInicio.equals(rutaDestino)) {
                JOptionPane.showMessageDialog(null,
                        "Ruta inicio debe ser distinto al destino.",
                        "InfoBox: " + "Campos iguales",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (rutaInicio.isEmpty() || rutaDestino.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Por favor coloque toda la informacion correspondiente a inicio y destino.",
                        "InfoBox: " + "Campos vacios",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (!isNumeric(rutaInicio) || !isNumeric(rutaDestino)) {
                JOptionPane.showMessageDialog(null,
                        "Por favor coloque solo numeros en la informacion solicitada.",
                        "InfoBox: " + "Formato Incorrecto",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                g.iniciar(this.puntoPartidaTxt.getText(), this.puntoDestinoTxt.getText());
            }
            //g.agregarMarcador(this.puntoPartidaTxt.getText(), this.puntoDestinoTxt.getText());
        });
    }

    public void init() {
        setVisible(true);
        GraphPanel f = (GraphPanel) PanelMapa;
        f.init();
        f.setPadre(this);
        g.init();
        play_chkbox.setSelected(g.isActive());
    }

    public void setValorInicioField(String valor) {
        this.puntoPartidaTxt.setText(valor);
    }

    public void setValorDestinoField(String valueOf) {
        this.puntoDestinoTxt.setText(valueOf);
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMapa;
    private javax.swing.JButton calcularBtn;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox play_chkbox;
    private javax.swing.JLabel puntoDestinoLabel;
    private javax.swing.JTextField puntoDestinoTxt;
    private javax.swing.JLabel puntoPartidaLabel;
    private javax.swing.JTextField puntoPartidaTxt;
    // End of variables declaration//GEN-END:variables
    private final Modelo modelo;
    private final Graph<Integer, Integer> g;

    public void cambiarActivo(boolean estado) {
        g.setActive(estado);
    }

}
