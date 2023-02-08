<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String erro = (String) request.getAttribute("erroCriar");
    //dados para ser prenchido caso ocorra erro
    String sexo = (String) request.getAttribute("sexo");
    String nome = (String) request.getAttribute("nome");
    String sobrenome = (String) request.getAttribute("sobrenome");
    String email = (String) request.getAttribute("email");
    String senha = (String) request.getAttribute("senha");
    
%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="estilos/criar.css" />
        <link rel="stylesheet" href="estilos/criar-media-query.css" />
        <title>Agenda de Contatos</title>
    </head>
    <body>
        <!--formulário para criar conta-->
        <main>
            <form action="CriarLoginServlet" method="POST" autocomplete="on">
                <div id="container-img">
                    <!--aqui fica a imagem de fundo-->
                </div>
                <div id="container-form">
                    <h1>Criar conta</h1>
                    <% if (erro != null) {
                            out.print("<p class='msg-erro'>Email inválido, pois ja existe usuário com esse email. Tente outro.</p>");
                        }%>
                    <div>
                        <label for="inome">Primeiro nome</label>
                        <input class="caixa" type="text" name="nome" id="inome"   value="<%if (nome != null) {
                                out.print(nome);
                            }%>" required pattern="[^' ']+"/>
                    </div>
                    <div>
                        <label for="isobrenome">Último nome</label>
                        <input class="caixa" type="text" name="sobrenome" id="isobrenome"   value="<%if (sobrenome != null) {
                                out.print(sobrenome);
                            }%>" required pattern="[^' ']+"/>
                    </div>
                    <div>
                        <label for="iemail">Email</label>
                        <input class="caixa"
                               type="email"
                               name="email"
                               id="iemail"
                               required
                               autocomplete="email" 
                               value="<%if (email != null) {
                                       out.print(email);
                                   }%>"
                               />
                    </div>
                    <div>
                        <label for="isenha">Senha</label>
                        <input class="caixa"
                               type="text"
                               name="senha"
                               id="isenha"
                               required
                               autocomplete="current-password"
                               value="<%if (senha != null) {
                                       out.print(senha);
                                   }%>"
                               />
                    </div>
                    <div>
                        <label style="display: block; margin-bottom: 15px" for="isexo"
                               >Sexo</label
                        >
                        <%if (sexo != null && sexo.equals("M")){%>
                        <label style="display: inline" for="im">Masculino</label>
                        <input type="radio" name="sexo" id="im" value="M" required checked=""/>
                        <label style="display: inline; margin-left: 25px" for="if">Feminino</label>
                        <input type="radio" name="sexo" id="if" value="F" required />
                        <%}%>
                        <%if (sexo != null && sexo.equals("F")){%>
                        <label style="display: inline" for="im">Masculino</label>
                        <input type="radio" name="sexo" id="im" value="M" required />
                        <label style="display: inline; margin-left: 25px" for="if">Feminino</label>
                        <input type="radio" name="sexo" id="if" value="F" required checked=""/>
                        <%}%>
                        <%if (sexo == null){%>
                        <label style="display: inline" for="im">Masculino</label>
                        <input type="radio" name="sexo" id="im" value="M" required />
                        <label style="display: inline; margin-left: 25px" for="if">Feminino</label>
                        <input type="radio" name="sexo" id="if" value="F" required />
                        <%}%>
                    </div>
                    <div id="botoes">
                        <input type="submit" value="Criar" />
                        <a href="login.jsp">Cancelar</a>
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
