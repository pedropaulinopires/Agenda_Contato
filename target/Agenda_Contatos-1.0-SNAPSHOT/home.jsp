<%@page import="java.util.ArrayList"%>
<%@page import="bean.Contato"%>
<%@page import="bean.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msg = (String) request.getAttribute("msg");
    Login l = (Login) session.getAttribute("usuarioLogado");
    ArrayList<Contato> lista = (ArrayList<Contato>) request.getAttribute("lista");
    String acao = (String) session.getAttribute("acao");
    String erro = (String) session.getAttribute("erro");
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="estilos/home.css" />
        <link rel="stylesheet" href="estilos/home-media-query.css" />
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"
            />
        <script src="js/modais.js" defer></script>
        <title>Agenda de Contatos</title>
    </head>
    <body onresize="resetMenu()">
         <!--modal para excluir contato-->
        <div id="fade4" onclick="closeModalExcluir()"></div>
        <div id="modalExcluir">
            <div id="modalExcluir-header">
                <h1>Excluir contato</h1>
            </div>
            <div id="modalExcluir-body">
                <p>Tem certeza que deseja excluir o contato?</p>
                <form action="ExcluirContatoServlet" method="POST">
                    <input style="display: none
                    ;" type="text" name="id" id="iidExcluir">
                    <div id="botoes">
                        <input  type="submit" value="Excluir">
                        <a onclick="closeModalExcluir()" >Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
         <!--Modal para limpar lista-->
        <div id="fade3"  onclick='closeModalLimpar()'></div>
        <div id="modalLimpar">
            <div id="modalLimpar-header">
                <h1>Limpar Lista</h1>
            </div>
            <div id="modalLimpar-body">
                <p>Você tem certeza que deseja limpar todos os Contatos?</p>
                <div id="botoes">
                    <a  class="btn1" href="LimparServlet" >Limpar</a>
                    <button class="btn2"  onclick='closeModalLimpar()'>Cancelar</button>
                </div>
            </div>
        </div>
        <!--modal para Editar-->
                <div id="modalEditar" class="hide">
                    <div id="modalEditar-header">
                        <h1>Editar</h1>
                    </div>
                    <div id="modalEditar-body">
                        <form action="EditarContatoServlet" method="POST" autocomplete="off">
                            <input style="display: none" type="text" name="id" id="iidEditar" required>
                            <div id="campo">
                                <label for="inomeEditar">Nome</label>
                                <input type="text" name="nome" id="inomeEditar" required>
                            </div>
                            <div id="campo">
                                <label for="iemailEditar">E-mail</label>
                                <input type="text" name="email" id="iemailEditar" >
                            </div>
                            <div id="campo">
                                <label for="itelefoneEditar">Telefone</label>
                                <input type="text" name="telefone" id="itelefoneEditar" required>
                            </div>
                            <div id="botoes">
                                <input type="submit" value="Salvar">
                                <span id="closeModalEditar" onclick="closeModalEditar()">Cancelar</span>
                            </div>
                        </form>
                    </div>
                </div>
                <!---->
        <!--modal para add-->
        <div id="fade"  class="hide"></div>
        <div id="fade1"  class="hide1"></div>
        <div id="fade2" onclick="closeModalEditar()"></div>
        <div id="modalAdd" class="hide">
            <div id="modalAdd-header">
                <h1>Adicionar</h1>
            </div id="modalAdd-body">
            <form action="AdicionarContatoServlet" method="POST"  autocomplete="off">
                <div id="campo">
                    <label for="inome">Nome</label>
                    <input type="text" name="nome" id="inome" required>
                </div>
                <div id="campo">
                    <label for="iemail">E-mail</label>
                    <input type="text" name="email" id="iemail" >
                </div>
                <div id="campo">
                    <label for="itelefone">Telefone</label>
                    <input type="text" name="telefone" id="itelefone" required>
                </div>
                <div id="botoes">
                    <input type="submit" value="Adicionar">
                    <span id="closeModalAdd">Cancelar</span>
                </div>
            </form>
        </div>

        <!--modal para sair-->
        <div id="modalSair" class="hide">
            <div id="modalSair-header">
                <h1>Sair</h1>
            </div>
            <div id="modalSair-body">
                <p>Você realmente deseja sair?</p>
                <a href="SairServlet">Sim</a>
                <span id="closeModalSair" onclick="fecharModalSair()">Cancelar</span>
            </div>
        </div>
        <!---->
        <header id="menu-mobile">
            <div id="myNav" class="overlay">
                <span
                    id="closebtn"
                    onclick="closeNav()"
                    class="material-symbols-outlined"
                    >
                    close
                </span>
                <div class="overlay-content">
                    <a href="EditarLoginServlet" onclick="closeNav()">Editar perfil</a>
                    <a href="https://github.com/pedropaulinopires" target="_blank" rel="external" onclick="closeNav()">Git Hub</a>
                    <a href="https://www.instagram.com/pedropaulinopires/" target="_blank" rel="external" onclick="closeNav()">Contato</a>
                    <a href="#" id="openModalSair" onclick="closeNav()">Sair</a>
                </div>
            </div>

            <span id="openbnt" onclick="openNav()" class="material-symbols-outlined">
                menu
            </span>
            <p id='msg'><%=msg%></p>
        </header>
        <div id="img">
            <!--imagem-->
        </div>
        <main>
            <%if(acao != null){%>
            <div id="msg-execucao">
                <p><%=acao%></p>
            </div>
            <%}%>
            
            <%if(erro != null){%>
            <div id="msg-execucao-erro">
                <p><%=acao%></p>
            </div>
            <%}%>
            <!--opções-->
            <div id="opcoes">
                <a id="openModalAdd" class="bnt1">Adicionar Contato</a>
                <%if(lista != null && lista.size() != 0 ){%>
                <a href="RelatorioServlet" class="bnt2">Relatório</a>
                <%}%>
            </div>
            <!--Mesg caso não tenha dados-->

            <%if (lista == null) {%>
            <div id="msg">
                <p>
                    Você não possue contatos? Adicione logo acima!
                    <span id='emoji'>🤨</span>
                </p>
            </div>
            <%}%> 
            <%if (lista != null && lista.size() == 0) {%>
            <div id="msg">
                <p>
                    Você não possue contatos? Adicione logo acima!
                    <span id="emoji">🤨</span>
                </p>
            </div>
            <%}%>

            <%if (lista != null && lista.size() > 0) {%>
            <table>
                <thead>
                <th scope="col">Nome</th>
                <th scope="col">Telefone</th>
                <th scope="col">E-mail</th>
                <th scope="col">Opções</th>
                </thead>
                <tbody>
             <%for (Contato c : lista) {%>
                <tr>
                    <td data-title="Nome"><%= c.getNome()%></td>
                    <td data-title="Telefone"><%= c.getTelefone()%></td>

                    <td data-title="Email"><%= c.getEmail()%></td>
                    <td id="botao">
                        <a class="bnt1 openModalEditar"   onclick="openModalEditar('<%=c.getNome()%>','<%=c.getEmail()%>','<%=c.getTelefone()%>','<%=c.getId()%>')">Editar</a>
                        <a class="bnt2" onclick="openModalExcluir('<%=c.getId()%>')" >Excluir</a>
                    </td>
                </tr>
              <%}%>
                </tbody>
            </table>
            <%}%>
            <%if (lista != null && lista.size() > 0) {%>
            <div id="limpar">
                <div id="limpar-interno"><a onclick='openModalLimpar()' class="bnt2">Limpar lista</a></div>
            </div>
            <%}%>
        </main>
        <div id="scrollTopButton" onclick="scrollToTop()" class=" scrollTop  material-symbols-outlined">expand_less</div>
        <footer>
            <p>Site criado por <a href="https://www.instagram.com/pedropaulinopires/" target="_blank" rel="external">Pedro Henrique</a> para os estudos</p>
        </footer>
    </body>
    <script src="js/modalExcluir.js"></script>
    <script src="js/modalLimpar.js"></script>
    <script src="js/modalEditar.js"></script>
    <script src="js/scrollTop.js"></script>
    <script src="js/menuReset.js"></script>
    <script src="js/menu.js"></script>
</html>

