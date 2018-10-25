<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
    <jsp:useBean id="daoMarca" class="DAOs.DAOMarca"/>
    <jsp:useBean id="daoTipo" class="DAOs.DAOTipo"/>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Cadastro de produto</title>

        <!-- Bootstrap Core CSS -->
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

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
                            Produto
                        </div>
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <form role="form" action="${pageContext.request.contextPath}/produtoLista">
                                    <div class="form-group">
                                        <label>ID</label>
                                        <input class="form-control" name="idProduto">
                                    </div>
                                    <div class="form-group">
                                        <label>Nome</label>
                                        <input class="form-control" name="nomeProduto">
                                    </div>
                                    <div class="form-group">
                                        <label>Especificações</label>
                                        <input class="form-control" name="especProduto">
                                    </div>
                                    <div class="form-group">
                                        <label>Preço</label>
                                        <input class="form-control" name="precoProduto">
                                    </div>
                                    <div class="form-group">
                                        <label>Selecione o tipo</label>
                                        <select class="form-control" name="tipoProduto">
                                            <c:forEach var="tipo" items="${daoTipo.listInOrderId()}">                                                                                                   
                                                <option value="${tipo.getIdTipo()}">${tipo.getNome()}</option>                                              
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Selecione a marca</label>
                                        <select class="form-control" name="marcaProduto">
                                            <c:forEach var="marca" items="${daoMarca.listInOrderId()}">                                                                                                   
                                                <option value="${marca.getIdMarca()}">${marca.getNome()}</option>                                              
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-default">Cadastrar</button>
                                    <button type="reset" class="btn btn-default">Apagar dados</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
