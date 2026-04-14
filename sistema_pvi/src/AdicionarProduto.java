import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdicionarProduto extends JFrame {
    private JTextField campoParaPreco;
    private JTextField campoParaNome;
    private JLabel mostrarNaTela;


    void voltar() {
        JButton botaoVoltar = new JButton("Voltar");
        add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            new InterfaceInterativa().setVisible(true);
            dispose(); // fecha a segunda tela
        });
    }

    private static List<Produto> produtoscadastrados = new ArrayList<>();

    public AdicionarProduto() {
        setTitle("Cadastrar Produto");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        campoParaNome = new JTextField(20);
        add(new JLabel("Digite o nome para este produto: "));
        add(campoParaNome);

        JButton salvarProduto = new JButton("Salvar produto");
        add(salvarProduto);

        mostrarNaTela = new JLabel("");
        add(mostrarNaTela);

        campoParaPreco = new JTextField(20);
        add(new JLabel("Digite o preço para este produto: "));
        add(campoParaPreco);

        salvarProduto.addActionListener(e -> {
            String nome = campoParaNome.getText();
            double preco = Double.parseDouble(campoParaPreco.getText());

            Produto produtoConstrutor = new Produto();
            produtoConstrutor.setNome(nome);
            produtoConstrutor.setPreco(preco);

            if (!nome.isEmpty() && !campoParaPreco.getText().isEmpty()) {
                try {
                    FileWriter writer = new FileWriter("produtos.csv", true); // true = adiciona sem apagar
                    writer.append(nome + ", " + preco);
                    writer.append("\n"); // quebra de linha
                    writer.close();

                    produtoscadastrados.add(produtoConstrutor);
                    mostrarNaTela.setText("Produto " + nome + " salvo com sucesso! Valor: " + preco);

                } catch (IOException ex) {
                    mostrarNaTela.setText("Erro ao salvar!");
                    ex.printStackTrace();
                }
            } else {
                mostrarNaTela.setText("Digite algo!");
            }

        });

        voltar();
    }
}
