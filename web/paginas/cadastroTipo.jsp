<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, 
        DAOs.DAOTipo ,
        Entidades.Tipo" %>
<%
    DAOTipo daoTipo = new DAOTipo();
    Tipo tipo = new Tipo();
    String editando = request.getParameter("idTipo");
    if (editando != null) {
        tipo = daoTipo.listById(Integer.parseInt(request.getParameter("idTipo"))).get(0);
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Cadastro de Tipo</title>

        <!-- Bootstrap Core CSS -->
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="/paginas/cabecalho.html" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->

        <!-- Custom Fonts -->
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <h1 class="page-header">Cadastro</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Tipo
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="${pageContext.request.contextPath}/tipoLista">
                                        <div class="form-group">
                                            <label>ID</label>
                                            <% if (editando == null) {%>
                                            <input class="form-control" name="idTipo" value="<%=tipo.getIdTipo()%>" readonly="">
                                            <% } else {%>
                                            <span class="form-control" name="idTipo" value="<%=tipo.getIdTipo()%>" readonly=""></span>
                                            <% }%>
                                            <input class="form-control"  type="hidden" name="idTipo" value="<%=tipo.getNome()%>"/>
                                        </div>
                                        <div class="form-group">
                                            <label>Tipo</label>
                                            <input class="form-control" name="nomeTipo" value="<%=editando != null ? tipo.getNome() : ""%>">
                                        </div>
                                        <button type="submit" class="btn btn-default">Enviar dados</button>
                                        <button type="reset" class="btn btn-default">Apagar dados</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>