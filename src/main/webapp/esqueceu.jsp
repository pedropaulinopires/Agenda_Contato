<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String erro = (String) request.getAttribute("erro");
    String exito = (String) request.getAttribute("exito");
    String senha  = (String) request.getAttribute("senha");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="estilos/esqueceu.css">
    <link rel="stylesheet" href="estilos/esqueceu-media-query.css">
    <title>Agenda de Contatos</title>
</head>
<body>
    <main>
        <div id="container-img">
            <!--aqui é onde fica a imagem-->
        </div>
        <form action="RecuperarLoginServlet" method="POST" autocomplete="on">
            <h1>Esqueceu a Senha?</h1>
            <%if(exito != null){out.print("<p id='msg-exito'>Sua senha: "+senha+"</p>");}%>
            <p>Informe seu email no campo abaixo para recuperar a sua senha!</p>
            <div id="campo">
                <label for="iemail">Email</label>
                <input type="email" name="email" id="iemail" required="" autocomplete="email"
                       value="<%if(request.getAttribute("email") != null){out.print(request.getAttribute("email"));}%>"
                       >
            </div>
             <%if(erro != null){out.print("<p id='msg-erro'>Email inválido, tente novamente.</p>");}%>
            <div id="botoes">
                <input type="submit" value="Recuperar">
                <a href="login.jsp" id="botao">Voltar</a>
            </div>
        </form>
    </main>
</body>
</html>
