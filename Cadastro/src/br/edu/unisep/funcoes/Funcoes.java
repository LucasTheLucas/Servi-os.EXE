package br.edu.unisep.funcoes;

import br.edu.unisep.model.Servico;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ErrorManager;

public class Funcoes {

    public Funcoes() {}

    public List<Servico> lerServicos()
    {
        List<Servico> servicos = new ArrayList<Servico>();
        File pasta = new File("C://Servicos");
        File arquivo = new File(pasta,"servicos.txt");
        if(pasta.exists())
        {
            if(arquivo.exists())
            {
                try
                {
                    FileReader fr = new FileReader(arquivo);
                    BufferedReader br = new BufferedReader(fr);
                    String linha;
                    while ((linha = br.readLine())!= null)
                    {
                        String[] txt = linha.split(";");
                        Servico servico = new Servico(txt[0],txt[1],Float.parseFloat(txt[2]),Integer.parseInt(txt[3]));
                        servicos.add(servico);
                    }
                    br.close();
                    fr.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
                }
            }
            else
            {
                try
                {
                    arquivo.createNewFile();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
                }
            }
        }
        else
        {
            try
            {
                pasta.mkdir();
                arquivo.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
            }
        }

        return servicos;
    }

    public void adicionar(String nomeServico, String descricaoServico, String valorServico, String tempoServico, List<Servico> servicos)
    {
        if(nomeServico == null || nomeServico.isEmpty())
        {
            return;
        }
        if(descricaoServico == null || descricaoServico.isEmpty())
        {
            return;
        }
        if(valorServico == null || valorServico.isEmpty())
        {
            return;
        }
        if(tempoServico == null || tempoServico.isEmpty())
        {
            return;
        }
        try
        {
            float valor = Float.parseFloat(valorServico.replace(",","."));
            int tempo = Integer.parseInt(tempoServico);

            Servico servico = new Servico(nomeServico, descricaoServico, valor, tempo);

            servicos.add(servico);
            JOptionPane.showMessageDialog(null,"Adicionado com sucesso");
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao converter valor");
        }
    }
    public void editar(String nomeServico, String descricaoServico, String valorServico, String tempoServico, List<Servico> servicos, int id)
    {
        if(nomeServico == null || nomeServico.isEmpty())
        {
            return;
        }
        if(descricaoServico == null || descricaoServico.isEmpty())
        {
            return;
        }
        if(valorServico == null || valorServico.isEmpty())
        {
            return;
        }
        if(tempoServico == null || tempoServico.isEmpty())
        {
            return;
        }
        try
        {
            float valor = Float.parseFloat(valorServico.replace(",","."));
            int tempo = Integer.parseInt(tempoServico);

            Servico servico = new Servico(nomeServico, descricaoServico, valor, tempo);

            servicos.set(id,servico);
            JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao converter valor");
        }
    }
    public void Salvar(List<Servico> servicos)
    {
        File pasta = new File("C://Servicos");
        File arquivo = new File(pasta,"servicos.txt");

        try
        {
            FileWriter fr = new FileWriter(arquivo);
            for (int i = 0; i < servicos.size(); i++) {
                fr.write(servicos.get(i).getNomeServico()+";"+servicos.get(i).getDescricaoServico()+";"+servicos.get(i).getValorServico()+";"+servicos.get(i).getTempoServico()+";\n");
            }
            fr.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
