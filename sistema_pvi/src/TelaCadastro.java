import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class TelaCadastro extends JFrame {

    private JTextField campoTexto;
    private JLabel Resultado;

    public TelaCadastro() {

        setTitle("Segunda Tela");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JButton botaoVoltar = new JButton("Voltar");
        add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            new InterfaceInterativa().setVisible(true);
            dispose(); // fecha a segunda tela
        });

        // 1. Criando o Campo de Entrada (Input)
        campoTexto = new JTextField( 20); // 20 é a largura visual do campo
        add(new JLabel("Digite seu nome:" ));
        add( campoTexto );

        JButton Salvar = new JButton("Salvar funcionário");
        add(Salvar);

        Resultado = new JLabel("");
        add(Resultado);

        Salvar.addActionListener(e -> {
            String nome = campoTexto.getText();

            //BOTAO PRA SALVA FUNCIONARIO VAGABUNDO
            if (!nome.isEmpty()) {
                try {
                    FileWriter writer = new FileWriter("dados.csv", true); // true = adiciona sem apagar
                    writer.append(nome);
                    writer.append("\n"); // quebra de linha
                    writer.close();

                    Resultado.setText("Salvo com sucesso!");
                } catch (IOException ex) {
                    Resultado.setText("Erro ao salvar!");
                    ex.printStackTrace();
                }
            } else {
                Resultado.setText("Digite algo!");
            }
        });

    }
}