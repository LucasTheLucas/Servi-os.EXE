package br.edu.unisep.telas;

import br.edu.unisep.funcoes.Funcoes;
import br.edu.unisep.model.Servico;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Editar {
    public void editarServico(List<Servico> servicos, int id, Funcoes funcoes)
        {
            JFrame frame = new JFrame();
            frame.setTitle("Editar Servico");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(500,500);


            JPanel painelPrincipal = new JPanel();
            painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

            JLabel LabelServicos = new JLabel("Editar serviço");
            LabelServicos.setAlignmentX(Component.CENTER_ALIGNMENT);
            LabelServicos.setFont(LabelServicos.getFont().deriveFont(30f));

            painelPrincipal.add(LabelServicos);

            JPanel painelInput = new JPanel();
            painelInput.setLayout(new BoxLayout(painelInput, BoxLayout.Y_AXIS));
            JTextField NomeServico = new JTextField(servicos.get(id).getNomeServico());
            NomeServico.setPreferredSize(new Dimension(200, 30));
            JTextField DescricaoServico = new JTextField(servicos.get(id).getDescricaoServico());
            DescricaoServico.setPreferredSize(new Dimension(200, 30));
            JTextField ValorServico = new JTextField(Float.toString(servicos.get(id).getValorServico()));
            ValorServico.setPreferredSize(new Dimension(200, 30));
            JTextField TempoServico = new JTextField(Integer.toString(servicos.get(id).getTempoServico()));
            TempoServico.setPreferredSize(new Dimension(200, 30));

            JLabel inputNomeServico = new JLabel("Nome do serviço");
            JLabel inputDescricaoServico = new JLabel("Descrição do serviço");
            JLabel inputValorServico =  new JLabel("Valor do serviço");
            JLabel inputTempoServico = new JLabel("Tempo do serviço");

            JPanel nomePanel = new JPanel();
            JPanel descPanel = new JPanel();
            JPanel valorPanel = new JPanel();
            JPanel tempoPanel = new JPanel();

            nomePanel.add(inputNomeServico);
            nomePanel.add(NomeServico);

            descPanel.add(inputDescricaoServico);
            descPanel.add(DescricaoServico);

            valorPanel.add(inputValorServico);
            valorPanel.add(ValorServico);

            tempoPanel.add(inputTempoServico);
            tempoPanel.add(TempoServico);

            painelInput.add(nomePanel);
            painelInput.add(descPanel);
            painelInput.add(valorPanel);
            painelInput.add(tempoPanel);

            JButton adicionar = new JButton("Alterar");
            adicionar.addActionListener(e ->
            {
                funcoes.editar(NomeServico.getText(),DescricaoServico.getText(),ValorServico.getText(),TempoServico.getText(),servicos,id);
                frame.dispose();
            });


            painelInput.add(adicionar);

            painelPrincipal.add(painelInput);
            frame.add(painelPrincipal);
            frame.setVisible(true);
        }
}
