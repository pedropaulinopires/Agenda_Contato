<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String erro = (String) request.getAttribute("erroLogin");
    String exito = (String) request.getAttribute("exitoConta");
    String exitoEditar = (String) request.getAttribute("exitoEditar");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilos/style.css">
    <link rel="stylesheet" href="estilos/media-query.css">
    <title>Agenda de Contatos</title>
</head>
<body>
    <div id="form">
        <form action="LoginServlet" method="POST">
            <div id="container-img">
                <!--ficará a imagem-->
            </div>
            <div id="container-form">
                <h1>Entrar</h1>
                <div class="campo">
                    
                    <label style="margin-left: 5px;" for="iemail">Email:</label>
                    <input type="email" name="email" id="iemail" required autocomplete="email" value="<%if(request.getAttribute("email") != null){out.print(request.getAttribute("email"));}%>">
                </div>
                <div class="campo">
                    <label for="isenha">Senha:</label>
                    <input type="password" name="senha" id="isenha" required autocomplete="current-password" >
                </div>
                <%if( erro != null ){out.print("<p class='msg_erro'>Email/Senha incorretos</p>");}%>
                 <%if( exito != null ){out.print("<p class='msg_exito'>Conta criada com sucesso!</p>");}%>
                 <%if( exitoEditar != null ){out.print("<p class='msg_exito'>Conta editada com sucesso!Faça o login novamente.</p>");}%>
            <input id="botao" type="submit" value="Entrar">
            <p id="function">
                <a href="criar.jsp" style="margin-left: 35px;">Cadastre-se aqui</a>|
                <a href="esqueceu.jsp">Equeceu-senha</a>
            </p>
            </div>
        </form>
    </div>
</body>
</html>

