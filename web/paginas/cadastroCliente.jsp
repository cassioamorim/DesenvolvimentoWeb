<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Cadastro de Cliente</title>

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
                            Cliente
                        </div>
                        <div class="panel-body">
                            <div class="col-lg-6">
                                <form role="form" action="${pageContext.request.contextPath}/clienteLista">
                                    <div class="form-group">
                                        <label>CPF</label>
                                        <input class="form-control" name="cpfCliente">
                                    </div>
                                    <div class="form-group">
                                        <label>Nome completo</label>
                                        <input class="form-control" name="nomeCliente">
                                    </div>
                                    <div class="form-group">
                                        <label>Data de nascimento</label>
                                        <input class="form-control" name="nascCliente" placeholder="dd/mm/aaaa">
                                        <p class="form-control-static">dd/mm/aaaa</p>
                                    </div>
                                    <div class="form-group">
                                        <label>Login</label>
                                        <input class="form-control" name="loginCliente">
                                    </div>
                                    <div class="form-group">
                                        <label>Senha</label>
                                        <input type="password" name="senhaCliente" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Telefone</label>
                                        <input class="form-control" name="telefoneCliente" placeholder="(XX) 9XXXX-XXXX">
                                        <p class="form-control-static">(XX) 9XXXX-XXXX</p>
                                    </div>
                                    <div class="form-group">
                                        <label>Endereço</label>
                                        <input class="form-control" name="enderecoCliente">
                                    </div>
                                    <button type="submit" class="btn btn-default">Cadastrar</button>
                                    <button type="reset" class="btn btn-default">Apagar campos</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>