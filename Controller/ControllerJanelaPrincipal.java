/*
 * Copyright (C) 2017 Andre Luis Zipf <andrezipf94 at bitbucket.org>
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
package Controller;

import View.ViewJanelaPrincipal;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author Andre Luis Zipf <andrezipf94 at gmail.com>
 */
public final class ControllerJanelaPrincipal {

    private static ViewJanelaPrincipal view = new ViewJanelaPrincipal();
    private final ControllerVaga controllerVaga = new ControllerVaga();
    private final ControllerCandidato controllerCandidato = new ControllerCandidato();
    private final ControllerCurriculo controllerCurriculo = new ControllerCurriculo();
    private final ControllerEntrevista controllerEntrevista = new ControllerEntrevista();

    public ControllerJanelaPrincipal() {
        view.setLocationRelativeTo(null); // quickfix para abrir centralizado

        /* Action Listeners */
        view.addActionListenerItemMenuSair(getActionListenerItemMenuSair());
        view.addActionListenerItemMenuGerenciarVagas(getActionListenerItemMenuGerenciarVagas());
        view.addActionListenerItemMenuGerenciarCandidato(getActionListenerItemMenuGerenciarCandidato());
        view.addActionListenerItemMenuGerenciarCurriculo(getActionListenerItemMenuGerenciarCurriculo());
        view.addActionListenerItemMenuGerenciarEntrevista(getActionListenerItemMenuGerenciarEntrevista());
    }

    public void inicia() {
        view.setVisible(true);
    }

    public static JDesktopPane getDesktop() {
        return view.getDesktop();
    }

    public ActionListener getActionListenerItemMenuGerenciarVagas() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!adicionado) {
                    view.getDesktop().add(controllerVaga.getView());
                    adicionado = true;
                }
                controllerVaga.getView().setVisible(true);
            }
        };
    }

    public ActionListener getActionListenerItemMenuGerenciarCandidato() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!adicionado) {
                    view.getDesktop().add(controllerCandidato.getView());
                    adicionado = true;
                }
                controllerCandidato.getView().setVisible(true);
            }
        };
    }

    public ActionListener getActionListenerItemMenuGerenciarCurriculo() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!adicionado) {
                    view.getDesktop().add(controllerCurriculo.getView());
                    adicionado = true;
                }
                controllerCurriculo.getView().setVisible(true);
            }
        };
    }

    public ActionListener getActionListenerItemMenuGerenciarEntrevista() {
        return new ActionListener() {
            private boolean adicionado = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (!adicionado) {
                    view.getDesktop().add(controllerEntrevista.getView());
                    adicionado = true;
                }
                controllerEntrevista.getView().setVisible(true);
            }
        };
    }

    public ActionListener getActionListenerItemMenuSair() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                view.dispatchEvent(new WindowEvent(view, Event.WINDOW_DESTROY));
            }
        };
    }

}
