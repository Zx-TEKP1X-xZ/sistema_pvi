import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Produto extends JFrame {

    private JTextField campoPreco;
    private JLabel mostrarNaTela;

    private String idProduto;
    private String nome;
    private double preco;
    private int contadorAdicionar = 0;

    public Produto () {
        setTitle("Cadastrar Produto");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        campoPreco = new JTextField(20);
        add(new JLabel("Digite o novo preço: "));
        add (campoPreco);

        JButton salvarNovoPreco = new JButton("Salvar novo valor");
        add(salvarNovoPreco);

        mostrarNaTela = new JLabel("");
        add(mostrarNaTela);

        salvarNovoPreco.addActionListener(e -> {
            double novoPreco = Double.parseDouble(campoPreco.getText());
            setPreco(novoPreco);

            new InterfaceInterativa().setVisible(true);
            dispose();
        });

        JButton salvarPreco = new JButton("Salvar valor");
        add(salvarPreco);

        salvarPreco.addActionListener(e -> {
            double preco = Double.parseDouble(campoPreco.getText());
            setPreco(preco);

            new InterfaceInterativa().setVisible(true);
            dispose();
        });

        List<Produto> produtoscadastrados = new ArrayList<>();

        Produto produto = new Produto(preco, nome);
        produtoscadastrados.add(produto);

        try {
            FileWriter writer = new FileWriter("produtos.csv", true);
            writer.append(produto);
            writer.append("\n"); // quebra de linha
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void adicionarEstoque (int quantidade) {
        contadorAdicionar += quantidade;
    }

    void removerEstoque (int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Tente Novamente!");
        } else {
            contadorAdicionar -= quantidade;
        }
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Produto setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public Produto setContadorAdicionar(int contadorAdicionar) {
        this.contadorAdicionar = contadorAdicionar;
        return this;
    }

    void atualizarPreco (double novoPreco) {
        this.preco = novoPreco;
    }

}
