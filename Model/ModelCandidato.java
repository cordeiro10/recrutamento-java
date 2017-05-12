/*
 * Copyright (C) 2017 Gabriel Batista Alves <Gabrieltanasia at bitbucket.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Model;

/**
 *
 * @author Gabriel Batista Alves <Gabrieltanasia at bitbucket.org>
 */
public class ModelCandidato {
    public static final int ESTADO_ATIVO = 0;
    public static final int ESTADO_INATIVO = 1;
    
    private int id;
    private String nome;
    private int idade;
    private int estado;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public int getEstado(){
        return estado;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public String getEstadoAsString() {
        switch (getEstado()) {
            case ESTADO_ATIVO:
                return "Ativo";
            case ESTADO_INATIVO:
                return "Inativo";
        }
        return "Desconhecido";
    }
}
