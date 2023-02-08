<%@page import="bean.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String erro  = (String) request.getAttribute("erroEditar");
    String nome = (String) request.getAttribute("nome");
    String sobrenome = (String) request.getAttribute("sobrenome");
    String email = (String) request.getAttribute("email");
    String senha = (String) request.getAttribute("senha");
    String sexo = (String) request.getAttribute("sexo");
%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="estilos/editar.css" />
    <link rel="stylesheet" href="estilos/media-query-editar.css" />
    <title>Agenda de Contatos</title>
  </head>
  <body>
    <div id="formulario">
      <div id="img">
        <!--imagem fica aki-->
      </div>
      <div id="formulario-container">
        <h1>Editar conta</h1>
        <%if(erro != null){out.print("<p id='msg-erro'>E-mail inválido, tente novamente!</p>");}%>
        <form action="EditarLoginServlet" method="POST">
            <div>
              <label for="inome">Primeiro nome</label>
              <input
                class="caixa"
                type="text"
                name="nome"
                id="inome"
                value="<%=nome%>"
                required
                pattern="[^' ']+"
              />
            </div>
            <div>
              <label for="isobrenome">Último nome</label>
              <input
                class="caixa"
                type="text"
                name="sobrenome"
                id="isobrenome"
                value="<%=sobrenome%>"
                required
                pattern="[^' ']+"
              />
            </div>
            <div>
              <label for="iemail">Email</label>
              <input
                class="caixa"
                type="email"
                name="email"
                id="iemail"
                required
                autocomplete="email"
                value="<%=email%>"
              />
            </div>
            <div>
              <label for="isenha">Senha</label>
              <input
                class="caixa"
                type="text"
                name="senha"
                id="isenha"
                required
                autocomplete="current-password"
                value="<%=senha%>"
              />
            </div>
            <div>
              <label style="display: block; margin-bottom: 15px" for="isexo"
                >Sexo</label
              >
              <div id="sexo">
                  <%if(sexo.equals("M")){%>
                  <label style="display: inline" for="im">Masculino</label>
                  <input type="radio" name="sexo" id="im" value="M" required checked=""/>
                  <label style="display: inline; margin-left: 25px" for="if">Feminino</label>
                  <input type="radio" name="sexo" id="if" value="F" required />
                  <%}%>
                  <%if(sexo.equals("F")){%>
                  <label style="display: inline" for="im">Masculino</label>
                  <input type="radio" name="sexo" id="im" value="M" required />
                  <label style="display: inline; margin-left: 25px" for="if">Feminino</label>
                  <input type="radio" name="sexo" id="if" value="F" required checked=""/>
                  <%}%>
              </div>
            </div>
            <div id="botoes">
              <input type="submit" value="Editar" />
              <a href="HomeServlet">Cancelar</a>
            </div>
        </form>
      </div>
    </div>
  </body>
</html>

