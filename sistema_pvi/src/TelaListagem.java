import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
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


        JTextField campoExcluir = new JTextField(20);
        add(campoExcluir);

        JButton botaoExcluir = new JButton("Excluir funcionário");
        add(botaoExcluir);

        JButton botaoVoltar = new JButton("Voltar");
        add(botaoVoltar);

        mostraNomes = new JLabel();
        add(mostraNomes);

        botaoVoltar.addActionListener(e -> {
            new InterfaceInterativa().setVisible(true);
            dispose(); // fecha a segunda tela
        });

        botaoExcluir.addActionListener(e -> {
            String nomeExcluir = campoExcluir.getText().trim(); //pega o que foi digitado no campo e guarda nessa string ai
            if (nomeExcluir.isEmpty()){
                JOptionPane.showMessageDialog(null, "Digite um nome");
                return;
            } //Verifica se o campo ta vazio e se tiver aparece mensagem na tela

            if (nomeExcluir.equalsIgnoreCase("penes")){
                JOptionPane.showMessageDialog(null,"Penes não pode ser excluido pois ele é onipotente");
            }

            try {
                Path caminho = Path.of("dados.csv"); //Acha o caminha da lista
                List<String> linhas = Files.readAllLines(caminho); // Cria uma lista com o texto do arquivo

                boolean removido = linhas.removeIf(nome -> nome.equalsIgnoreCase(nomeExcluir) && !nome.equalsIgnoreCase("penes")); //Verifica se o nome digitado é igual algum da lista, se for retorna true no boleano e remove da lista

                if(removido == true){
                    Files.write(caminho, linhas); //Reescreve o arquivo com a lista de texto nova
                    JOptionPane.showMessageDialog(null, "Funcionário removido!");

                    String texto = "<html>" + String.join("<br>", linhas) + "</html>"; //Atualiza a mostragem de nomes na lista
                    mostraNomes.setText(texto);

                    campoExcluir.setText(""); //Limpa o texto no campo
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
                }

            } catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao excluir");
            }

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
