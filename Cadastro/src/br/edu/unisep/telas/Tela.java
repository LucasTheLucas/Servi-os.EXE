package br.edu.unisep.telas;

import br.edu.unisep.funcoes.Funcoes;
import br.edu.unisep.model.Servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class Tela {
    public void Exibir(List<Servico> servicos, Editar editarTela, Funcoes funcoes)
    {
        JFrame tela = new JFrame();
        tela.setTitle("Exibir Serviços");
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setSize(500, 500);



        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        JLabel LabelServicos = new JLabel("Servicos");
        LabelServicos.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelServicos.setFont(LabelServicos.getFont().deriveFont(50f));
        painelPrincipal.add(LabelServicos);

        for (int i = 0; i < servicos.size(); i++) {
            JLabel label = new JLabel(servicos.get(i).getNomeServico());
            JLabel label1 = new JLabel('"'+servicos.get(i).getDescricaoServico()+'"');
            JLabel label2 = new JLabel("Preço: R$" + servicos.get(i).getValorServico() + " - Tempo: " + servicos.get(i).getTempoServico() + " minutos");

            label.setFont(new Font("Arial", Font.BOLD, 20));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            label1.setAlignmentX(Component.CENTER_ALIGNMENT);
            label2.setAlignmentX(Component.CENTER_ALIGNMENT);

            JPanel painel = new JPanel();
            painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

            painel.add(label);
            painel.add(label1);
            painel.add(label2);
            JButton editar = new JButton("Editar");
            int index = i;
            editar.addActionListener(e ->
            {
                editarTela.editarServico(servicos,index,funcoes);
                tela.dispose();
            });
            editar.setAlignmentX(Component.CENTER_ALIGNMENT);
            painel.add(editar);



            painelPrincipal.add(painel);
        }
        tela.add(painelPrincipal);
        tela.setVisible(true);
    }
}
