package br.edu.unisep.view;

import br.edu.unisep.funcoes.Funcoes;
import br.edu.unisep.model.Servico;
import br.edu.unisep.telas.AdicionarServico;
import br.edu.unisep.telas.Editar;
import br.edu.unisep.telas.Tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args)
    {
        Funcoes funcoes = new Funcoes();
        List<Servico> servicos = funcoes.lerServicos();
        Tela tela = new Tela();
        AdicionarServico adicionarServico = new AdicionarServico();
        Editar editarTela = new Editar();

        JFrame janelaPrincipal = new JFrame();
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setTitle("Serviços.EXE");
        janelaPrincipal.setSize(800, 600);

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.add(Box.createVerticalStrut(200));

        JLabel labelTitulo = new JLabel("Bem-vindo ao Serviços.EXE");
        labelTitulo.setFont(new Font("Arial", Font.BOLD,40));
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);


        painelPrincipal.add(labelTitulo);

        JPanel painelMenu = new JPanel();
        JButton exibir = new JButton("Exibir serviços");
        exibir.addActionListener(e ->
        {
            tela.Exibir(servicos, editarTela, funcoes);
        });
        JButton adicionar = new JButton("Adicionar serviços");
        adicionar.addActionListener(e ->
        {
            adicionarServico.adicionarServico(servicos, funcoes);
        });

        JButton sairSalvar = new JButton("Sair e salvar");
        sairSalvar.addActionListener(e ->
        {
            funcoes.Salvar(servicos);
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
            System.exit(0);
        });

        painelMenu.add(exibir);
        painelMenu.add(adicionar);
        painelMenu.add(sairSalvar);

        painelPrincipal.add(painelMenu);

        janelaPrincipal.add(painelPrincipal);
        janelaPrincipal.setVisible(true);
    }
}
