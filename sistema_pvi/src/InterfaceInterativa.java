import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class InterfaceInterativa extends JFrame {
    // Componentes declarados como atributos para facilitar o acesso
    private JTextField campoTexto ;
    private JButton botaoEnviar ;
    private JButton listarFuncionario;
    private JButton adicionarProduto;
    private JButton listarProduto;
    private JLabel labelResultado ;
    public InterfaceInterativa () {
// Configurações básicas do Frame
        setTitle( "Controle de Convênio" );
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
        setLocationRelativeTo( null);
// Definindo um Layout (FlowLayout organiza os itens um após o outro)
        setLayout( new FlowLayout());
// 2. Criando o Botão
        botaoEnviar = new JButton( "Cadastrar Funcionário" );
        add( botaoEnviar );

        listarFuncionario = new JButton("Listar Funcionário");
        add(listarFuncionario);

        adicionarProduto = new JButton("Cadastrar Produto");
        add(adicionarProduto);

        listarProduto = new JButton("Listar Produto");
        add(listarProduto);

// 3. Criando o Label de Resultado
        labelResultado = new JLabel("");
        add( labelResultado );
// --- AÇÃO DO BOTÃO ---
// Aqui definimos o que acontece quando o botão é clicado
        botaoEnviar.addActionListener(e -> {
            new TelaCadastro().setVisible(true);
            dispose(); // fecha a tela atual
        });

        listarFuncionario.addActionListener((e) -> {
            new TelaListagem("dados.csv").setVisible(true);
            dispose();
        });

        adicionarProduto.addActionListener((e) -> {
            new AdicionarProduto().setVisible(true);
            dispose();
        });

        listarProduto.addActionListener((e) -> {
            new ListarProduto().setVisible(true);
            dispose();
        });
    }
    public static void main(String[] args) {
        SwingUtilities. invokeLater(() -> {
            new InterfaceInterativa().setVisible( true);
        });
    }
}
