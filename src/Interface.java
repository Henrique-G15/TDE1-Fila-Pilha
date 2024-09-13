import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Interface {
    private JFrame frame;
    private JPanel panelPilha, panelFila;
    private JButton btnPush, btnPop, btnEnqueue, btnDequeue;
    private JTextField inputField;
    
    // Estruturas para visualizacao
    private LinkedList<String> pilha;
    private LinkedList<String> fila;

    //Interface
    public Interface() {
        pilha = new LinkedList<>();
        fila = new LinkedList<>();
        frame = new JFrame("Visualizacao de Pilha e Fila");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.getContentPane().setBackground(Color.BLACK); // Fundo da janela preto
        
        // Painel principal
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setOpaque(false); 
        
        panelPilha = new JPanel();
        panelFila = new JPanel();
        panelPilha.setOpaque(false); // Pilha com fundo transparente
        panelFila.setOpaque(false);  // Fila com fundo transparente
        
        // Titulo da pilha e fila
        JLabel tituloPilha = new JLabel("Pilha", SwingConstants.CENTER);
        JLabel tituloFila = new JLabel("Fila", SwingConstants.CENTER);
        tituloPilha.setFont(new Font("Arial", Font.BOLD, 24));
        tituloPilha.setForeground(Color.WHITE); // Titulo com texto branco
        tituloFila.setFont(new Font("Arial", Font.BOLD, 24));
        tituloFila.setForeground(Color.WHITE); // Titulo com texto branco
        
        // Espaçamento
        panelPilha.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Mover o conteúdo da pilha para baixo
        panelFila.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));  // Mover o conteúdo da fila para baixo

    
        panelPilha.setLayout(new BoxLayout(panelPilha, BoxLayout.Y_AXIS));
        panelFila.setLayout(new BoxLayout(panelFila, BoxLayout.Y_AXIS));
        
   
        panelPilha.add(tituloPilha);
        panelFila.add(tituloFila);
        
        // Botaos
        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false); // Input panel com fundo transparente
        inputField = new JTextField(10);
        btnPush = new JButton("Adicionar na Pilha");
        btnPop = new JButton("Remover da Pilha");
        btnEnqueue = new JButton("Adicionar na Fila");
        btnDequeue = new JButton("Remover da Fila");
   
        Color buttonColor = new Color(0, 0, 255); //AZUL
        btnPush.setBackground(buttonColor);
        btnPush.setForeground(Color.WHITE); 
        btnPop.setBackground(buttonColor);
        btnPop.setForeground(Color.WHITE);
        btnEnqueue.setBackground(buttonColor);
        btnEnqueue.setForeground(Color.WHITE);
        btnDequeue.setBackground(buttonColor);
        btnDequeue.setForeground(Color.WHITE);
        
        JLabel inputLabel = new JLabel("Elemento:");
        inputLabel.setForeground(Color.WHITE); 
        
        inputPanel.add(inputLabel);
        inputPanel.add(inputField);
        inputPanel.add(btnPush);
        inputPanel.add(btnPop);
        inputPanel.add(btnEnqueue);
        inputPanel.add(btnDequeue);
        
        // Botao funfando
        btnPush.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String elemento = inputField.getText();
                if (!elemento.isEmpty()) {
                    pilha.push(elemento);
                    atualizarPilha();
                    inputField.setText("");
                }
            }
        });
        
        btnPop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!pilha.isEmpty()) {
                    pilha.pop();
                    atualizarPilha();
                }
            }
        });
        
        btnEnqueue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String elemento = inputField.getText();
                if (!elemento.isEmpty()) {
                    fila.add(elemento);
                    atualizarFila();
                    inputField.setText("");
                }
            }
        });
        
        btnDequeue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!fila.isEmpty()) {
                    fila.removeFirst();
                    atualizarFila();
                }
            }
        });
        
        // Posicionamento da fila e pilha
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Pilha mais para a direita
        gbc.insets = new Insets(0, 50, 0, 0); // Espacamento para deslocar a pilha
        
        mainPanel.add(panelFila, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(panelPilha, gbc);
        
        // Painel do frame
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    // Atualiza Pilha
    private void atualizarPilha() {
        panelPilha.removeAll();
        JLabel tituloPilha = new JLabel("Pilha", SwingConstants.CENTER);
        tituloPilha.setFont(new Font("Arial", Font.BOLD, 24));
        tituloPilha.setForeground(Color.WHITE); // Titulo em branco
        panelPilha.add(tituloPilha);
        for (String elemento : pilha) {
            JLabel label = new JLabel(elemento);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 18)); // Elementos com fonte maior
            label.setForeground(Color.BLUE); // Texto azul, sem fundo
            panelPilha.add(label);
        }
        panelPilha.revalidate();
        panelPilha.repaint();
    }
    
    // Atualiza Fila
    private void atualizarFila() {
        panelFila.removeAll();
        JLabel tituloFila = new JLabel("Fila", SwingConstants.CENTER);
        tituloFila.setFont(new Font("Arial", Font.BOLD, 24));
        tituloFila.setForeground(Color.WHITE); // Titulo em branco
        panelFila.add(tituloFila);
        for (String elemento : fila) {
            JLabel label = new JLabel(elemento);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 18)); // Elementos com fonte maior
            label.setForeground(Color.BLUE); // Texto azul, sem fundo
            panelFila.add(label);
        }
        panelFila.revalidate();
        panelFila.repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface();
            }
        });
    }
}
