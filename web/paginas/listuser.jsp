<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>IF Banca</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/datepicker3.css" rel="stylesheet">
        <link href="bootstrap/css/styles.css" rel="stylesheet">

        <script src="bootstrap/js/jquery.mask.min.js"></script>


        <!--Icons-->
        <script src="bootstrap/js/lumino.glyphs.js"></script>


        <!--[if lt IE 9]>
        <script src="bootstrap/js/html5shiv.js"></script>
        <script src="bootstrap/js/respond.min.js"></script>
        <![endif]-->

    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="home.html"><span>IF</span>Banca</a>
                    <ul class="user-menu">
                        <li class="dropdown pull-right">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Usuário <span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="editperfil.html"><svg class="glyph stroked male-user"><use xlink:href="altuser.jsp"></use></svg> Editar perfil </a></li>
                                <li><a href="logout.html"><svg class="glyph stroked cancel"><use xlink:href="logout.jsp"></use></svg> Sair </a></li>
                            </ul>
                        </li>
                    </ul>
                </div>

            </div><!-- /.container-fluid -->
        </nav>

        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <form role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Buscar">
                </div>
            </form>
            <ul class="nav menu">
                <li><a href="caduser.html"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar usuário</a></li>
                <li class="active"><a href="listuser.html"><svg class="glyph stroked notepad"><use xlink:href="#stroked-notepad"></use></svg> Lista de usuários </a></li>
                <li><a href="altuser.html"><svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"></use></svg> Alterar usuário</a></li>
                <li><a href="deluser.html"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"/></svg> Desativar usuário </a></li>
                <li><a href="cadbanca.html"><svg class="glyph stroked calendar blank"><use xlink:href="#stroked-calendar-blank"></use></svg> Cadastrar banca</a></li>
                <li><a href="listbanca.html"><svg class="glyph stroked calendar"><use xlink:href="#stroked-calendar"></use></svg> Lista de bancas</a></li>
                <li><a href="altbanca.html"><svg class="glyph stroked clipboard with paper"><use xlink:href="#stroked-clipboard-with-paper"></use></svg> Alterar banca </a></li>
                <li><a href="delbanca.html"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"/></svg> Deletar banca </a></li>
            </ul>


        </div><!--/.sidebar-->

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="home.html"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Lista de usuários</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Lista de usuários</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-12">


                                <table class="table"> 
                    <thead> 
                    <tr> 
                        <th>Nome</th> 
                        <th>Email</th> 
                        <th>Celular</th>
                    </tr> 
                    </thead> 
                    <tbody>
                        <c:forEach var="usuario" items='${usuarios}'>
                            <tr> 
                                <td><c:out value="${usuario.getNome()}"></c:out></td> 
                                <td><c:out value="${usuario.getEmail()}"></c:out></td> 
                                <td><c:out value="${usuario.getCelular()}"></c:out></td> 
                                
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                            </div>

                        </div>
                    </div>
                </div><!-- /.col-->
            </div><!-- /.row -->

        </div><!--/.main-->

        <script src="bootstrap/js/jquery-1.11.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="bootstrap/js/chart.min.js"></script>
        <script src="bootstrap/js/chart-data.js"></script>
        <script src="bootstrap/js/easypiechart.js"></script>
        <script src="bootstrap/js/easypiechart-data.js"></script>
        <script src="bootstrap/js/bootstrap-datepicker.js"></script>
        <script>
            !function ($) {
                $(document).on("click", "ul.nav li.parent > a > span.icon", function () {
                    $(this).find('em:first').toggleClass("glyphicon-minus");
                });
                $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
            }(window.jQuery);

            $(window).on('resize', function () {
                if ($(window).width() > 768)
                    $('#sidebar-collapse').collapse('show')
            })
            $(window).on('resize', function () {
                if ($(window).width() <= 767)
                    $('#sidebar-collapse').collapse('hide')
            })

        </script>
        <script src="js/validator.min.js"></script>

    </body>

</html>


