<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>IF Banca</title>

        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="bootstrap/css/datepicker3.css" rel="stylesheet">
        <link href="bootstrap/css/styles.css" rel="stylesheet">

        <script src="bootstrap/js/jquery.mask.min.js"></script>


        <!--Icons-->
        <script src="bootstrap/js/lumino.glyphs.js"></script>


        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
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
			<li>
                           <form name="CadastrarUsuario" method="POST" action="Executa">
                            <ul class="nav menu">
                                    <li><a href="javascript:document.CadastrarUsuario.submit()"><svg class="glyph stroked pencil"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar usuário</a></li>
                                    <input type="hidden" name="tarefa" value="NovoUsuario"> 
                            </ul>
                            </form>
                        </li>
                        <li>
                            <form name="ListarUsuario" method="POST" action="Executa">
                            <ul class="nav menu">
                                    <li><a href="javascript:document.ListarUsuario.submit()"><svg class="glyph stroked notepad"><use xlink:href="#stroked-notepad"></use></svg> Lista de usuários </a></li>
                                    <input type="hidden" name="tarefa" value="ListaUsuario"> 
                            </ul>
                            </form>
                        </li>
                            <form name="CadastrarBanca" method="POST" action="Executa">
                            <ul class="nav menu">
                                    <li><a href="javascript:document.CadastrarBanca.submit()"><svg class="glyph stroked calendar blank"><use xlink:href="#stroked-calendar-blank"></use></svg> Cadastrar banca</a></li>
                                    <input type="hidden" name="tarefa" value="NovaBanca"> 
                            </ul>
                            </form>
                        <li>
                            <form name="ListarBanca" method="POST" action="Executa">
                                <ul class="nav menu">
                                    <li><a href="javascript:document.ListarBanca.submit()"><svg class="glyph stroked notepad"><use xlink:href="#stroked-notepad"></use></svg> Lista de bancas </a></li>
                                    <input type="hidden" name="tarefa" value="ListaBanca"> 
                                </ul>
                            </form>
                        </li>
                       </ul>

	</div><!--/.sidebar-->
        <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="home.html"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
                    <li class="active">Cadastro de banca</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Cadastro de banca examinadora</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="col-md-12">
                                <form data-toggle="validator" role="form" name='cadbanca' action='Executa' method="Post" >

                                    <div class="form-group">
                                        <label>Tema:</label>
                                        <input class="form-control" name="tema" maxlength="200" required>
                                        <div class="help-block with-errors"></div>
                                    </div>

                                    <div class="form-group">
                                        <label>Resumo:</label>
                                        <input class="form-control" name="resumo" maxlength="140" required>
                                        <div class="help-block with-errors"></div>
                                    </div>

                                    <div class="form-group">
                                        <label>Data:</label>
                                        <input class="form-control" name="data"  required type='date'>
                                        <div class="help-block with-errors"></div>
                                    </div>

                                    <div class="form-group">
                                        <label>Horário:</label>
                                        <input class="form-control" name="hora"  required type='time'>
                                        <div class="help-block with-errors"></div>
                                    </div>

                                    <div class="form-group">
                                        <label>Curso:</label>
                                        <select class="form-control" name="curso">
                                            <option>Selecione o curso</option>
                                            <option value="Licenciatura em Matemática">Licenciatura em Matemática</option>
                                            <option value="Tecnologia em Análise e Desenvolvimento de Sistemas">Tecnologia em Análise e Desenvolvimento de Sistemas</option>
                                            <option value="Tecnologia em Automação Industrial">Tecnologia em Automação Industrial</option>
                                            <option value="Bacharel em Engenharia de Controle e Automação">Bacharel em Engenharia de Controle e Automação</option>
                                        </select>
                                    </div>     

                                    <div class="form-group">
                                        <label>Integrantes:</label>
                                        <table class="table"> 
                                            <thead> 
                                                <tr> 
                                                    <th>Nome</th> 
                                                    <th>Email</th>
                                                    <th>Celular</th>
                                                    <th colspan="2"></th>
                                                </tr> 
                                            </thead> 
                                            <tbody>
                                                <c:forEach var="usuario" items='${integrantes}'>
                                                    <tr> 
                                                        <td><c:out value="${usuario.getNome()}"></c:out></td> 
                                                        <td><c:out value="${usuario.getEmail()}"></c:out></td> 
                                                        <td><c:out value="${usuario.getCelular()}"></c:out></td> 
                                                        <td><input type='checkbox' name='selecionados[]' value="${usuario.getId()}"></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>  

                                    <button type="submit" class="btn btn-primary">Enviar</button>
                                    <input type="hidden" name="tarefa" value="SalvaBanca"> 

                                </form>

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

                $(document).ready(function () {
                    $('#texto').bind('cut copy paste', function (event) {
                        event.preventDefault();
                    });
                });

                $("#telefone").mask("(00) 00000-0000");



            </script>
            <script src="js/validator.min.js"></script>

    </body>

</html>
