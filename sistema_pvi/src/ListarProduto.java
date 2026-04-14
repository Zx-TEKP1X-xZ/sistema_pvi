import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ListarProduto extends JFrame {
    private JLabel mostrarNaTela;


    void voltar () {
        JButton botaoVoltar = new JButton("Voltar");
        add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            new InterfaceInterativa().setVisible(true);
            dispose(); // fecha a segunda tela
        });
    }

    private static List<Produto> produtoscadastrados = new ArrayList<>();

    public ListarProduto() {
        setTitle("Listar Produto");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 1));

        voltar();
    }
}