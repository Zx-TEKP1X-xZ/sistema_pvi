import java.awt.FlowLayout;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.swing.*;


public class TelaListagem extends JFrame{
    private JLabel mostraNomes;

    public TelaListagem(String nomeLista){
        setTitle("Lista de Funcionários");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        setLayout(new FlowLayout());

        mostraNomes = new JLabel();
        add(mostraNomes);

        JButton botaoVoltar = new JButton("Voltar");
        add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            new InterfaceInterativa().setVisible(true);
            dispose(); // fecha a segunda tela
        });

        try {
            Path caminho = Path.of(nomeLista);
            List<String> linhas = Files.readAllLines(caminho);
            String texto = "<html>" + String.join("<br>", linhas) + "</html>";
            mostraNomes.setText(texto);
        }
        catch(Exception e){
            e.printStackTrace();
            mostraNomes.setText("Erro ao ler o arquivo");
            
        }

    }
}
