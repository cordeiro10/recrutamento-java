package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Schmidt Cordeiro <gabrielscordeiro2012@gmail.com>
 */
public class ModelCurriculo {

    private int id;
    private String nome;
    private String endereco;
    private int numeroTelefone;
    private String email;
    private String objetivo;
    private String formacao;
    private String experienciaProfissional;
    private String qualificacaoProfissional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getExperienciaProfissional() {
        return experienciaProfissional;
    }

    public void setExperienciaProfissional(String experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

    public String getQualificacaoProfissional() {
        return qualificacaoProfissional;
    }

    public void setQualificacaoProfissional(String qualificacaoProfissional) {
        this.qualificacaoProfissional = qualificacaoProfissional;
    }

}
