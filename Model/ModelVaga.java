/*
 * Copyright (C) 2017 Andre Luis Zipf <andrezipf94 at gmail.com>
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
 * @author Andre Luis Zipf <andrezipf94 at gmail.com>
 */
public class ModelVaga {

    public static final int ESTADO_ABERTO = 0;
    public static final int ESTADO_CONCLUIDO = 1;

    private int id;
    private String nome;
    private String descricao;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstado() {
        return estado;
    }

    public String getEstadoAsString() {
        switch (getEstado()) {
            case ESTADO_ABERTO:
                return "Aberto";
            case ESTADO_CONCLUIDO:
                return "Concluído";
        }
        return "Estado Desconhecido";
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
