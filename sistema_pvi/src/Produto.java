import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Produto  {
    private String nome;
    private double preco;

    public void setNome (String nome){
        this.nome = nome;
    }

    public void setPreco (double preco){
        this.preco = preco;
    }

    public String getNome () {
        return this.nome;
    }

    public double getPreco () {
        return this.preco;
    }

}
