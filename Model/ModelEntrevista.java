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
public class ModelEntrevista {

    public final static int ESTADO_ABERTO = 0;
    public final static int ESTADO_FINALIZADO = 1;

    private int id;
    private ModelCandidato candidato = new ModelCandidato();
    private String dataInicio;
    private String dataTermino;
    private int estado;
    private String notas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModelCandidato getCandidato() {
        return candidato;
    }

    public void setCandidato(ModelCandidato candidato) {
        this.candidato = candidato;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getEstado() {
        return estado;
    }

    public String getEstadoAsString() {
        switch (getEstado()) {
            case ESTADO_ABERTO:
                return "Aberta";
            case ESTADO_FINALIZADO:
                return "Finalizada";
        }
        return "Desconhecido";
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

}
